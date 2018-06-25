package top.hejiaxuan.util;

import com.alibaba.fastjson.JSONObject;
import org.apache.commons.lang3.StringUtils;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.ServletInputStream;
import javax.servlet.http.HttpServletRequest;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.util.*;

/**
 * Created by hjx on 2017/8/10.
 */
public class WebUrils {

    static Logger logger = LoggerFactory.getLogger(WebUrils.class);

    public enum Content_Type {
        FORM, XML, JSON
    }

    /**
     * 获取请求中的参数
     *
     * @return
     */
    public static Map<String, String> getParams(HttpServletRequest request) {
        String header = request.getHeader("Content-Type");
        Content_Type type = Content_Type.FORM;
        if (StringUtils.isBlank(header)) {
            type = Content_Type.FORM;
        } else if (header.indexOf("xml") > 0) {
            type = Content_Type.XML;
        } else if (header.indexOf("json") > 0) {
            type = Content_Type.JSON;
        }
        return getParams(request, type);
    }

    /**
     * 获取请求中的参数
     *
     * @return
     */
    private static Map<String, String> getParams(HttpServletRequest request, Content_Type type) {
        //表单
        if (type == Content_Type.FORM) {
            Map<String, String> map = new HashMap<>();
            Enumeration<String> names = request.getParameterNames();
            while (names.hasMoreElements()) {
                String name = names.nextElement();
                map.put(name, request.getParameter(name));
            }
            return map;
        }
        if (type == Content_Type.XML) {
            String xml = getInputStreamString(request, "utf-8");
            return parseXmlToMap(xml);
        }
        if (type == Content_Type.JSON) {
            String json = getInputStreamString(request, "utf-8");
            return parseJsonToMap(json);
        }
        return null;
    }


    /**
     * 读取请求中的参数
     *
     * @param request
     * @param charset
     * @return
     */
    public static String getInputStreamString(HttpServletRequest request, String charset) {
        if (charset == null) {
            charset = "UTF-8";
        }
        StringBuffer body = new StringBuffer();
        try {
            ServletInputStream inputStream = request.getInputStream();
            InputStreamReader inputStreamReader = new InputStreamReader(inputStream, charset);
            BufferedReader br = new BufferedReader(inputStreamReader);
            while (true) {
                String info = br.readLine();
                if (StringUtils.isBlank(info)) {
                    break;
                }
                body.append(info);
            }
            inputStream.close();
            inputStreamReader.close();
            br.close();
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return body.toString();
    }


    /**
     * 将xml 转换为map
     *
     * @param xml
     * @return
     */
    public static Map<String, String> parseXmlToMap(String xml) {

        Map<String, String> map = new TreeMap<>();
        try {
            Document document = DocumentHelper.parseText(xml);
            Element root = document.getRootElement();
            Iterator<Element> rootItor = root.elementIterator();
            Map<String, Object> rsltMap = null;
            while (rootItor.hasNext()) {
                Element tmpElement = rootItor.next();
                String name = tmpElement.getName();
                String value = tmpElement.getStringValue();
                map.put(name, value);
            }
        } catch (DocumentException e) {
            e.printStackTrace();
        }
        return map;
    }

    /**
     * 将xml 转换为map
     *
     * @param json
     * @return
     */
    public static Map<String, String> parseJsonToMap(String json) {
        HashMap<String, String> hashMap = JSONObject.parseObject(json, HashMap.class);
        return hashMap;
    }


}
