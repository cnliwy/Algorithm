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
        getFbnumber(9);
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
}
