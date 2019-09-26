package com.springboot.practiceDemo;

import com.springboot.entity.ShopCar;

import java.util.*;
import java.util.stream.Collectors;
/**
 * @Author ： leo
 * @Date :2019/9/6 14:24
 */
public class testShopCar {
    public static void main(String[] args) {
        ShopCar shopCar = new ShopCar();
        shopCar.setId(1);
        shopCar.setSellerId(1);
        shopCar.setSellerName("天猫");
        shopCar.setGoodsName("华为手机");
        shopCar.setBuyerId(1);
        shopCar.setBuyerName("leo");
        shopCar.setNum(5);

        /*private int id;
           private int sellerId;*/
        ShopCar shopCar1 = new ShopCar();
        shopCar1.setId(1);
        shopCar1.setSellerId(2);
        shopCar1.setSellerName("京东");
        shopCar1.setGoodsName("华为手机");
        shopCar1.setBuyerId(2);
        shopCar1.setBuyerName("kevin");
        shopCar1.setNum(2);

        ShopCar shopCar2 = new ShopCar();
        shopCar2.setId(1);
        shopCar2.setSellerId(1);
        shopCar2.setSellerName("京东");
        shopCar2.setGoodsName("小米手机");
        shopCar2.setBuyerId(3);
        shopCar2.setBuyerName("Alice");
        shopCar2.setNum(3);

        ShopCar shopCar3 = new ShopCar();
        shopCar3.setId(1);
        shopCar3.setSellerId(2);
        shopCar3.setSellerName("1号店");
        shopCar3.setGoodsName("华为手机");
        shopCar3.setBuyerId(1);
        shopCar3.setBuyerName("leo");
        shopCar3.setNum(5);

        ShopCar shopCar4 = new ShopCar();
        shopCar4.setId(1);
        shopCar4.setSellerId(2);
        shopCar4.setSellerName("天猫");
        shopCar4.setGoodsName("苹果手机");
        shopCar4.setBuyerId(1);
        shopCar4.setBuyerName("leo");
        shopCar4.setNum(2);



        List<ShopCar> shopCars = Arrays.asList(shopCar, shopCar1, shopCar2,shopCar3,shopCar4);
      //  System.out.println(shopCars);

        //   test_group_jdk8(shopCars);
       test_level_group(shopCars);
      /*
      {华为={Alice=
      [ShopCar(id=3, sellerId=3, sellerName=华为, goodsName=汽车, buyerId=3, buyerName=Alice, num=3)]},

      京东={kevin=
      [ShopCar(id=2, sellerId=2, sellerName=京东,goodsName=电脑, buyerId=2, buyerName=kevin, num=4)]},

      天猫={leo=
      [ShopCar(id=1, sellerId=1, sellerName=天猫, goodsName=手机, buyerId=1, buyerName=leo, num=5)]}}
         */
    }



    public static void test_group_jdk7(List<ShopCar> shopCars) {

        Map<String, List<ShopCar>> map = new HashMap<String, List<ShopCar>>();

        // 遍历集合 List<ShopCar>
        for (ShopCar c : shopCars) {
            // 判断map集合key中 包含不包含 购物车的商家名称
            if (map.containsKey(c.getSellerName())) {
                // 以商家名称 为 key  , 对应的 购物车 为values
                map.get(c.getSellerName()).add(c);

            } else {
                // 定义一个 新的 集合
                ArrayList<ShopCar> aList = new ArrayList<>();


                map.put(c.getSellerName(), aList);
                // 把每个ShopCar对象 放到 aList集合中
                aList.add(c);

            }

        }

        System.out.println(map);
    }


    public static void test_group_jdk8(List<ShopCar> shopCars) {
       /*    Map<String, List<ShopCar>> shopBySellerNameMap = shopCars.stream()
                             .collect(Collectors.groupingBy(ShopCar::getSellerName));*/
        //.collect(Collectors.groupingBy( (ShopCar c) -> c.getSellerName() ))
        //.collect(Collectors.groupingBy( ShopCar  -> ShopCar.getSellerName() ))
        // 购物车 根据商家进行分组
        Map<String, List<ShopCar>> map = shopCars.stream()
                .collect(Collectors.groupingBy(ShopCar::getSellerName) );

        // 购物车 根据买家进行分组
        Map<String, List<ShopCar>> map1 = shopCars.stream()
                .collect(Collectors.groupingBy((ShopCar c) -> c.getBuyerName()) );

        System.out.println(map);
        System.out.println("___________________________________________________________________");
        System.out.println(map1);


    }


    public static void test_level_group(List<ShopCar> shopCars) {
        /*Map<String, Map<String, List<ShopCar>>> result =
                shopCars.stream().collect(
                        Collectors.groupingBy(ShopCar::getSellerName,
                        Collectors.groupingBy(ShopCar::getBuyerName)
                        )
                );*/

        // 先根据 商家进行分组，然后再根据买家进行分组
        /*
        * 如：
        *
        * 京东：
        *       kevin：
        *               shopCar1
        *       leo：
        *               shopCar1,
        *               shopCar2
        *       alice:
        *               shopCar1
        * 天猫：
        *        alice：
        *               shopCar1,
        *               shopCar2
         *       leo：
         *              shopCar1
        *
        * 1号店：
        *       leo：
        *
        *
        *
        *
        * */
       Map<String, Map<String, List<ShopCar>>> result = shopCars.stream().collect(
                Collectors.groupingBy(
                        ShopCar -> ShopCar.getSellerName(),
                        Collectors.groupingBy(
                                ShopCar -> ShopCar.getBuyerName()
                            )
                        )
                );
       /* Map<String, Map<String, Map<Integer, List<ShopCar>>>> result = shopCars.stream().collect(
                Collectors.groupingBy(
                        ShopCar -> ShopCar.getSellerName(),
                        Collectors.groupingBy(
                                ShopCar -> ShopCar.getBuyerName(),
                                Collectors.groupingBy(
                                        ShopCar -> ShopCar.getId()
                                )
                        )
                )
        );*/
        System.out.println(result);
    }

  /*
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

    // 初始化数据如下：
    public static List<ShopCar> initShopCar() {
        return Arrays.asList(
                new ShopCar(1, 1, "天猫", "华为手机", 1, "dingw", 5),
                new ShopCar(1, 2, "京东", "华为手机", 2, "ly", 2),
                new ShopCar(1, 1, "京东", "小米手机", 3, "zhl", 3),
                new ShopCar(1, 2, "1号店", "华为手机", 1, "dingw", 5),
                new ShopCar(1, 2, "天猫", "苹果手机", 1, "dingw", 2)
        );
    }
        */

}
