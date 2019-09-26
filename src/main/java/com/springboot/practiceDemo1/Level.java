package com.springboot.practiceDemo1;


import com.springboot.practiceDemo.DateUtil;
import lombok.Data;
import org.slf4j.LoggerFactory;
import java.io.IOException;
import org.slf4j.Logger;
/**
 * @Author ： leo
 * @Date :2019/9/19 17:45
 */

public class Level {
    public static void main(String[] args) {


        int zeroIntervalMinute = DateUtil.getZeroIntervalMinute();
        System.out.println(zeroIntervalMinute);
    }

}