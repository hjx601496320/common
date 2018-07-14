package top.hejiaxuan.util;

import org.junit.Test;

import java.util.Map;

import static org.junit.Assert.*;

/**
 * 测试是否有XXE注入漏洞
 */
public class XMLUtilTest {

    String xml_1 = "" +
            "<?xml version=\"1.0\"?>\n" +
            "<!DOCTYPE a SYSTEM \"http://127.0.0.1:8083/payment-web/entities.dtd\" >\n" +
            "<note>\n" +
            "  <to>George</to>\n" +
            "  <from>John</from>\n" +
            "  <heading>Reminder</heading>\n" +
            "  <body>Don't forget the meeting!</body>\n" +
            "</note>" +
            "";

    @Test
    public void toMap() {
        Map<String, String> map = XMLUtil.toMap(xml_1);
        System.out.println(map);
    }
}