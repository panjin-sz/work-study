/**
 * Copyright (c) 2011-2016 All Rights Reserved.
 */
package com.panjin.zookeeper.code;

/**
 *
 *
 * @author panjin
 * @version $Id: DataMonitorListener.java 2016年12月21日 下午4:27:15 $
 */
public interface DataMonitorListener {

    /**
     * The existence status of the node has changed.
     * 
     * @param data
     */
    void exists(byte data[]);
    
    /**
     * The zookeeper session is no longer valid.
     * 
     * @param rc the zookeeper reason code
     */
    void closing(int rc);
}
