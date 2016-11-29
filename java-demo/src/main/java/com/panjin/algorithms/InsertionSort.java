/**
 * Copyright (c) 2011-2016 All Rights Reserved.
 */
package com.panjin.algorithms;

/**
 * 插入排序
 *1、从第一个元素开始，该元素可以认为已经被排序
 *2、取出下一个元素，在已经排序的元素序列中从后向前扫描
 *3、如果该元素小于前面的元素（已排序），则依次与前面元素进行比较如果小于则交换，直到找到大于该元素的就则停止；
 *4、如果该元素大于前面的元素（已排序），则重复步骤2
 *5、重复步骤2~4 直到所有元素都排好序 。
 *
 * @author panjin
 * @version $Id: InsertionSort.java 2016年11月29日 上午10:17:19 $
 */
public class InsertionSort {

    public static void sort(Integer[] array) {
        int length = array.length;
        int time = 0;
        for (int i = 1; i < length; i++) {
            for (int j = i; j > 0; j--) {
                time++;
                if (array[j].compareTo(array[j - 1]) < 0) {
                    swap(array, j , j -1);
                } else {
                    break;
                }
            }
        }
        System.out.println("run time is " + time);
    }
    
    private static void swap(Integer[] array, int i, int j) {
        Integer temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }
    
    /**
     * 
     * @param args
     */
    public static void main(String[] args) {
        Integer[] array = new Integer[]{9, 10, 2, 34, 4, 5, 80, 3, 4, 21, 1, 35};
        sort(array);
        for (Integer integer : array) {
            System.out.print(integer + ", ");
        }
    }

//    /** 
//     * @see java.lang.Comparable#compareTo(java.lang.Object)
//     */
//    @Override
//    public int compareTo(T o) {
//        return this.hashCode() - o.hashCode();
//    }

}
