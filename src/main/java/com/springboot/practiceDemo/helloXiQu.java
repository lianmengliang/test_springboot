package com.springboot.practiceDemo;


import java.util.Random;
import java.util.Scanner;

public class helloXiQu {
    public static void main(String[] args) {

        //100以内 随机产生一个数字
        Random random = new Random();
        int anInt = random.nextInt(100);
        Scanner scanner = new Scanner(System.in);
        int count = 0;  //计数
        System.out.println("猜一个数字：");
        while (true){
            int cai = scanner.nextInt();
            count++;
            if(cai==anInt){
                System.out.println("恭喜你，回答正确！");
                System.out.println("您一共猜了"+count+"次");
                break;
            }else{
                if(cai<anInt){
                    System.out.println("太小了，继续猜。。。");
                }else{
                   System.out.println("太大了，继续猜。。。");
                }
            }
        }

    }
}
