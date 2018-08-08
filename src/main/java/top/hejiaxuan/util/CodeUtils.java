package top.hejiaxuan.util;

import org.apache.commons.lang3.StringUtils;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.DocumentFactory;
import org.dom4j.io.OutputFormat;
import org.dom4j.io.SAXReader;
import org.dom4j.io.XMLWriter;

import java.io.IOException;
import java.io.StringReader;
import java.io.StringWriter;

/**
 * 代码工具类
 *
 * @author hjx
 */
public class CodeUtils {

    public static final String enter = "\n";
    public static final String tab = StringUtils.repeat(StringUtils.SPACE, 4);

    /**
     * 格式化json
     *
     * @param json
     * @return
     */
    public static String jsonFormat(String json) {
        if (StringUtils.isBlank(json)) {
            return "{}";
        }
        json = json.replace("\\", StringUtils.EMPTY);
        char[] chars = json.toCharArray();
        StringBuilder after = new StringBuilder();
        int times = 0;
        for (char aChar : chars) {
            switch (aChar) {
                case '{':
                case '[':
                    times++;
                    after.append(aChar).append(enter).append(StringUtils.repeat(tab, times));
                    break;
                case '}':
                case ']':
                    times--;
                    after.append(enter).append(StringUtils.repeat(tab, times)).append(aChar);
                    break;
                case ',':
                    after.append(aChar).append(enter).append(StringUtils.repeat(tab, times));
                    break;
                default:
                    after.append(aChar);
                    break;
            }
        }
        return after.toString();
    }

    public static String xmlFormat(String str) {
        XMLWriter writer = null;
        Document doc = null;
        try {
            SAXReader reader = new SAXReader();
            StringReader in = new StringReader(str);
            doc = reader.read(in);
            OutputFormat formater = OutputFormat.createPrettyPrint();
            formater.setEncoding("utf-8");
            StringWriter out = new StringWriter();
            writer = new XMLWriter(out, formater);
            writer.write(doc);
            writer.close();
            return out.toString();
        } catch (DocumentException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

}
