package com.springboot.practiceDemo;

import org.springframework.data.redis.core.RedisTemplate;

import javax.annotation.Resource;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class redisTemplateDemo {

    public static void main(String[] args) {
        String bb = DateUtil.format(new Date(), "aa");
        int dd = Integer.parseInt(DateUtil.format(new Date(),"d"));

        System.out.println(new Date());
        System.out.println(bb);

       System.out.println(dd);


    }





}
