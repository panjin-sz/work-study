package com.panjin.util;

import java.io.File;

public final class FileTools {

    public static final String DOT = ".";

    /**
     * 获取文件扩展名,如“.html”
     * 
     * @param file
     * @return
     */
    public static final String getExpandedName(File file) {
        String name = file.getName();
        return getExpandedName(name);
    }

    /**
     * 获取文件扩展名
     * 
     * @param file
     * @return
     */
    public static final String getExpandedName(String name) {
        return name.substring(name.lastIndexOf(DOT) + 1);
    }

    /**
     * 获取文件名
     * 
     * @param file
     * @return
     */
    public static final String getNameExcludeExpandedName(File file) {
        String name = file.getName();
        return getNameExcludeExpandedName(name);
    }

    /**
     * 获取文件名
     * 
     * @param file
     * @return
     */
    public static final String getNameExcludeExpandedName(String name) {
        return name.substring(0, name.lastIndexOf(DOT));
    }

}
