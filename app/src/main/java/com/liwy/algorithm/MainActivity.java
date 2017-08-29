package com.liwy.algorithm;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    TextView resultTv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        resultTv = (TextView)findViewById(R.id.tv_result);
//        search2();
//        getFbnumber(9);
        printZhishu(20);
    }

    public void search2(){
        int[] arr = { 3,5,11,17,21,23,28,30,32,50,64,78,81,95,101};
        int findKey = 3;
//        int resultIndex = BinarySearchAlgorithm.binarySearch(arr,findKey);
//        int resultIndex = BinarySearchAlgorithm.binarySearch2(arr,findKey,0,arr.length-1);
        int resultIndex = BinarySearchAlgorithm.binarySearch3(arr,findKey,0,arr.length-1);
        System.out.println("要查找的值的位置在：" + resultIndex);
    }

    public void getFbnumber(int index){
        int result = FbAlgorithm.calculateFb(index);
        String str = "第" + index + "位的值=" + result;
        System.out.println(str);
        resultTv.setText(str);
    }

    /**
     * 质数（prime number）又称素数，有无限个。质数定义为在大于1的自然数中，除了1和它本身以外不再有其他因数，这样的数称为质数。
     * 输出1-number之间所有的质数
     * @param number
     */
    public void printZhishu(int number){
        for(int i = 2; i <= number; i++){
            boolean flag = true;
            for (int j = 2; j <= i/2; j++){
                if (i%j==0){
                    flag = false;
                    break;
                }
            }
            if (flag){
                System.out.println(i + "是质数");
            }
        }
    }
}
