package com.springboot.practiceDemo;





import org.apache.commons.lang3.Conversion;

import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;

public class testDemo1 {
    public static void main(String[] args) {

     /*   StringUtils.isEmpty("yyy");
        StringUtils.isEmpty("");
        StringUtils.isEmpty(" ");
        StringUtils.isEmpty("   ");
        System.out.println( StringUtils.isEmpty("yyy"));
        System.out.println( StringUtils.isEmpty(""));
        System.out.println( StringUtils.isEmpty(" "));
        System.out.println(StringUtils.isEmpty("   "));*/

       // getTime1();
        byte[] bytes= new byte[5];
        bytesToShort(bytes);
    }


    public static void getTime(){
        Calendar cal = Calendar.getInstance();
        //设置当天开始的时间 00：00：00
        cal.set(cal.get(Calendar.YEAR),
                cal.get(Calendar.MONTH),
                cal.get(Calendar.DAY_OF_MONTH),0,0,0);
        System.out.println(cal);
        Date zeroDate = cal.getTime();
        zeroDate.getTime();
        System.out.println(zeroDate);
        System.out.println( zeroDate.getTime());
    }

    public static void getTime1() {
        Date date = new Date();
        System.out.println(date);
        System.out.println(date.getTime());
        System.out.println(System.currentTimeMillis());

        int i = DateUtil.getZeroIntervalMinute();

        System.out.println(i);

        Calendar cal = Calendar.getInstance();
        //设置当天开始的时间 00：00：00
        cal.set(cal.get(Calendar.YEAR),
                cal.get(Calendar.MONTH),
                cal.get(Calendar.DAY_OF_MONTH),0,0,0);
        Date zeroTime = cal.getTime();
        //获取今天过去的分钟数
        int minutes = DateUtil.getIntervalMinute(zeroTime, new Date());
        System.out.println(minutes);
    }

    public static short bytesToShort(byte[] bytes) {

        byte[] dst = Arrays.copyOf(bytes, 3);
        System.out.println(Math.min(2,4));
        System.out.println(bytes.length);

        System.out.println(dst.length);

        short aShort = Conversion.byteArrayToShort(dst, 0, (short) 0, 1, 2);

        System.out.println(aShort);
        return aShort ;



    }

}
