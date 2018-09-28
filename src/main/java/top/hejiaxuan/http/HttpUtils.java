package top.hejiaxuan.http;


import com.alibaba.fastjson.JSONObject;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.HttpClient;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.conn.ssl.SSLConnectionSocketFactory;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.impl.conn.PoolingHttpClientConnectionManager;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.ssl.SSLContextBuilder;
import org.apache.http.util.EntityUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.net.ssl.SSLContext;
import java.io.IOException;
import java.nio.charset.Charset;
import java.security.GeneralSecurityException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Created by hjx on 2017/4/20 0020.
 */
public class HttpUtils {

    private static Logger logger = LoggerFactory.getLogger(HttpUtils.class);
    public static final String CONTENTTYPE_JSON = "application/json";
    public static final String CONTENTTYPE_XML = "application/xml";

    static PoolingHttpClientConnectionManager connectionManager;
    static RequestConfig requestConfig;
    static final int MAX_TIMEOUT = 2000;
    static final String CHARSET = "UTF-8";


    static {
        connectionManager = new PoolingHttpClientConnectionManager();
        connectionManager.setMaxTotal(100);
        connectionManager.setDefaultMaxPerRoute(connectionManager.getMaxTotal());
        RequestConfig.Builder configBuilder = RequestConfig.custom();
        // 设置连接超时
        configBuilder.setConnectTimeout(MAX_TIMEOUT);
        // 设置读取超时
        configBuilder.setSocketTimeout(MAX_TIMEOUT);
        // 设置从连接池获取连接实例的超时
        configBuilder.setConnectionRequestTimeout(MAX_TIMEOUT);
        // 在提交请求之前 测试连接是否可用
        configBuilder.setStaleConnectionCheckEnabled(true);
        requestConfig = configBuilder.build();
    }


    /**
     * 发送GET
     *
     * @param apiUrl
     * @param params
     * @return
     */
    public static String doGet(final String apiUrl, final Map<String, String> params) {
        logger.info("url: " + apiUrl);
        if (logger.isDebugEnabled()) {
            logger.debug("params: " + JSONObject.toJSONString(params));
        }
        HttpClient httpClient = httpClient();
        HttpGet httpGet = httpGet(apiUrl, params);
        HttpResponse httpResponse = execute(httpClient, httpGet);
        return httpEntitytoString(httpResponse.getEntity());
    }


    /**
     * 发送POST
     *
     * @param apiUrl
     * @param params
     * @return
     */
    public static String doPost(final String apiUrl, final Map<String, String> params) {
        logger.info("url: " + apiUrl);
        if (logger.isDebugEnabled()) {
            logger.debug("params: " + JSONObject.toJSONString(params));
        }
        HttpClient httpClient = httpClient();
        HttpPost httpPost = httpPost(apiUrl, params);
        HttpResponse httpResponse = execute(httpClient, httpPost);
        return httpEntitytoString(httpResponse.getEntity());
    }

    /**
     * 发送HTTPS的POST
     *
     * @param apiUrl
     * @param params
     * @return
     */
    public static String doHttpsPost(final String apiUrl, final Map<String, String> params) {
        logger.info("url: " + apiUrl);
        if (logger.isDebugEnabled()) {
            logger.debug("params: " + JSONObject.toJSONString(params));
        }
        HttpClient httpClient = sslHttpClient();
        HttpPost httpPost = httpPost(apiUrl, params);
        HttpResponse httpResponse = execute(httpClient, httpPost);
        return httpEntitytoString(httpResponse.getEntity());
    }

    /**
     * 发送POST
     *
     * @param apiUrl
     * @param requestBody
     * @param contentType
     * @return
     */
    public static String doPost(final String apiUrl, final String requestBody, final String contentType) {
        logger.info("url: " + apiUrl);
        if (logger.isDebugEnabled()) {
            logger.debug("contentType: " + JSONObject.toJSONString(contentType));
        }
        HttpClient httpClient = httpClient();
        HttpPost httpPost = httpPost(apiUrl, requestBody, contentType);
        HttpResponse httpResponse = execute(httpClient, httpPost);
        return httpEntitytoString(httpResponse.getEntity());
    }

    /**
     * 发送HTTPS的POST
     *
     * @param apiUrl
     * @param requestBody
     * @param contentType
     * @return
     */
    public static String doHttpsPost(final String apiUrl, final String requestBody, final String contentType) {
        logger.info("url: " + apiUrl);
        if (logger.isDebugEnabled()) {
            logger.debug("contentType: " + JSONObject.toJSONString(contentType));
        }
        HttpClient httpClient = sslHttpClient();
        HttpPost httpPost = httpPost(apiUrl, requestBody, contentType);
        HttpResponse httpResponse = execute(httpClient, httpPost);
        return httpEntitytoString(httpResponse.getEntity());
    }


    static HttpResponse execute(final HttpClient httpClient, final HttpUriRequest httpUriRequest) {
        HttpResponse response = null;
        try {
            response = httpClient.execute(httpUriRequest);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return response;
    }


    static String parseURL(final String url, final Map<String, String> params) {
        String apiUrl = url;
        StringBuffer param = new StringBuffer();
        int i = 0;
        for (Map.Entry<String, String> entry : params.entrySet()) {
            if (i == 0) {
                param.append("?");
            } else {
                param.append("&");
            }
            param.append(entry.getKey()).append("=").append(entry.getValue());
            i++;
        }
        apiUrl += param;
        return apiUrl;
    }


    public static HttpClient httpClient() {
        HttpClientBuilder custom = HttpClients.custom();
        custom.setConnectionManager(connectionManager);
        custom.setDefaultRequestConfig(requestConfig);
        HttpClient httpClient = custom.build();
        return httpClient;
    }

    static HttpClient sslHttpClient() {
        HttpClientBuilder custom = HttpClients.custom();
        custom.setConnectionManager(connectionManager);
        custom.setDefaultRequestConfig(requestConfig);
        custom.setSSLSocketFactory(sslConnectionSocketFactory());
        HttpClient httpClient = custom.build();
        return httpClient;
    }

    static HttpPost httpPost(final String url, final String requestBody, final String contentType) {
        HttpPost httpPost = new HttpPost(url);
        httpPost.setConfig(requestConfig);
        StringEntity stringEntity = new StringEntity(requestBody, CHARSET);
        stringEntity.setContentEncoding(CHARSET);
        stringEntity.setContentType(contentType);
        httpPost.setEntity(stringEntity);
        return httpPost;
    }

    static HttpPost httpPost(final String url, final Map<String, String> map) {
        HttpPost httpPost = new HttpPost(url);
        httpPost.setConfig(requestConfig);
        List<NameValuePair> pairList = new ArrayList(map.size());
        for (Map.Entry<String, String> entry : map.entrySet()) {
            NameValuePair pair = new BasicNameValuePair(entry.getKey(), entry.getValue());
            pairList.add(pair);
        }
        UrlEncodedFormEntity encodedFormEntity = new UrlEncodedFormEntity(pairList, Charset.forName(CHARSET));
        httpPost.setEntity(encodedFormEntity);
        return httpPost;
    }

    static HttpGet httpGet(final String url, final Map<String, String> map) {
        String apiUrl = parseURL(url, map);
        HttpGet httpGet = new HttpGet(apiUrl);
        httpGet.setConfig(requestConfig);
        return httpGet;
    }

    static String httpEntitytoString(final HttpEntity httpEntity) {
        if (httpEntity != null) {
            try {
                String result = EntityUtils.toString(httpEntity, CHARSET);
                return result;
            } catch (IOException e) {
                e.printStackTrace();
            } finally {
                try {
                    EntityUtils.consume(httpEntity);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return null;
    }

    static SSLConnectionSocketFactory sslConnectionSocketFactory() {

        try {
            SSLContext sslContext = new SSLContextBuilder().loadTrustMaterial(null, new MyTrustStrategy()).build();
            SSLConnectionSocketFactory sslConnectionSocketFactory = new SSLConnectionSocketFactory(sslContext, new MyX509HostnameVerifier());
            return sslConnectionSocketFactory;
        } catch (GeneralSecurityException e) {
            e.printStackTrace();
        }
        return null;
    }

}
