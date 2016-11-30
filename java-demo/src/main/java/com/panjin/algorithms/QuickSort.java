/**
 * Copyright (c) 2011-2016 All Rights Reserved.
 */
package com.panjin.algorithms;

/**
 * 
 * 基本思想
 * 1、对数组进行随机化。
 * 2、从数列中取出一个数作为中轴数(pivot)。
 * 3、将比这个数大的数放到它的右边，小于或等于它的数放到它的左边。
 * 4、再对左右区间重复第三步，直到各区间只有一个数。
 * @author panjin
 * @version $Id: QuickSort.java 2016年11月30日 上午10:05:44 $
 */
public class QuickSort {
    
    private static int cuttoff = 10;

    /**
     * 快速排序的划分过程
     * 
     * @param array 待划分的数组
     * @param low 最左侧位置
     * @param high 最右侧位置
     * @return 中间元素位置
     */
    private static int partition(int[] array, int low, int high) {
        int i = low, j = high + 1;
        while(true) {
            // 从左至右扫描，如果碰到比基准元素array[low]小，则该元素已经位于正确的分区，i自增，继续比较i+1；
            // 否则，退出循环，准备交换
            while (array[++i] < array[low]) {
                if (i == high) {
                    // 如果扫描到了最右端，退出循环
                    break;
                }
            }
            
            // 从右自左扫描，如果碰到比基准元素array[low]大，则该元素已经位于正确的分区，j自减，继续比较j-1
            // 否则，退出循环，准备交换
            while (array[--j] > array[low]) {
                if (j == low) {
                    // 如果扫描到了最左端，退出循环
                    break;
                }
            }
            
            // 如果相遇，退出循环
            if (i >= j) {
                break;
            }
            
            //交换左a[i],a[j]右两个元素，交换完后他们都位于正确的分区
            swap(array, i, j);
        }
        
        // 经过相遇后，最后一次a[i]和a[j]的交换
        // a[j]比a[low]小，a[i]比a[low]大，所以将基准元素与a[j]交换
        swap(array, low, j);
        // 返回扫描相遇的位置点
        return j;
    }
    
    private static void swap(int[] array, int i, int j) {
        Integer temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }
    
    public static void sort(int[] array) {
        sort(array, 0, array.length -1);
    }
    
    private static void sort(int[] array, int low, int high) {
        if (low >= high) return;
        
        // 对于小序列，直接采用插入排序
//        if (high - low <= cuttoff -1) {
//            InsertionSort.sort(array);
//            return;
//        }
        
        // 采用三平均分区法查找中轴(属于算法优化)
        int middle = medianOf3(array, low, low + (high - low) / 2, high);
        swap(array, low, middle);
        
        // 划分，划分完成之后，分为左右序列，左边所有元素小于array[index]，右边所有元素大于array[index]
        int index = partition(array, low, high);
        // 对左右子序列进行排序完成之后，整个序列就有序了
        // 对左边序列进行递归排序
        sort(array, low, index-1);
        // 对右边序列进行递归排序
        sort(array, index+1, high);
    }
    
    /**
     * 查找三个元素中位于中间的那个元素
     */
    private static int medianOf3(int[] array, int low, int center, int high) {
        return (array[low] < array[center]) ? ((array[center] < array[high]) ? center : (array[low] < array[high]) ? high : low)
                : ((array[high] < array[center]) ? center : (array[high] < array[low]) ? high : low);
    }

    public static void main(String[] args) {
        int[] array = new int[]{9, 10, 2, 34, 4, 5, 80, 3, 4, 21, 1, 35};
        sort(array);
        for (Integer integer : array) {
            System.out.print(integer + ", ");
        }
    }

}
