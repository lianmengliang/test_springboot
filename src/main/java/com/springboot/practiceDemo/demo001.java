package com.springboot.practiceDemo;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

/**
 * @Author ： leo
 * @Date :2019/9/2 16:31
 */
public class demo001 {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        System.out.println("请输入开通VIP的时间");
        String VIPData = sc.next();//获取出生日期
        SimpleDateFormat s = new SimpleDateFormat("yyyy-MM-dd");//字符串转换成date类型
        Date d = null;

        try {
            d = s.parse(VIPData);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        Date now = new Date();//获取当前时间

        //将当前date时间转换成毫秒
        long nowTime = now.getTime();
        //将开通VIP的日期转换成毫秒
        long bornTime = d.getTime();

        //当前时间的毫秒减掉开通时间时间的毫秒就是开通多久的的毫秒数
        long time = nowTime - bornTime;
        //根据毫秒判断开通日期与否，出生了就将毫秒时间转换成天数，一秒=一千毫秒，一分钟有60秒，一小时60分，一天24小时
        long trueTime = time / 1000 / 60 / 60 / 24;
        System.out.println(trueTime);

        if (0 < trueTime && trueTime <= 30) {
            System.out.println("VIP1:享受10%经验和金币的加成");
        } else if (30 < trueTime && trueTime <= 50) {
            System.out.println("VIP2:享受50%经验和金币的加成");
        } else if (50 < trueTime && trueTime <= 80) {
            System.out.println("VIP3:享受100%经验和金币的加成");
        } else if (trueTime > 50) {
            System.out.println("VIP4:享受200%经验和金币的加成");
        }

        // 2019-8-29 2019-8-29
        //VIP1:享受10%经验和金币的加成

    }
}
