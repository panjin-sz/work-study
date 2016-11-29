/**
 * Copyright (c) 2011-2016 All Rights Reserved.
 */
package com.panjin.algorithms;

/**
 * 归并排序
 *1、申请空间，使其大小为两个已经排序序列之和，然后将待排序数组复制到该数组中。
 *2、设定两个指针，最初位置分别为两个已经排序序列的起始位置
 *3、比较复制数组中两个指针所指向的元素，选择相对小的元素放入到原始待排序数组中，并移动指针到下一位置
 *4、重复步骤3直到某一指针达到序列尾
 *5、将另一序列剩下的所有元素直接复制到原始数组末尾
 *
 * @author panjin
 * @version $Id: MergeSort.java 2016年11月29日 下午3:02:59 $
 */
public class MergeSort {

    private static int[] aux;// 用于排序的辅助数组

    public static void sort(int[] array) {
        aux = new int[array.length];
        sort(array, 0, array.length - 1);
    }

    public static void sort(int[] array, int low, int high) {
        if (low >= high)
            return;
        int middle = low + (high - low) / 2;
        sort(array, low, middle);
        sort(array, middle + 1, high);
        merge(array, low, middle, high);
    }

    public static void merge(int[] array, int low, int middle, int high) {
        int i = low, j = middle + 1;
        // 把元素拷贝到辅助数组中
        for (int k = low; k <= high; k++) {
            aux[k] = array[k];
        }
        // 然后按照规则将数据从辅助数组中拷贝回原始的array中
        for (int k = low; k <= high; k++) {
            // 如果左边元素没了， 直接将右边的剩余元素都合并到到原数组中
            if (i > middle) {
                array[k] = aux[j++];
            }// 如果右边元素没有了，直接将所有左边剩余元素都合并到原数组中
            else if (j > high) {
                array[k] = aux[i++];
            }// 如果左边右边小，则将左边的元素拷贝到原数组中
            else if (aux[i] < aux[j]) {
                array[k] = aux[i++];
            } else {
                array[k] = aux[j++];
            }
        }
    }

    public static void main(String[] args) {
        int[] array = new int[]{9, 10, 2, 34, 4, 5, 80, 3, 4, 21, 1, 35};
        sort(array);
        for (Integer integer : array) {
            System.out.print(integer + ", ");
        }
    }

}
