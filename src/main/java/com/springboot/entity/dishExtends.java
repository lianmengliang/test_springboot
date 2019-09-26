package com.springboot.entity;

/**
 * @Author ： leo
 * @Date :2019/9/9 10:17
 */
public class dishExtends extends Dish {


    public static void main(String[] args) {
            dishExtends.getDishInt();
    }

    public void getDishName(){

        String name = getName();
        System.out.println(name);
        System.out.println(1+"在吃宫保鸡丁");
    }


    private static void getDishInt(){

        System.out.println(1+"在吃酸菜鱼");
    }
}
