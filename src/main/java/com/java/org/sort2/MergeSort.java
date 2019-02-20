package com.java.org.sort2;

import org.junit.Test;

import java.util.Arrays;

/**
 * @author zqlu
 * @date 2019-02-20
 */
public class MergeSort {

    /**
     * 归并排序：
     * 如果要排序一个数组，我们先把数组从中间分成前后两部分，然后对前后两部分分别排序，再将排好序的两部分合并在一起，这样整个数组就有序了。
     * 归并排序使用分治思想。分治，顾名思义，就是分而治之，将一个大问题分解成小的子问题来解决。小的子问题解决了，大问题也就解决了。
     * 分治思想和递归思想很像，一般通过递归来实现。分治是一种解决问题的处理思想，递归是一种编程实现。
     *
     * 递归：分析得出递推公式，然后找到终止条件，最后将递推公式翻译成递归代码。所以，要想写出归并排序的代码，我们先写出归并排序的递推公式。
     *
     * 递归公式： sort(p...r) = sort(p...q) + sort(q+1...r);
     * 终止条件：p >= r，不能再继续分解
     *
     */
    
    
    /**
     * 问题：
     * 1.归并排序是原地排序算法吗（空间复杂度）？
     *      归并排序有个致命的缺点，那就是归并排序需要额外的存储空间，不是一个原地排序算法。当合并两个数组时，需要申请一个临时数组，所以空间复杂度是O(n).
     * 2.归并排序是稳定的排序算法吗？
     *      稳不稳定关键看merge函数，也就是合并部分。
     * 3.归并排序的时间复杂度？
     *      归并排序的复杂度取决于递归的时间复杂度。
     *      如果问题a可以分解成多个子问题b,c 那么a的时间复杂度可以表示成 T(a) = T(b) + T(c) + K
     *      K是将b和c的结果合并成a的结果所需要消耗的时间。
     *
     *      假设n个元素归并排序需要时间为T(n),分解成两个数组都需要的时间为T(n/2)。合并两个有序数组需要的时间复杂度为O(n).
     *      所以归并排序时间复杂度 T(n) = 2*T(n/2) + n;
     *      假设sort递归执行k次， 那么T(n) = 2^k * T(n/2^k) + k * n
     *      当n/2^k = 1时，不能再分解。k=log2n. T(n) = Cn + n*log2n = n*logxn
     *      所以归并排序的时间复杂度是 O(nlogn).
     *      归并排序的执行效率与原始数组的有序度无关，所以归并排序的时间复杂度是非常稳定的。最好，最坏，平均都是O(nlogn).
     */



    public int[] sort(int[] array) {
        int[] temp = sort0(array, 0, array.length - 1);
        System.arraycopy(temp, 0, array, 0, array.length);
        return array;
    }

    /**
     * 排序
     * @param array 数组
     * @param start 起始索引
     * @param end 结束索引
     * @return 有序的数组
     */
    private int[] sort0(int[] array, int start, int end) {

        //不能再分解时返回一个元素的数组
        if (start >= end) {
            return new int[]{array[start]};
        }

        int middle = (start + end) / 2;

        //对前后两部分分别进行排序，然后再合并
        int[] part1 = sort0(array, start, middle);
        int[] part2 = sort0(array, middle+1, end);
        array = merge(part1, part2);

        return array;
    }

    /**
     * 按一定次序合并数组
     * @param array1 有序数组1
     * @param array2 有序数组2
     * @return 有序的数组
     */
    private int[] merge(int[] array1, int[] array2) {
        // 临时素组
        int[] temp = new int[array1.length+array2.length];

        // 分别从两数组起始位置开始，谁先较小，先将谁的值放入临时数组；直到某一个数组到头，再将另一个数组依次填入临时数组
        int index1 = 0;
        int index2 = 0;
        int index = 0;
        do {

            if (array1[index1] < array2[index2]) {
                temp[index] = array1[index1];
                index1++;
            } else {
                temp[index] = array2[index2];
                index2++;
            }
            index++;

        } while (index1 != array1.length && index2 != array2.length);

        // 将剩余的元素依次填入临时数组
        if (index1 == array1.length) {
            for (int i = index2; i < array2.length; i++) {
                temp[index] = array2[i];
                index++;
            }
        } else {
            for (int i = index1; i < array1.length; i++) {
                temp[index] = array1[i];
                index++;
            }
        }

        return temp;
    }


    @Test
    public void t1() {
        MergeSort mergeSort = new MergeSort();
        int[] array = new int[]{3, 2, 5, 1, 7, 4};
        mergeSort.sort(array);
        System.out.println(Arrays.toString(array));
    }
}
