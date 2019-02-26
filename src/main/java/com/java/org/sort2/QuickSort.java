package com.java.org.sort2;

import org.junit.Test;

import java.util.Arrays;

/**
 * @author zqlu
 * @date 2019-02-22
 */
public class QuickSort {


    public void sort(int[] array) {
        sort0(array, 0, array.length-1);
    }


    private void sort0(int[] array, int start, int end) {

        // 递归退出条件
        if (start >= end) {
            return;
        }

        // 获取分区点下标，这样左边的元素都小于分区点元素，右边的元素都大于分区点元素
        int pivot = partition(array, start, end);

        // 再对分区点左右两部分用同样方式进行分区，最后就是有序的数组
        sort0(array, start, pivot-1);
        sort0(array, pivot+1, end);
    }

    /**
     * 获取分区点pivot下标, 左边的都是小于pivot, 右边的都大于pivot
     * @param array
     * @param start
     * @param end
     * @return 分区点在重分区后数组的下标
     */
    private int partition(int[] array, int start, int end) {
        // 一般默认取最后一个元素为分区点
        int pivot = end;

        // 牺牲存储空间，用两个临时数组保存，数组x保存小于pivot的元素，数组y保存大于pivot的元素
        int[] x = new int[array.length];
        int[] y = new int[array.length];

        int indexX = 0;
        int indexY = 0;

        for (int i = start; i <= end; i++) {
            int value = array[i];
            if (value < array[pivot]) {
                x[indexX] = value;
                indexX++;
            }
            if (value > array[pivot]) {
                y[indexY] = value;
                indexY++;
            }

        }


        // 从指定下标开始，按顺序拷贝元素
        int p = start;
        for (int i = 0; i < indexX; i++, p++) {
            array[p] = x[i];
        }
        array[p++] = array[pivot];
        for (int i = 0; i < indexY; i++, p++) {
            array[p] = y[i];
        }

        // 最后返回分区点在整个数组中的下标
        return start + indexX;
    }

    @Test
    public void t1() {

        QuickSort quickSort = new QuickSort();
        int[] array = new int[]{3, 2, 5, 1, 7, 4};
        quickSort.sort(array);
        System.out.println(Arrays.toString(array));
    }
}
