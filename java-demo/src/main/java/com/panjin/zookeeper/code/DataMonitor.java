/**
 * Copyright (c) 2011-2016 All Rights Reserved.
 */
package com.panjin.zookeeper.code;

import java.util.Arrays;
import java.util.Date;

import org.apache.zookeeper.AsyncCallback.StatCallback;
import org.apache.zookeeper.KeeperException;
import org.apache.zookeeper.KeeperException.Code;
import org.apache.zookeeper.WatchedEvent;
import org.apache.zookeeper.Watcher;
import org.apache.zookeeper.ZooKeeper;
import org.apache.zookeeper.data.Stat;

/**
 *
 *
 * @author panjin
 * @version $Id: DataMonitor.java 2016年12月21日 下午4:32:50 $
 */
public class DataMonitor implements Watcher, StatCallback {

    ZooKeeper zk;
    String znode;
    Watcher chainedWatcher;
    boolean dead;
    DataMonitorListener listener;
    byte prevData[];

    public DataMonitor(ZooKeeper zk, String znode, Watcher chainedWatcher, DataMonitorListener listener) {
        this.zk = zk;
        this.znode = znode;
        this.chainedWatcher = chainedWatcher;
        this.listener = listener;
        // Get things started by checking if the node exists. We are going
        // to be completely event driven
        zk.exists(znode, true, this, null);
    }

    @Override
    public void processResult(int rc, String path, Object ctx, Stat stat) {
        boolean exists;

        System.out.println("STAT CALL BACK");
        System.out.println("rc " + rc);
        System.out.println("path " + path);
        System.out.println("ctx " + ctx);
        System.out.println("stat " + stat);
        switch (rc) {
        case Code.Ok:
            exists = true;
            break;
        case Code.NoNode:
            // 删除结点的时候
            exists = false;
            break;
        case Code.SessionExpired:
        case Code.NoAuth:
            dead = true;
            listener.closing(rc);
            return;
        default:
            // Retry errors
            zk.exists(znode, true, this, null);
            return;
        }

        byte b[] = null;
        if (exists) {
            try {
                b = zk.getData(znode, false, null);
            } catch (KeeperException e) {
                // We don't need to worry about recovering now. The watch
                // callbacks will kick off any exception handling
                e.printStackTrace();
            } catch (InterruptedException e) {
                return;
            }
            System.out.println("GET DATA OF " + new String(b));
            System.out.println("GET DATA END ");
        }
        if ((b == null && b != prevData) || (b != null && !Arrays.equals(prevData, b))) {
            listener.exists(b);
            prevData = b;
        }
    }

    @Override
    public void process(WatchedEvent event) {
        String path = event.getPath();
        System.out.println("GOT EVENT " + event + " @" + new Date() + ",type is " + event.getType());
        if (event.getType() == Event.EventType.None) {
            switch (event.getState()) {
            case SyncConnected:
                break;
            case Expired:
                dead = true;
                listener.closing(KeeperException.Code.SessionExpired);
                break;
            case AuthFailed:
                break;
            case ConnectedReadOnly:
                break;
            case Disconnected:
                break;
            case NoSyncConnected:
                break;
            case SaslAuthenticated:
                break;
            case Unknown:
                break;
            default:
                break;
            }
        } else {
            if (path != null && path.equals(znode)) {
                zk.exists(znode, true, this, null);
            }
        }
        if (chainedWatcher != null) {
            chainedWatcher.process(event);
        }
    }

}
