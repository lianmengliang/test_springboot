package com.springboot.practiceDemo;

import java.util.Arrays;
import java.util.Map;

import java.util.Comparator;

public class MD5Demo {
    public static void main(String[] args) {


        //定义字符串数组
        String [] strArr = {"abc","cd","abce","aea"};
        // 传统方法
        //匿名内部类
        Arrays.sort(strArr, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return Integer.compare(o2.length(),o1.length());
            }
        });
        //输出排序结果
        for (String s : strArr) {
            System.out.println(s);
        }
        // Lambda 表达式
            Arrays.sort(strArr,(s1,s2) ->Integer.compare(s2.length(),s1.length()));
        //输出排序结果
        for (String s : strArr) {
            System.out.println(s);
        }
    }
}
