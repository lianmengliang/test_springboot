package com.springboot.entity;

import lombok.Data;

/**
 * @Author ： leo
 * @Date :2019/9/6 12:06
 */
@Data
public class Dish {
    //"宫保鸡丁", "糖醋鲤鱼", "重庆辣子鸡","回锅肉","水煮鱼"
    private int a ;
    private String name;



    public void getDishName(){


        System.out.println(1+"在吃宫保鸡丁");
    }


    private static void getDishInt(){

        System.out.println(1+"在吃酸菜鱼");
    }

}
