/**
 * Copyright (c) 2011-2016 All Rights Reserved.
 */
package com.panjin.algorithms;

/**
 * 选择排序
 *1、从左至右遍历，找到最小(大)的元素，然后与第一个元素交换。
 *2、从剩余未排序元素中继续寻找最小（大）元素，然后与第二个元素进行交换。
 *3、以此类推，直到所有元素均排序完毕。
 * 总共需要遍历n乘以n-1再除以2次，时间复杂度n的平方，空间复杂度为1，稳定：否
 * 
 * @author panjin
 * @version $Id: SelectionSort.java 2016年11月29日 上午9:14:34 $
 */
public class SelectionSort<T> implements Comparable<T> {

    /** 
     * @see java.lang.Comparable#compareTo(java.lang.Object)
     */
    @Override
    public int compareTo(T o) {
        return this.hashCode() - o.hashCode();
    }

    public static void sort(Integer[] array) {
        int length = array.length;
        int time = 0;
        for (int i = 0; i < length; i++) {
            int min = i;
            for(int j = i+1; j < length; j++) {
                if (array[min].compareTo(array[j]) > 0) {
                    min = j;
                }
                time++;
            }
            
            swap(array, i, min);
        }
        System.out.println("run time is " + time);
    }

    private static void swap(Integer[] array, int i, int min) {
        Integer temp = array[i];
        array[i] = array[min];
        array[min] = temp;
    }
    
    public static void main(String[] args) {
        Integer[] array = new Integer[]{9, 10, 2, 34, 4, 5, 80, 3, 4, 21, 1, 35};
        sort(array);
        for (Integer integer : array) {
            System.out.print(integer + ", ");
        }
    }
}
