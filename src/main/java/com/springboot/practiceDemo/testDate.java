package com.springboot.practiceDemo;

import java.util.Calendar;
import java.util.Date;

/**
 * @Author ： leo
 * @Date :2019/9/11 18:44
 */
public class testDate {
    public static void main(String[] args) {


        Calendar cal = Calendar.getInstance();
        // 获取当日时间的开始时间  0 点
       /* cal.set(cal.get(Calendar.YEAR), cal.get(Calendar.MONTH), cal.get(Calendar.DAY_OF_MONTH), 0, 0, 0);
        Date zeroDate = cal.getTime();
        System.out.println(zeroDate);*/

        // 当日时间于现在时间的 分钟间隔
     //  int i = DateUtil.getIntervalMinute(zeroDate, new Date());
       // System.out.println(i);

        // 设置任意时间的 日期
    /*    cal.set(2019,9,11,19,46,10);
        Date time = cal.getTime();
*/

        getRemainRed();


    }


    public  static int getRemainRed(){
        //初始红包个数
        int redRemain = 20000;
        // 设置活动开始的时间
        Calendar cal = Calendar.getInstance();
        cal.set(2019,8,11,00,00,00);
        Date startTime = cal.getTime();
        //活动开始时间与现在时间的 分钟差  （间隔分钟数）
        int intervalMinute = DateUtil.getIntervalMinute(startTime, new Date());
      //  System.out.println(startTime +"==============="+ new Date());
        System.out.println(intervalMinute);
        //剩余红包数
        redRemain = redRemain >intervalMinute*2?(redRemain-intervalMinute):redRemain;

        redRemain = redRemain <0 ?0:redRemain ;

        System.out.println(redRemain);
        return  redRemain ;
    }
}
