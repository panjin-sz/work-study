/**
 * Copyright (c) 2011-2016 All Rights Reserved.
 */
package com.panjin.zookeeper.code;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import org.apache.zookeeper.KeeperException;
import org.apache.zookeeper.WatchedEvent;
import org.apache.zookeeper.Watcher;
import org.apache.zookeeper.ZooKeeper;

/**
 *
 *
 * @author panjin
 * @version $Id: Executor.java 2016年12月21日 下午5:03:16 $
 */
public class Executor implements Watcher, Runnable, DataMonitorListener {

    String znode;
    DataMonitor dm;
    ZooKeeper zk;
    String exec[];
    Process child;
    
    public static void main(String[] args) {
        args = new String[] {"localhost:2181", "/vito_test"};

        String hostPort = args[0];
        String znode = args[1];
        String exec[] = new String[] {"date"};
        try {
            new Executor(hostPort, znode, exec).run();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public Executor(String hostPort, String znode, String exec[]) throws KeeperException, IOException {
        this.exec = exec;
        zk = new ZooKeeper(hostPort, 3000, this);
        dm = new DataMonitor(zk, znode, null, this);
    }

    static class StreamWriter extends Thread {

        OutputStream os;
        InputStream is;

        StreamWriter(InputStream is, OutputStream os) {
            this.is = is;
            this.os = os;
            start();
        }

        public void run() {
            byte b[] = new byte[80];
            int rc;
            try {
                System.out.println("===========START TO WRITE===========");
                while ((rc = is.read(b)) > 0) {
                    os.write(b, 0, rc);
                }
                System.out.println("===========STOP TO WRITE===========");
            } catch (IOException e) {
            }

        }
    }

    /**
     * @see com.panjin.zookeeper.code.DataMonitorListener#exists(byte[])
     */
    @Override
    public void exists(byte[] data) {
        if (data == null) {
            if (child != null) {
                System.out.println("Killing process");
                child.destroy();
                try {
                    child.waitFor();
                } catch (InterruptedException e) {
                }
            }
            child = null;
        } else {
            if (child != null) {
                System.out.println("Stopping child");
                child.destroy();
                try {
                    child.waitFor();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            System.out.println("===SHOW DATA===");
            System.out.println(new String(data));
            try {
                System.out.println("Starting child");
                child = Runtime.getRuntime().exec(exec);
                new StreamWriter(child.getInputStream(), System.out);
                new StreamWriter(child.getErrorStream(), System.err);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * @see com.panjin.zookeeper.code.DataMonitorListener#closing(int)
     */
    @Override
    public void closing(int rc) {
        synchronized (this) {
            System.out.println("===========EXECUTOR START TO NOTIFY ALL===========");
            notifyAll();
            System.out.println("===========EXECUTOR START TO NOTIFY ALL===========");
        }
    }

    /**
     * @see java.lang.Runnable#run()
     */
    @Override
    public void run() {
        try {
            synchronized (this) {
                while (!dm.dead) {
                    System.out.println("===========EXECUTOR START TO WAIT===========");
                    wait();
                    System.out.println("===========EXECUTOR STOP WAIT===========");
                }
            }
        } catch (InterruptedException e) {
        }
    }

    /**
     * @see org.apache.zookeeper.Watcher#process(org.apache.zookeeper.WatchedEvent)
     */
    @Override
    public void process(WatchedEvent event) {
        dm.process(event);
    }

}
