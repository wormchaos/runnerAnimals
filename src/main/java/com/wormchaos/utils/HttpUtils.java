package com.wormchaos.utils;


import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import org.apache.http.Consts;
import org.apache.http.HttpEntity;
import org.apache.http.NameValuePair;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;
import sun.net.www.http.HttpClient;

import java.io.IOException;
import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Created by Raytine on 2021/1/28.
 */
public class HttpUtils {

    public static String OPENID_HOST = "https://api.weixin.qq.com/sns/jscode2session?appid={0}&secret={1}&js_code={2}&grant_type=authorization_code";

    public static String ACCESS_TOKEN_HOST = "https://api.weixin.qq.com/cgi-bin/token?appid={0}&secret={1}&grant_type=client_credential";

    public static String SEND_HOST = "https://api.weixin.qq.com/cgi-bin/message/subscribe/send?access_token={0}";

//    public static String template_activity = "{ \"thing2\": { \"value\":  \"物种战争即将开始\" }, \"thing7\": { \"value\": \"敢死 225\" } }";

    public static String appId = "wx1b3ffbdca0e56e83";
    public static String secret = "0b5f887a4e5a25f2a65d552e730aa829";

    public static String getOpenId(String code) throws IOException {
        String url = MessageFormat.format(OPENID_HOST, appId, secret, code);
        JSONObject jo = HttpUtils.httpGet(url);
        String openid = jo.getString("openid");
        return openid;
    }

    public static String getAccessToken() throws IOException {
        String url = MessageFormat.format(ACCESS_TOKEN_HOST, appId, secret);
        JSONObject jo = HttpUtils.httpGet(url);
        String accessToken = jo.getString("access_token");
        return accessToken;
    }

    public static String sendTemplate(String templateId, String openId, String accessToken, String message) throws IOException {
//        String templateId = "lh7TH0qHUII7jY5Gu3mPevd_XX-cIY1KfGccoktto-o";
//        String openId = "o2T5O5Sc11MqLe8DOhBWuNj61lhI";
//        String accessToken = "41_nP_NQooDosfP8sXpjyVkToXVhs-1EuWSgoEuFljLvm_082fz8bZjry81GPqXDbz5DdqNmM8p0sHXIW6F6C13fzS6e4Dsh59bYKgAuRMhkGxxnckKi8WDMrPqqt8N2CBPKZxuy9BxUihqEtTSBDUcAEAPRI";
        JSONObject object = new JSONObject();
        JSONObject thing2 = new JSONObject();
        thing2.put("value", "物种战争即将开始");
        object.put("thing2", thing2);
        JSONObject thing7 = new JSONObject();
        thing7.put("value", message);
        object.put("thing7", thing7);
        String url = MessageFormat.format(SEND_HOST, accessToken);
        JSONObject jo = HttpUtils.httpPost(url,
                "touser", openId, "template_id", templateId, "data", object);
        return accessToken;
    }

    public static JSONObject httpGet(String url) throws IOException {
        String res = null;
        CloseableHttpClient httpClient = HttpClientBuilder.create().build();
        // DefaultHttpClient();
        HttpGet httpget = new HttpGet(url);    //GET方式
        CloseableHttpResponse response = null;
        // 配置信息
        RequestConfig requestConfig = RequestConfig.custom()          // 设置连接超时时间(单位毫秒)
                .setConnectTimeout(5000)                    // 设置请求超时时间(单位毫秒)
                .setConnectionRequestTimeout(5000)             // socket读写超时时间(单位毫秒)
                .setSocketTimeout(5000)                    // 设置是否允许重定向(默认为true)
                .setRedirectsEnabled(false).build();           // 将上面的配置信息 运用到这个Get请求里
        httpget.setConfig(requestConfig);                         // 由客户端执行(发送)Get请求
        response = httpClient.execute(httpget);                   // 从响应模型中获取响应实体
        HttpEntity responseEntity = response.getEntity();
        if (responseEntity != null) {
            res = EntityUtils.toString(responseEntity);
            System.out.println("响应内容为:" + res);
        }
        // 释放资源
        if (httpClient != null) {
            httpClient.close();
        }
        if (response != null) {
            response.close();
        }
        JSONObject jo = JSON.parseObject(res);
//        String openid = jo.getString("openid");
//        System.out.println("openid" + openid);
        return jo;

    }

    public static JSONObject httpPost(String url, Object... params) throws IOException {
        String res = null;
        CloseableHttpClient httpClient = HttpClientBuilder.create().build();
        // DefaultHttpClient();
        HttpPost httpPost = new HttpPost(url);    //GET方式
        CloseableHttpResponse response = null;
        // 配置信息
        RequestConfig requestConfig = RequestConfig.custom()          // 设置连接超时时间(单位毫秒)
                .setConnectTimeout(5000)                    // 设置请求超时时间(单位毫秒)
                .setConnectionRequestTimeout(5000)             // socket读写超时时间(单位毫秒)
                .setSocketTimeout(5000)                    // 设置是否允许重定向(默认为true)
                .setRedirectsEnabled(false).build();           // 将上面的配置信息 运用到这个Get请求里
        httpPost.setConfig(requestConfig);                         // 由客户端执行(发送)Get请求
        HttpEntity entity = new StringEntity(createParam(params), Consts.UTF_8);
        httpPost.setEntity(entity);
        response = httpClient.execute(httpPost);                   // 从响应模型中获取响应实体
        HttpEntity responseEntity = response.getEntity();
        if (responseEntity != null) {
            res = EntityUtils.toString(responseEntity);
            System.out.println("响应内容为:" + res);
        }
        // 释放资源
        if (httpClient != null) {
            httpClient.close();
        }
        if (response != null) {
            response.close();
        }
        JSONObject jo = JSON.parseObject(res);
//        String openid = jo.getString("openid");
//        System.out.println("openid" + openid);
        return jo;

    }

    private static String createParam(Object... params) {
        //建立一个NameValuePair数组，用于存储欲传送的参数
        JSONObject jsonObject = new JSONObject();
        boolean isKey = true;
        String key = "";
        Object value = null;
        for (Object s : params) {
            if (isKey) {
                key = String.valueOf(s);
            } else {
                value = s;
                jsonObject.put(key, value);

            }
            isKey = !isKey;
        }
        return jsonObject.toJSONString();
    }

//    public static void main(String... args) {
////        String code = "0319NT0w3EH8KV2EGt2w3sKEXm39NT00";
//        try {
////            String accessToken = HttpUtils.getAccessToken();
//            String accessToken = HttpUtils.sendTemplate("");
//            System.out.println(accessToken);
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//    }
}
