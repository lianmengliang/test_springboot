package com.springboot.practiceDemo;

import com.springboot.utils.patternReplaceUtil;
import com.springboot.utils.stringReplaceUtil;

/**
 * @Author ： leo
 * @Date :2019/9/17 16:21
 */
public class testRepalceUtils {
    public static void main(String[] args) {
        String a = "<<<<<<<<<<<<<<<<<<<<<<<>>>>>>>>>>>>>>>>>>>>!@#$%^&*(()_+<<<<<<<<<<<<>>>>>>>>>>>>>#@!#!$%%$^&$%%(*&^%$";

      // getstringReplaceUtil(a);
        getpatternReplaceUtil(a);
    }

    public static void getstringReplaceUtil(String parameter) {
        long startTime = System.currentTimeMillis(); //获取开始时间
        stringReplaceUtil.getEscape(parameter);
        long endTime = System.currentTimeMillis(); //获取结束时间
        System.out.println("程序运行时间：" + (endTime - startTime) + "ms"); //输出程序运行时间   54ms

    }

    public static void getpatternReplaceUtil(String parameter) {
        long startTime = System.currentTimeMillis(); //获取开始时间
        patternReplaceUtil.getEscape(parameter);
        long endTime = System.currentTimeMillis(); //获取结束时间
        System.out.println("程序运行时间：" + (endTime - startTime) + "ms"); //输出程序运行时间   54ms
    }
}
