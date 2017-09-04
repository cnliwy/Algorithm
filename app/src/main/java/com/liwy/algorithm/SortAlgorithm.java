package com.liwy.algorithm;

import java.util.Arrays;

/**
 * Created by liwy on 2017/9/4.
 */

public class SortAlgorithm {
    /**
     * 冒泡排序
     * 比较相邻的元素。如果第一个比第二个大，就交换他们两个。
     * 对每一对相邻元素作同样的工作，从开始第一对到结尾的最后一对。在这一点，最后的元素应该会是最大的数。
     * 针对所有的元素重复以上的步骤，除了最后一个。
     * 持续每次对越来越少的元素重复上面的步骤，直到没有任何一对数字需要比较。
     */
    public static void bubbleSort(){
        int[] data = {9,1,3,5,8,6,2,4,7};
        int length = data.length;
        for (int i = 0; i < length - 1; i++){
            for (int j = 0; j < length - i - 1; j++){
                if (data[j] > data[j + 1]){
                    swap(data,j,j + 1);
                }
            }
        }
        System.out.println("冒泡排序结果：" + Arrays.toString(data));
    }

    /**
     * 快速排序
     */
    public static void quickSort(){

        System.out.println("快速排序结果：");
    }

    public static void swap(int[] a, int i, int j){
        int mid = a[i];
        a[i] = a[j];
        a[j] = mid;
    }
}
