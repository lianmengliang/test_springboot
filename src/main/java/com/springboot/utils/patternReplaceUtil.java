package com.springboot.utils;

import org.springframework.web.util.HtmlUtils;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @Author ： leo
 * @Date :2019/9/17 16:18
 */
public class patternReplaceUtil extends HtmlUtils {
    private static  final Pattern pattern_LT = Pattern.compile("<".toString(), Pattern.LITERAL);
    private static  final Pattern pattern_GT = Pattern.compile(">".toString(), Pattern.LITERAL);
    private static  final String string_LT = "&lt;";
    private static  final String string_GT = "&gt;";
    public static String getEscape(String parameter)  {
        String replace =   pattern_LT.matcher(parameter).replaceAll(Matcher.quoteReplacement(string_LT.toString()));
        replace =   pattern_GT.matcher(replace).replaceAll(Matcher.quoteReplacement(string_GT.toString()));
        return replace;
    }
}
