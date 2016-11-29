/**
 * Copyright (c) 2011-2016 All Rights Reserved.
 */
package com.panjin.algorithms;

/**
 * 时间复杂度 最好：n，平均：nlog2n或者n3/2，最差：依赖于增量递减序列目前最好的是 nlog2n
 * 空间复杂度 1 稳定：否
 * 实验表明，对于中型的序列( 万)，希尔排序的时间复杂度接近最快的排序算法的时间复杂度nlogn。
 * @author panjin
 * @version $Id: ShellSort.java 2016年11月29日 下午2:35:16 $
 */
public class ShellSort {

    /**
     * 希尔排序也称之为递减增量排序，他是对插入排序的改进。在第二部插入排序中，我们知道，插入排序对于近似已排好序的序列来说，
     * 效率很高，可以达到线性排序的效率。但是插入排序效率也是比较低的，他一次只能将数据向前移一位。比如如果一个长度为N的序列，
     * 最小的元素如果恰巧在末尾，那么使用插入排序仍需一步一步的向前移动和比较，要N-1次比较和交换。
     * <p>
     * 希尔排序通过将待比较的元素划分为几个区域来提升插入排序的效率。这样可以让元素可以一次性的朝最终位置迈进一大步，
     * 然后算法再取越来越小的步长进行排序，最后一步就是步长为1的普通的插入排序的，但是这个时候，
     * 整个序列已经是近似排好序的，所以效率高。
     * 
     * @param array
     */
    public static void sort(Integer array[]) {
        int length = array.length;
        int step = 1;
        while (step < length / 3) step = step * 3 + 1;
        int time = 0;
        while (step >= 1) {
            for (int i = 1; i < length; i++) {
                // 从第i个元素开始，依次次和前面已经排好序的i-step个元素比较，如果小于，则交换
                for (int j = i; j >= step; j = j - step) {
                    time++;
                    if (array[j].compareTo(array[j - step]) < 0) {
                        swap(array, j , j - step);
                    } else {// 如果大于，则不用继续往前比较了，因为前面的元素已经排好序，比较大的大就是较大的了
                        break;
                    }
                }
            }
            step = step / 3;
        }
        System.out.println("run time is " + time);
    }
    
    private static void swap(Integer[] array, int i, int j) {
        Integer temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }
    
    public static void main(String[] args) {
        Integer[] array = new Integer[]{9, 10, 2, 34, 4, 5, 80, 3, 4, 21, 1, 35};
        sort(array);
        for (Integer integer : array) {
            System.out.print(integer + ", ");
        }
    }

}
