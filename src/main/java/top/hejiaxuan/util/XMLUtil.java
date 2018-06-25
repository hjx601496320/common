package top.hejiaxuan.util;

import org.apache.commons.lang3.StringUtils;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.DocumentHelper;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;


/**
 * <P>Description: XML转换工具</P>
 *
 * @author 张璞 puzhanga@isoftstone.com  2016年10月20日 下午7:24:03
 * @ClassName: XMLUtil
 * @see
 */
public class XMLUtil {


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
        Map<String, String> map = new HashMap<>();
        Document document = null;
        try {
            document = DocumentHelper.parseText(xml);
        } catch (DocumentException e) {
            e.printStackTrace();
        }
        if (document == null) {
            return map;
        }
        org.dom4j.Element root = document.getRootElement();
        Iterator<org.dom4j.Element> rootItor = root.elementIterator();
        while (rootItor.hasNext()) {
            org.dom4j.Element tmpElement = rootItor.next();
            String name = tmpElement.getName();
            String value = tmpElement.getStringValue();
            map.put(name, value);
        }
        return map;
    }


}
