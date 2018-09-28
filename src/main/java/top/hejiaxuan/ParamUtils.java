package top.hejiaxuan;


import org.apache.commons.lang3.StringUtils;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Iterator;
import java.util.Map;

/**
 * 支付参数工具
 */
public class ParamUtils {


    /**
     * 将待加密参数拼接为字符串
     *
     * @param middle
     * @param separate
     * @param params
     * @param nullIn   空值是否参与签名
     * @return
     */
    public static String paramMapJoin(String middle, String separate, Map<String, String> params, boolean nullIn) {
        boolean fristBlooan = true;
        StringBuffer signMsg = new StringBuffer();
        Iterator<Map.Entry<String, String>> iterator = params.entrySet().iterator();
        while (iterator.hasNext()) {
            Map.Entry<String, String> entry = iterator.next();
            String value = entry.getValue();
            //如果是空值 切 空值不参与签名,跳过本次循环
            if (!nullIn && StringUtils.isBlank(value)) {
                continue;
            }
            if (!fristBlooan) {
                signMsg.append(separate);
            }
            signMsg.append(entry.getKey() + middle + entry.getValue());
            fristBlooan = false;
        }
        return signMsg.toString();
    }


    /**
     * 按照url方式拼接字符串
     * @param params
     * @param charset
     * @return
     */
    public static String joinAsUrl(Map<String, String> params, String charset) {
        if (params != null && !params.isEmpty()) {
            StringBuilder query = new StringBuilder();
            boolean hasParam = false;
            Iterator<Map.Entry<String, String>> iterator = params.entrySet().iterator();
            while (iterator.hasNext()) {
                Map.Entry<String, String> entry = iterator.next();
                String name = entry.getKey();
                String value = entry.getValue();
                if (StringUtils.isNotBlank(name) && StringUtils.isNotBlank(value)) {
                    if (hasParam) {
                        query.append("&");
                    } else {
                        hasParam = true;
                    }
                    try {
                        query.append(name).append("=").append(URLEncoder.encode(value, charset));
                    } catch (UnsupportedEncodingException e) {
                        e.printStackTrace();
                    }
                }
            }

            return query.toString();
        } else {
            return null;
        }
    }


    /**
     * MD5
     *
     * @param digestStr
     * @return
     */
    public final static String md5(String digestStr) {
        char[] hexDigits = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F'};
        byte[] digestByte = digestStr.getBytes();
        try {
            MessageDigest mMessageDigest = MessageDigest.getInstance("md5");
            mMessageDigest.update(digestByte);
            byte[] secretByte = mMessageDigest.digest();
            int lenth = secretByte.length;
            char[] tempStr = new char[lenth * 2];
            int index = 0;
            for (int i = 0; i < lenth; i++) {
                byte tempByte = secretByte[i];
                tempStr[index++] = hexDigits[tempByte >>> 4 & 0xf];
                tempStr[index++] = hexDigits[tempByte & 0xf];
            }
            return new String(tempStr);
        } catch (NoSuchAlgorithmException e) {
            return "";
        }

    }

}