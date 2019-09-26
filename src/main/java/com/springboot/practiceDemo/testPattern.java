package com.springboot.practiceDemo;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @Author ： leo
 * @Date :2019/9/18 15:38
 */
public class testPattern {
    private static final String REGEX = "\\bcat\\b";
    private static final String INPUT =
            "cat cat cat cattie cat";
    public static void main(String[] args) {

        Pattern p = Pattern.compile(REGEX);
        Matcher m = p.matcher(INPUT); // 获取 matcher 对象
        int count = 0;

        while(m.find()) {
            count++;
            System.out.println("Match number "+count);
            System.out.println("start(): "+m.start());
            System.out.println("end(): "+m.end());
        }
    //    getPattern();
    }



    public  static  void getPattern(){
            String content = "I am noob" + "from runoob.com.";

            String pattern = ".*runoob.*";

        boolean isMatch = Pattern.matches(pattern, content);

        System.out.println("字符串中是否包含了‘runoob’的子字符串?"+isMatch);


    }
    public  static  void getPattern1(){
        String content = "I am noob " +
                "from runoob.com.";

        String pattern = ".*runoob.*";

        boolean isMatch = Pattern.matches(pattern, content);
        System.out.println("字符串中是否包含了 'runoob' 子字符串? " + isMatch);
    }

    public  static  void getPattern2(){

    }
}
