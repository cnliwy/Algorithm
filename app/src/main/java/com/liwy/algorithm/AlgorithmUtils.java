package com.liwy.algorithm;

/**
 * Created by liwy on 2017/9/1.
 */

public class AlgorithmUtils {
    /**
     * 水仙花：指一个三位数，其各位数字立方和等于该数本身
     */
    public static void getShuixianhua(){
        for (int i= 100; i <= 999; i++){
            // 分别获取一个三位数的百位十位各位的数字
            int x = i / 100;
            int y = (i%100)/10;
            int z = i % 10;
//            System.out.println(i + ": " + x + "," + y + "," + z);
            if ((Math.pow(x,3) + Math.pow(y,3) + Math.pow(z,3)) == i){
                  System.out.println(i + " = " + x + "," + y + "," + z);
            }
        }
    }

    public static void main(String[] args) {
//        getShuixianhua();
        int index = getSubIndex("helmhelloworld","hell");
        System.out.println("子字符串的位置="+ index);
    }

    /**
     * 获取匹配的子字符串的位置
     * @param src
     * @param sub
     * @return
     */
    public static int getSubIndex(String src,String sub){
        int i = 0,j = 0;
        int index = -1;
        while (i < src.length() && j < sub.length()){
            if (src.charAt(i) == sub.charAt(j)){
                i++;
                j++;
                System.out.println(i + "," + j);
            }else{
                // 保证i的值在匹配不成功时不断向后+1 j其实表示已经成功匹配的字符数，
                i = i - j + 1;
                j = 0;
                System.out.println(i + "," + j);
            }
        }
        if (j == sub.length()){
            index = i - sub.length(); // 此处表示在index处开始匹配，并且后面完全匹配成功
        }
        return index;
    }
}
