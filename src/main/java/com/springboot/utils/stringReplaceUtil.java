package com.springboot.utils;

import org.springframework.web.util.HtmlUtils;

/**
 * @Author ： leo
 * @Date :2019/9/17 16:17
 */
public class stringReplaceUtil extends HtmlUtils {
    public static String getEscape(String parameter)  {
        String replace = parameter.replace("<", "&lt;").replace(">", "&gt;");
        return replace;
    }
}
