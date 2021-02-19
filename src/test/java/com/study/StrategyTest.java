package com.study;

import com.alibaba.fastjson.JSON;
import com.study.constant.OrderConstant;
import com.study.entity.Order;
import lombok.extern.slf4j.Slf4j;
import org.apache.http.HttpStatus;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicHeader;
import org.apache.http.util.EntityUtils;
import org.junit.Test;

import java.io.Closeable;
import java.nio.charset.Charset;

/**
 * @author xiehongwei
 * @date 2021/02/19
 */
@Slf4j
public class StrategyTest {
    private static final String UTF_8 = "utf-8";

    private static RequestConfig requestConfig;

    static {
        requestConfig = RequestConfig.custom()
                .setConnectTimeout(1000)//连接超时时间
                .setSocketTimeout(3000)//读超时时间
                .build();
    }

    @Test
    public void handler() {
        try {
            String url = "http://localhost:8080/order/handler";
            Order order = new Order();
            order.setName("订单名称");
            order.setPrice(19.9);
//            order.setType(OrderConstant.TB);//淘宝
//            order.setType(OrderConstant.JD);//京东
            order.setType(OrderConstant.PDD);//拼多多

            post(url, JSON.toJSONString(order));

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void post(String url, String jsonObject) {
        CloseableHttpClient httpClient = null;
        CloseableHttpResponse httpResponse = null;
        try {
            httpClient = HttpClients.createDefault();

            HttpPost httpPost = new HttpPost(url);

            StringEntity entity = new StringEntity(jsonObject, Charset.forName(UTF_8));
            entity.setContentType("text/json");
            entity.setContentEncoding(new BasicHeader("Content-Type", "application/json"));

            httpPost.setEntity(entity);
            httpPost.setConfig(requestConfig);
            httpPost.setHeader("Content-Type", "application/json;charset=utf-8");

            httpResponse = httpClient.execute(httpPost);
            if (httpResponse.getStatusLine().getStatusCode() == HttpStatus.SC_OK) {
                log.info("返回结果：" + EntityUtils.toString(httpResponse.getEntity(), UTF_8));
            } else {
                log.error("请求失败,statusCode:{}", httpResponse.getStatusLine().getStatusCode());
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            close(httpClient);
            close(httpResponse);
        }
    }

    /**
     * 关闭流
     */
    private <T extends Closeable> void close(T io) {
        if (io == null) {
            return;
        }
        try {
            io.close();
        } catch (Exception e) {
            log.error(e.getMessage(), e);
        }
    }
}
