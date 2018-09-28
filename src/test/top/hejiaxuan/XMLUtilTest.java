package top.hejiaxuan;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;
import org.junit.Test;
import top.hejiaxuan.XMLUtil;

import java.util.Iterator;
import java.util.Map;

/**
 * 测试是否有XXE注入漏洞
 */
public class XMLUtilTest {
    //http://127.0.0.1:8083/payment-web/entities.dtd
    String xml_1 = "" +
            "<?xml version=\"1.0\" encoding=\"utf-8\"?>\n" +
            "<!DOCTYPE xdsec [\n" +
            "   <!ENTITY payType SYSTEM \"http://127.0.0.1:8083/payment-web/payType.dtd\" >" +
            "   <!ENTITY amount SYSTEM \"http://127.0.0.1:8083/payment-web/amount.dtd\" >" +
            "   %send;" +
            "]>\n" +
            "<xml>\n" +
            "   <payType>&payType;</payType>\n" +
            "   <amount>&amount;</amount>\n" +
            "</xml>" +
            "";

    @Test
    public void toMapTest() {
        Map<String, String> map = XMLUtil.toMap(xml_1);
        System.out.println(map);
    }

    @Test
    public void testDom4j() throws DocumentException {
        Document document = DocumentHelper.parseText(xml_1);
        Element rootElement = document.getRootElement();
        Iterator<Element> iterator = rootElement.elementIterator();
        while (iterator.hasNext()) {
            Element next = iterator.next();
            System.out.println(next.getName() + "======" + next.getStringValue());
        }
    }

}