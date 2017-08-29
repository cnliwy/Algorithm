package com.liwy.algorithm;

/**
 * 斐波那契数列
 * 斐波那契数列：1, 1, 2, 3, 5, 8, 13, 21, 34, 55, 89, 144, ...
 * 如果设F(n）为该数列的第n项（n∈N*），那么这句话可以写成如下形式：:F(n)=F(n-1)+F(n-2)
 * Created by liwy on 2017/8/29.
 */

public class FbAlgorithm {
    public static int calculateFb(int number){
        int n2 = 1;
        int n1 = 1;
        if(number == 1){
            return n2;
        }else if (number == 2){
            return n1;
        }else if (number > 2){
            int result = 0;
            for (int i = 3; i <= number; i++){
                result = n1 + n2;
                System.out.println("i=" + i + ",n2=" + n2 + ",n1=" + n1 + ",result=" + result);
                n2 = n1;
                n1 = result;
            }
            return result;
        }else{
            return -1;
        }
    }
}
