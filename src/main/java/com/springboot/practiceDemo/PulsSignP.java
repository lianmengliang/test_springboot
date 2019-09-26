package com.springboot.practiceDemo;



import org.apache.commons.lang3.StringUtils;
import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
public class PulsSignP {
    static String T_URL = "待定";
    static String TEST_KEY = "待定";
    static String TEST_SEC = "待定";


    public static void main(String[] args)throws UnsupportedEncodingException, NoSuchAlgorithmException  {
        String result = getResult(T_URL, getReqParam());
        System.out.print(result);

    }
    private static String  getReqParam()throws UnsupportedEncodingException, NoSuchAlgorithmException  {
        TreeMap<String, String> req = new TreeMap<String, String>();
        //向treemap 集合中 加入 key + value
        req.put("a", TEST_KEY);
        req.put("f", "json");
        req.put("l", "zh_CN");
        req.put("m", "zhongan.repair.query");
        req.put("v", "1.0");
        // 加入当前时间
        req.put("i", "" + System.currentTimeMillis() / 1000);
        // 加入参数
        req.put("params", "{\"assignNo\":\"TEST018\"}");

        req.put("s", sign(req, null, TEST_SEC));

        StringBuilder param = new StringBuilder();

        for (Iterator<Map.Entry<String, String>> it = req.entrySet().iterator(); it.hasNext();) {
            Map.Entry<String, String> e = it.next();
            // 给param 拼接字符串
            param.append("&").append(e.getKey()).append("=").append(URLEncoder.encode(e.getValue(), "UTF-8"));
        }
            // 取字符串 索引大于等于1  后的字符串
        return param.toString().substring(1);

    }

    private static String sign(Map<String, String> paramValues, List<String> ignoreParamNames, String secret) throws NoSuchAlgorithmException, UnsupportedEncodingException {

        StringBuilder sb = new StringBuilder();

        // 定义一个list集合，并赋予初始容
        List<String> paramNames = new ArrayList<String>(paramValues.size());

      /*  System.out.println(paramNames.size());

        ArrayList<Object> list = new ArrayList<>();
        System.out.println(list.size());*/

        paramNames.addAll(paramValues.keySet());
        // 判断ignoreParamNames 是否为为空 且 长度大于0
        if (ignoreParamNames != null && ignoreParamNames.size() > 0) {
            // 如果是，进行对ignoreParamNames 增强for循环
            for (String ignoreParamName : ignoreParamNames) {
                // 从集合paramName中 移除ignoreParamName 这些元素
                paramNames.remove(ignoreParamName);
            }
        }
        //对paramName根据元素的自然顺序 对指定列表按升序进行排序。
        Collections.sort(paramNames);
        // 加密
        sb.append(secret);

        for (String paramName : paramNames) {
            // 添加paramName的值 和 paramName对应的value值 到字符串中
            sb.append(paramName).append(paramValues.get(paramName));
        }
        //再加密
        sb.append(secret);

        MessageDigest md = MessageDigest.getInstance("SHA-1");
        return byte2hex(md.digest(sb.toString().getBytes("UTF-8")));
    }
    private static String byte2hex(byte[] bytes) {

        StringBuilder sign = new StringBuilder();
        for (int i = 0; i < bytes.length; i++) {
            String hex = Integer.toHexString(bytes[i] & 0xFF);
            if (hex.length() == 1) {
                sign.append("0");
            }
            sign.append(hex.toUpperCase());
        }
        return sign.toString();
    }

    private static String getResult(String urlStr, String content) {
        URL url = null;
        HttpURLConnection connection = null;
        try {
            url = new URL(urlStr);
            connection = (HttpURLConnection) url.openConnection();
            connection.setDoOutput(true);
            connection.setDoInput(true);
            connection.setRequestMethod("POST");
            connection.setRequestProperty("Content-Type", "application/x-www-form-urlencoded;charset=UTF-8");
            connection.setUseCaches(false);
            connection.connect();

            DataOutputStream out = new DataOutputStream(connection.getOutputStream());
            out.write(content.getBytes("UTF-8"));
            out.flush();
            out.close();

            BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream(), "UTF-8"));
            StringBuffer buffer = new StringBuffer();
            String line = "";
            while ((line = reader.readLine()) != null) {
                buffer.append(line);
            }
            reader.close();

            return buffer.toString();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (connection != null) {
                connection.disconnect();
            }
        }

        return null;
    }
}
