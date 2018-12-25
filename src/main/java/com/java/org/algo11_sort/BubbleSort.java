package com.java.org.algo11_sort;

import org.junit.Test;

import java.util.Arrays;

/**
 * @author zqlu
 * @date 2018-12-25
 */
public class BubbleSort {


    /**
     * 冒泡排序（升序）
     * 思想:
     * 冒泡排序只会操作相邻元素。每次冒泡从第一个元素开始，如果满足大小关系，则进行交换。
     * 一次冒泡会至少将一个元素移动到它应该在的位置。第一次冒泡将最大的元素移动到末尾。
     * 重复n次就完成了n个数据的排序工作。
     *
     *
     * 1.最好情况下，所有数据刚好是有序的，只需要一次冒泡，时间复杂度 O(n)
     * 2.最坏情况下，要排序的数据刚好是倒序排列的，我们需要进行n次冒泡，时间复杂度O(n^2)
     * 3.平均时间复杂度：看逆序度；满有序度n(n-1)/2，最好情况下有序度是n(n-1)/2,那么逆序度为0；最坏情况下有序度为0，逆序度为n(n-1)/2
     * 那么平均逆序度为n(n-1)/4，也就是交换次数；
     * 平均时间复杂度即为O(n^2)
     * 4.逆序度 = 满有序度 - 有序度
     * 5.我们排序的过程就是一种增加有序度，减少逆序度的过程，最后达到满有序度，就说明排序完成了
     */


    /**
     * 问题：
     * 1.冒泡排序是原地排序算法吗（空间复杂度）？
     */

    public int[] sort(int[] array) {
        for (int i = 0; i < array.length; i++) { // 重复n次
            for (int j = 0; j < array.length-1-i; j++) { // 每次冒泡从索引为0开始，结束部分是未排序的倒数第二个
                if (array[j] > array[j+1]) {
                    int temp = array[j];
                    array[j] = array[j+1];
                    array[j+1] = temp;
                }
            }
        }

        return array;
    }

    public int[] sort2(int[] array) {
        for (int i = 0; i < array.length; i++) { // 重复n次
            boolean exit = true; // 能否退出的标志
            for (int j = 0; j < array.length-1-i; j++) { // 每次冒泡从索引为0开始，结束部分是未排序的倒数第二个
                if (array[j] > array[j+1]) {
                    int temp = array[j];
                    array[j] = array[j+1];
                    array[j+1] = temp;
                    exit = false;  // 一旦交换就不能退出
                }
            }
            //一次冒泡结束都没进行交换，则说明已经有序了，提前退出
            if (exit) break;
        }
        return array;
    }

    @Test
    public void t1() {
        BubbleSort bubbleSort = new BubbleSort();
        int[] array = new int[]{3, 2, 5, 1, 7, 4};
        int[] result = bubbleSort.sort(array);
        System.out.println(Arrays.toString(result));
    }



}
