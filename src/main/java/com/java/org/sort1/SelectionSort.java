package com.java.org.sort1;

import org.junit.Test;

import java.util.Arrays;

/**
 * @author zqlu
 * @date 2019-02-19
 */
public class SelectionSort {


    /**
     * 选择排序
     * 思想：与选择排序类似，也分为已排序区间和未排序区间。
     * 不过，选择排序，每次从未排序区间选择最小的元素，将其放到已排序区间的末尾。
     *
     *
     */


    /**
     * 问题：
     * 1.选择排序是原地排序算法吗（空间复杂度）？
     *      选择的过程只涉及数据的交换操作，只需要常量级的临时空间，所以它的空间复杂度为 O(1)，是一个原地排序算法。
     * 2.选择排序是稳定的排序算法吗？
     *      选择排序也是比较并交换，但是与冒泡排序的交换不同，冒泡是相邻元素的。
     *      而选择排序是未排序区间最小的元素与未排序区间第一个元素交换，很容易改变相等元素的前后顺序。比如：
     *      [5，8，5，2，9]，第一次找到最小元素2，与第一个元素5进行交换，那么第一个5和中间的5顺序就变了，所以不稳定了。
     * 3.选择排序的时间复杂度？
     *      最好，最坏，平均时间复杂度都是O(n^2)。
     *      因为每次都要从未排序区间选择最小的元素，这是个线性方式的比较。所以，即使最好情况，n次选择排序，也要n^2次操作。
     */

    public void sort(int[] array) {

        for (int i = 0; i < array.length -1; i++) { // 每次从未排序区间取第一个元素
            int value = array[i];

            // 找出后面元素中最小的元素
            int j = i+1;
            int min = array[j];
            int index = j;
            for (; j < array.length -1; j++) {
                if (array[j+1] < min) {
                    min = array[j+1];
                    index = j+1;
                }
            }

            // 将未排序区间最小的元素值放到已排序区间的末尾, 也就是将最小的元素值与未排序区间的第一个元素交换
            if (min < value) {
                array[i] = min;
                array[index] = value;
            }

        }



//        int min = array[1];
//        int index = 1;
//        for (int i = 1; i < array.length-1; i++) { // 取「未排序区间」的元素，初始从第二个元素开始，第一个元素当作已排序区间的
//            // 找出未排序区间最小的元素
//            if (array[i+1] < min) {
//                min = array[i+1];
//                index = i+1;
//            }
//        }
//        System.out.println(min);
//        System.out.println(index);
    }

    @Test
    public void t1() {
        SelectionSort selectionSort = new SelectionSort();
        int[] array = new int[]{3, 2, 5, 1, 7, 4};
        selectionSort.sort(array);
        System.out.println(Arrays.toString(array));
    }
}
