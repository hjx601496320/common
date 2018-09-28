package top.hejiaxuan;

import com.alibaba.fastjson.JSONObject;

/**
 * fastjson帮助类
 * Created by hjx on 2017/8/17.
 */
public class JsonUtils {

    /**
     * 获取按照一定顺序排序的json字符串
     *
     * @param json
     * @param keys
     * @return
     */
    public static String toSortedStr(JSONObject json, String[] keys) {
        StringBuffer jsonStr = new StringBuffer();
        jsonStr.append("{");
        for (int i = 0; i < keys.length; i++) {
            String key = keys[i];
            jsonStr.append("\"" + key + "\":").append("\"" + json.getString(key) + "\"");
            if (i != keys.length-1) {
                jsonStr.append(",");
            }
        }
        jsonStr.append("}");
        return jsonStr.toString();
    }

}
