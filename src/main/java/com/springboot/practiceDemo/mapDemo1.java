package com.springboot.practiceDemo;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author ： leo
 * @Date :2019/9/4 15:07
 */

public class mapDemo1 {

    private  Map<String, Object> data = new HashMap<>();

    public Map<String, Object> getData() {
        return data;
    }

    public void setData(Map<String, Object> data) {
        this.data = data;
    }

    public static void main(String[] args) {

        Map<String, Object> resMap = new HashMap<>();
        resMap.put("id",1);
        resMap.put("name","leo");

        System.out.println(resMap);
        System.out.println("________________________________");
        mapDemo1 demo1 = new mapDemo1();

        demo1.setData(resMap);
        System.out.println(demo1.data);
    }



}
