package com.springboot.entity;

import lombok.Data;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @Author ： leo
 * @Date :2019/9/6 14:18
 */
@Data
public class ShopCar {
    private int id;
    private int sellerId;
    private String sellerName;
    private String goodsName;
    private int buyerId;
    private String buyerName;
    private int num;


}