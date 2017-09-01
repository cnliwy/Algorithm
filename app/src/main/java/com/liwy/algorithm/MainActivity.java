package com.liwy.algorithm;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.MotionEvent;
import android.widget.TextView;

import com.liwy.algorithm.recyclerview.MenuAdapter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import static android.icu.lang.UCharacter.GraphemeClusterBreak.L;

public class MainActivity extends AppCompatActivity {
    TextView resultTv;
    RecyclerView recyclerView;
    String[] menus = {"二分查找","斐波那契","素数","哈希算法","水仙花","2","3"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        resultTv = (TextView)findViewById(R.id.tv_result);
        initView();
    }
    public void initView(){
        recyclerView = (RecyclerView)findViewById(R.id.recycler);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        List<String> list = new ArrayList<>();
        for (String str : menus){
            list.add(str);
        }
        MenuAdapter adapter = new MenuAdapter(list,this);
        adapter.setOnItemClickListener(new MenuAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(int position) {
                click(position);
            }
        });
        recyclerView.setAdapter(adapter);
    }
    public void click(int position){
        switch (position){
            case 0:
                binarySearch();
                break;
            case 1:
                getFbnumber(5);
                break;
            case 2:
                printZhishu(10);
                break;
            case 3:
                getHashCode("李威亚");
                break;
            case 4:
                AlgorithmUtils.getShuixianhua();
                break;
            default:
                break;
        }
    }
    // 二分查找
    public void binarySearch(){
        int[] arr = { 3,5,11,17,21,23,28,30,32,50,64,78,81,95,101};
        int findKey = 3;
//        int resultIndex = BinarySearchAlgorithm.binarySearch(arr,findKey);
//        int resultIndex = BinarySearchAlgorithm.binarySearch2(arr,findKey,0,arr.length-1);
        int resultIndex = BinarySearchAlgorithm.binarySearch3(arr,findKey,0,arr.length-1);
        System.out.println("要查找的值的位置在：" + resultIndex);
    }

    // 斐波那契数列
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

    /**
     * 计算字符串的hash值
     * @return
     */
    public int getHashCode(){
        String value = "liwy";
        System.out.println("string hashcode = " + value.hashCode());
        int a = (int)'l';
        int b = 31*a + (int)'i';
        int c = 31*b + (int)'w';
        int d = 31*c + (int)'y';
        int newhashcode = d;
        System.out.println("new hashcode = " + newhashcode);
        resultTv.setText("string hashcode = " + value.hashCode() + " ,new hashcode = " + newhashcode);
        return newhashcode;
    }
    public void getHashCode(String value){
        int hash = 0;
        int h = 0;
        int count = value.length();
        if (h == 0 && count > 0){
            for (int i = 0; i < count; i++){
                h = 31*h + value.charAt(i);
            }
            hash = h;
        }
        resultTv.setText("string hashcode = " + value.hashCode() + " ,new hashcode = " + hash);
    }
}
