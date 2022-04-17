package com.one.net;

import org.apache.http.HttpEntity;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.util.EntityUtils;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class GetUtils {
    //�޲η�ʽ
    public static void get(String url,SuccessListener sListener,FailListener fListener) {
        getWithParams(url, new HashMap<>(),sListener,fListener);
    }

    //�вη�ʽ
    public static void getWithParams(String url, Map<String, Object> params,SuccessListener sListener,FailListener fListener) {
        CloseableHttpClient httpClient = HttpClientBuilder.create().setDefaultCookieStore(CookiesHolder.getCookieStore()).build();
        CloseableHttpResponse response = null;
        try {
            // ����Get����
            url = joinParam(url, params);
            HttpGet httpGet = new HttpGet(url);
            RequestConfig requestConfig = RequestConfig.custom()
                    .setSocketTimeout(3000) //��������Ӧ��ʱʱ��
                    .setConnectTimeout(3000) //���ӷ�������ʱʱ��
                    .build();
            httpGet.setConfig(requestConfig);
            // �ɿͻ���ִ��(����)Get����
            response = httpClient.execute(httpGet);
            // ����Ӧģ���л�ȡ��Ӧʵ��
            HttpEntity responseEntity = response.getEntity();
            if (responseEntity != null) {
                sListener.success(EntityUtils.toString(responseEntity));
            }

        } catch (Exception e) {
            e.printStackTrace();
            fListener.fail();
        } finally {
            try {
                // �ͷ���Դ
                if (httpClient != null) {
                    httpClient.close();
                }
                if (response != null) {
                    response.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    private static String joinParam(String url, Map<String, Object> params) {
        if (params == null || params.size() == 0) {
            return url;
        }

        StringBuilder urlBuilder = new StringBuilder(url);
        urlBuilder.append("?");

        int counter = 0;
        for (Map.Entry<String,Object> entry : params.entrySet()) {
            String key = entry.getKey();
            Object value = entry.getValue();
            if (key == null) {
                continue;
            }

            if (counter == 0) {
                urlBuilder.append(key).append("=").append(value);
            } else {
                urlBuilder.append("&").append(key).append("=").append(value);
            }
            counter++;
        }

        return urlBuilder.toString();
    }
}
