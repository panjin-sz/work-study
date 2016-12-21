/**
 * Copyright (c) 2011-2016 All Rights Reserved.
 */
package com.panjin.zookeeper.code;

import java.io.IOException;

import org.apache.zookeeper.KeeperException;
import org.apache.zookeeper.WatchedEvent;
import org.apache.zookeeper.Watcher;
import org.apache.zookeeper.ZooKeeper;
import org.apache.zookeeper.data.Stat;

/**
 *
 *
 * @author panjin
 * @version $Id: App.java 2016年12月21日 下午4:16:00 $
 */
public class App {

    /**
     * 
     * @param args
     * @throws IOException 
     * @throws InterruptedException 
     * @throws KeeperException 
     */
    public static void main(String[] args) throws IOException, KeeperException, InterruptedException {
        ZooKeeper zk = new ZooKeeper("localhost:2181", 3000, new Watcher() {
            
            @Override
            public void process(WatchedEvent event) {
                System.out.println(event);
            }
        });
        Stat e = zk.exists("/vito_test", null);
        System.out.println("exists " + e);
        zk.setData("/vito_test", "data of node 1".getBytes(), -1);
    }

}
