package com.springboot.practiceDemo1;

import lombok.Data;

import java.util.Arrays;
import java.util.List;

/**
 * @Author ： leo
 * @Date :2019/9/19 17:45
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

    public ShopCar(int id, int sellerId, String sellerName, String goodsName, int buyerId, String buyerName, int num) {
        this.id = id;
        this.sellerId = sellerId;
        this.sellerName = sellerName;
        this.goodsName = goodsName;
        this.buyerId = buyerId;
        this.buyerName = buyerName;
        this.num = num;
    }

    public ShopCar() {
    }

    public static void main(String[] args) {


        for (ShopCar shopCar : initShopCar()) {

            System.out.println(shopCar);
        }


    }
    // 初始化数据如下：
    public static List<ShopCar> initShopCar() {


        List<ShopCar> shopCars = Arrays.asList(
                new ShopCar(1, 1, "天猫", "华为手机", 1, "dingw", 5),
                new ShopCar(1, 2, "京东", "华为手机", 2, "ly", 2),
                new ShopCar(1, 1, "京东", "小米手机", 3, "zhl", 3),
                new ShopCar(1, 2, "1号店", "华为手机", 1, "dingw", 5),
                new ShopCar(1, 2, "天猫", "苹果手机", 1, "dingw", 2)
        );
        return shopCars;
    }
}