package top.hejiaxuan.util;

import org.apache.commons.lang3.StringUtils;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.DocumentHelper;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.TreeMap;

/**
 * xml转换工具
 */
public class XMLUtil {

    /**
     * 防止
     * 暴露的XML外部实体注入漏洞(XML External Entity Injection，简称 XXE)
     */
    static DocumentBuilderFactory documentBuilderFactory = DocumentBuilderFactory.newInstance();

    static {
        Map<String, Boolean> FEATURE_MAP = new HashMap() {{
            put("http://apache.org/xml/features/disallow-doctype-decl", true);
            put("http://xml.org/sax/features/external-general-entities", false);
            put("http://xml.org/sax/features/external-parameter-entities", false);
            put("http://apache.org/xml/features/nonvalidating/load-external-dtd", false);
        }};
        for (Map.Entry<String, Boolean> entry : FEATURE_MAP.entrySet()) {
            try {
                documentBuilderFactory.setFeature(entry.getKey(), entry.getValue());
            } catch (ParserConfigurationException e) {
                e.printStackTrace();
            }
        }
        documentBuilderFactory.setXIncludeAware(false);
        documentBuilderFactory.setExpandEntityReferences(false);
    }

    /**
     * map to xml
     *
     * @param parameters
     * @return
     */
    public static String toXml(Map<String, String> parameters) {
        StringBuffer sb = new StringBuffer();
        sb.append("<xml>");
        sb.append("\n");
        Iterator<Entry<String, String>> iterator = parameters.entrySet().iterator();
        while (iterator.hasNext()) {
            Entry<String, String> entry = iterator.next();
            String value = entry.getValue();
            String key = entry.getKey();
            if (StringUtils.isBlank(value)) {
                continue;
            }
            sb.append("<").append(entry.getKey()).append(">");
            sb.append("<![CDATA[");
            sb.append(entry.getValue());
            sb.append("]]>");
            sb.append("</").append(entry.getKey()).append(">");
            sb.append("\n");
        }
        sb.append("</xml>");
        return sb.toString();
    }

    /**
     * xml to map
     *
     * @param xml
     * @return
     */
    public static Map<String, String> toMap(String xml) {
        Map<String, String> map = new TreeMap<>();
        try {
            DocumentBuilder documentBuilder = documentBuilderFactory.newDocumentBuilder();
            org.w3c.dom.Document document = documentBuilder.parse(new ByteArrayInputStream(xml.getBytes()));
            Node root = document.getFirstChild();
            NodeList childNodes = root.getChildNodes();
            for (int i = 0; i < childNodes.getLength(); i++) {
                Node item = childNodes.item(i);
                if (item instanceof Element) {
                    String nodeName = item.getNodeName();
                    String nodeValue = item.getTextContent();
                    map.put(nodeName, nodeValue);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ParserConfigurationException e) {
            e.printStackTrace();
        } catch (SAXException e) {
            e.printStackTrace();
        }
        return map;
    }

}
