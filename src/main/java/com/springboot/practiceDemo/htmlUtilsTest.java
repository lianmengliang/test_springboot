package com.springboot.practiceDemo;

import com.alibaba.fastjson.JSON;
import com.springboot.utils.EscapeUtil;
import org.springframework.web.util.HtmlUtils;

//需求：
//.replace("<", "&lt;").replace(">", "&gt;")---->HtmlUtils.htmlEscape(userLevelMap.get(key))
//// baseInfoBean.setAppShowMsg(baseInfoBean.getAppShowMsg().replace("[" + key + "]", StringUtils.isEmpty(userLevelMap.get(key)) ? "":HtmlUtils.htmlEscape(userLevelMap.get(key))));  705

/**
 * @Author ： leo
 * @Date :2019/9/16 12:19
 */
public class htmlUtilsTest {
    public static void main(String[] args) {

       // htmlUtils1();
        escapeUtils();
    }


    public  static  void htmlUtils() {

        String s = HtmlUtils.htmlEscape("<div>hello world</div><p>&nbsp;</p>");
        System.out.println(s);

        String s1 = HtmlUtils.htmlUnescape(s);
        System.out.println(s1);

    }



    /**
     *Q: 玩家的昵称中带有 & 符号，
     *
     *
     * HtmlUtils 工具类 在转义字符串时，
     * 如果字符串中含有 & 或 &amp;符号，则 &符号会被转义为&amp;或 &amp; 会被转义为 &amp;amp;
     * 因此在使用HtmlUtils工具类时，只对 同一字符串 使用一次，避免第二次使用造成的重复转义。
     *
     * 问题:怎么解决字符串中本身就存在 &amp;或&lt; 或 &gt; ,在前端页面仍然显示&amp;或&lt; 或 &gt;  ???
     * 方法是： 先经过后台htmlUtils对字符串进行转义，然后经过前端在展示
     * 比如说： &amp; ---->htmlUtils转义后为 &amp;amp;---->前端自动处理为&amp;--->展示为 &amp;
     *
     * */
     public  static  void htmlUtils1() {

      // String s = HtmlUtils.htmlEscape("<div>&&amp;hello&world&</div>"); //&lt;div&gt;&amp;&amp;amp;hello&amp;world&amp;&lt;/div&gt;
       // String s = HtmlUtils.htmlEscape("<leo>&&amp;hello&world&</kevin>"); //&lt;leo&gt;&amp;&amp;amp;hello&amp;world&amp;&lt;/kevin&gt;
      //  String s = HtmlUtils.htmlEscape("<leo>&&amp;hello&world&"); //&lt;leo&gt;&amp;&amp;amp;hello&amp;world&amp;
      //  String s = HtmlUtils.htmlEscape("&&amp;hello&world&");        //&amp;&amp;amp;hello&amp;world&amp;

      //  String s = HtmlUtils.htmlEscape("&;&amp;hello&world&");      // &amp;;&amp;amp;hello&amp;world&amp;
       // String s = HtmlUtils.htmlEscape("&;&amp;hello&world&");  //&amp;;&amp;amphello&amp;world&amp;
        String s = HtmlUtils.htmlEscape("&;&amp;leo&lt;</*@#$%^()");  //&amp;;&amp;amp;leo&amp;lt;&lt;/*@#$%^()

        System.out.println(s);

        String s1 = HtmlUtils.htmlUnescape(s);
        System.out.println(s1);

        String s2 = HtmlUtils.htmlUnescape("&;&amp;leo&lt;<");
         System.out.println(s2);

     }
    //&gt;&lt;  ><
    /**
     * 使用一次 HtmlUtils.htmlEscape() 方法 可以对字符串中某些特殊符号进行转义，然后经过前端再解析，进而展示到页面上
     * String数据类型的replace()方法，如果字符串中出现<>& 特殊符号时，会出现反复替换，造成前端展示不是我们期望的结果 。
     *
     * */
    public  static  void htmlUtils2() {

       // String s = HtmlUtils.htmlEscape("<div>&&amphello&world&</div>");


        String s= "<Leo><&>&";
        // 在执行replace() 方法前，进行HtmlUtils.htmlEscape() 对字符串的转义
        String replace0 = HtmlUtils.htmlEscape(s);
        System.out.println("replace0======"+replace0);

        //replace() 方法，没有替换 & 符号前 ，
        String replace1 = s.replace("<", "&lt;")
                .replace(">", "&gt;");
        //replace() 方法，在替换<> 之后，继续替换 & 符号 ，造成重复替换 。
        String replace2 = s.replace("<", "&lt;")
                            .replace(">", "&gt;")
                            .replace("&", "&amp;");

        System.out.println(s);
        System.out.println("replace1======"+replace1);
        System.out.println("replace2======"+replace2);

        // 在执行replace() 方法后，进行HtmlUtils.htmlEscape() 对字符串的转义
        String replace3 = HtmlUtils.htmlEscape(s);
        System.out.println("replace3======"+replace1);


    }

    public  static  void escapeUtils() {
        long startTime = System.currentTimeMillis(); //获取开始时间



        String a = "<leo><>";

        String aE =EscapeUtil.getEscape(a) ;
        System.out.println(EscapeUtil.getEscape(a));

        System.out.println(aE);

        String b = "！@#￥%……&*leo";

        System.out.println(EscapeUtil.getEscape(b));

        String c = "<！@#￥%……&*leo>";
        System.out.println(EscapeUtil.getEscape(c));

        System.out.println(EscapeUtil.getEscape1(c));

        System.out.println(EscapeUtil.htmlEscape(c));


        long endTime = System.currentTimeMillis(); //获取结束时间
        System.out.println("程序运行时间：" + (endTime - startTime) + "ms"); //输出程序运行时间

    }

}
