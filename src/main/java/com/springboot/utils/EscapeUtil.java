package com.springboot.utils;

import org.springframework.web.util.HtmlUtils;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @Author ： leo
 * @Date :    2019/9/17 14:50
 * 功能说明：转义特殊符号  比如说 "<" , ">"
 */
public class EscapeUtil extends HtmlUtils {
    private static  final Pattern pattern_LT = Pattern.compile("<".toString(), Pattern.LITERAL);
    private static  final Pattern pattern_GT = Pattern.compile(">".toString(), Pattern.LITERAL);

    private static  final String string_LT = "&lt;";
    private static  final String string_GT = "&gt;";
    /**
     * 假如只排除"<" , ">" 这两个特殊符号
     *
     * 实际应用： 避免前端展示出错
     * 优点：    无需判断商家返回的json是否已经转义过
     * */
    public static String getEscape(String parameter)  {

        String replace = parameter.replace("<", "&lt;").replace(">", "&gt;");

        return replace;
    }
/*
Pattern.compile(target.toString(), Pattern.LITERAL)
.matcher(this).replaceAll(Matcher.quoteReplacement(replacement.toString()))
*/
    public static String getEscape1(String parameter)  {
        String replace =   pattern_LT.matcher(parameter).replaceAll(Matcher.quoteReplacement(string_LT.toString()));
                replace =   pattern_GT.matcher(replace).replaceAll(Matcher.quoteReplacement(string_GT.toString()));

        return replace;
    }


}
