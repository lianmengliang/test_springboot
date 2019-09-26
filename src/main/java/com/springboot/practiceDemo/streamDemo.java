package com.springboot.practiceDemo;

import com.google.common.collect.ImmutableList;

import java.lang.reflect.Array;
import java.util.*;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static java.util.stream.Collectors.partitioningBy;


/**
 * @Author ： leo
 * @Date :2019/9/2 10:46
 */
public class streamDemo {
    public static void main(String[] args) {
        List<String> menu = Arrays.asList("宫保鸡丁", "糖醋鲤鱼", "重庆辣子鸡","回锅肉","水煮鱼");
      // menu.stream().map()

        test1();
    }

    public static  void  test(){

    }

    public static  void  test1(){
        //1.将数据收集进一个列表(Stream 转换为 List，允许重复值，有顺序)
        Stream<String> language = Stream.of("java", "python", "C++","php","java");
        List<String> listResult = language.collect(Collectors.toList());

        /*//1.将数据收集进一个集合(Stream 转换为 Set，不允许重复值，没有顺序)
        Set<String> setResult = language.collect(Collectors.toSet());
        setResult.forEach(System.out::println);
*/
        listResult.forEach(System.out::println);
        System.out.println("-------------------1---------------------");

        List<String> list = Arrays.asList("java", "python", "C++","php","java");
        list.forEach(System.out::println);


      /*  List<String> listResult1 = list.stream().collect(Collectors.toList());
        listResult.forEach(System.out::println);*/

        System.out.println("---------------------2-------------------");

        List<String> listss = Arrays.asList("java", "python", "C++","php","java");

        for (String s : listss) {
            System.out.println(s);
        }
        System.out.println("-------------------3---------------------");
    }

    public static  void  test2(){

        List<String> lists = Arrays.asList("java", "python", "C++", "php", "java");
        //1. 直接将输出结果 拼接
        System.out.println(lists.stream().collect(Collectors.joining()));
        System.out.println("----------------------------------------");
        /**String str = "";
        // 最笨的方法 拼接
        for (String s : lists) {
            str +=s;
        }
        System.out.println(str);*/
        System.out.println("----------------------------------------");
        // 2.每个输出结果之间加 拼接符号 “|”
        String s = lists.stream().collect(Collectors.joining("|"));
        System.out.println(s);

        //3. 输出结果开始头为Start--，结尾为--End，中间用拼接符号“||”

        System.out.println(lists.stream().collect(Collectors.joining("||","start---","---end")));
        System.out.println(lists.stream().collect(Collectors.joining("|","【","】")));

    }

    public static  void  test3() {
        //   partitioningBy()，分类成一个key为True和Flase的Map
        List<String> list = Arrays.asList("java", "python", "C++","php","java");
        Map<Boolean, List<String>> result = list.stream().collect(partitioningBy(s -> s.length() > 3));

        Set<Boolean> s = result.keySet();
        for (Boolean aBoolean : s) {
            System.out.println("键key ："+ aBoolean+"++"+ result.get(aBoolean));
        }

    }

    public static  void  test4(){
        List<String> list = Arrays.asList("java", "python", "C++","php","java");
        //收集后转换为不可变List
        ImmutableList<String> collect = list.stream().collect(Collectors.collectingAndThen(Collectors.toList(), ImmutableList::copyOf));

        System.out.println("list集合-----"+collect);

        HashMap<String, String> strs = new HashMap<>();
        strs.put("leo","too");
        strs.put("lewo","too");
        strs.put("l1ewo","too");
        strs.put("l2ewo","too");
        System.out.println("map集合-----"+strs);

        String[] strings = new String[]{"leo,tom,kevin"};

        System.out.println("数组---"+ strings);

        int[] ints = new int[3];


    }




}
