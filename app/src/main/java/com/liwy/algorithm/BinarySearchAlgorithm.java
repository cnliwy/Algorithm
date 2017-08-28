package com.liwy.algorithm;

/**
 * 二分查找算法
 * 算法思想：又叫折半查找，要求待查找的序列有序。
 * 每次取中间位置的值与待查关键字比较，如果中间位置的值比待查关键字大，则在前半部分循环这个查找的过程，
 * 如果中间位置的值比待查关键字小，则在后半部分循环这个查找的过程。
 * 直到查找到了为止，否则序列中没有待查的关键字。
 * Created by liwy on 2017/8/28.
 */

public class BinarySearchAlgorithm {
    /**
     * 二分查找法（折半查找）需在有序集合的基础上进行查找
     * 循环二分查找法
     * @param arr
     * @param key
     * @return
     */
    public static int binarySearch1(int[] arr,int key){
        int mid = arr.length/2;
        int count = 1;
        if (arr[mid] == key){
            return mid;
        }
        int start = 0;
        int end = arr.length - 1;
        while (start <= end){
            System.out.println("查找了" + count + "次！");
            mid = (end + start)/2;
            if (key < arr[mid]){
                end = mid - 1;
            }else if (key > arr[mid]){
                start = mid + 1;
            }else{
                return  mid;
            }
            count ++;
        }
        return -1;
    }

    /**
     * 递归二分查找法
     * @param arr
     * @param key
     * @param start
     * @param end
     */
    public static int binarySearch2(int[] arr,int key,int start,int end){
        System.out.println("二分查找中");
        int mid = (start + end)/2;
        int midValue = arr[mid];
        if (key == midValue){
            return mid;
        }
        if (start <= end){
            if (key > midValue){
                start = mid + 1;
            }else if (key < midValue){
                end = mid - 1;
            }else{
                return mid;
            }
            return binarySearch2(arr,key,start,end);
        }else{
            return -1;
        }
    }

    /**
     * 精简递归二分查找法
     * @param arr
     * @param key
     * @param start
     * @param end
     * @return
     */
    public static int binarySearch3(int[] arr,int key,int start,int end){
        int mid = (start + end)/2;
        int midValue = arr[mid];
        System.out.println("二分查找中,midValue = "+ midValue);
        if (midValue == key){
            return mid;
        }
        if (start > end){
            return  -1;
        }else if (key > midValue){
            return binarySearch3(arr,key,mid + 1,end);
        }else if (key < midValue){
            return binarySearch3(arr,key,start,mid - 1);
        }
        return -1;
    }
}
