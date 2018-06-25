package top.hejiaxuan.util;

import org.apache.commons.lang3.ArrayUtils;
import org.apache.commons.lang3.StringUtils;

import java.lang.reflect.Field;

/**
 * 验证对象参数
 * Created by hjx on 2017/8/3.
 */
public class VerifyUtils {

    /**
     * 查看改obj 中有没有为空的属性（包括父类属性）
     * 返回值为null 表示没有参数为空
     * 返回值调式为空的参数
     *
     * @param o
     * @param ignores 要忽略的属性
     * @return
     */
    public static String nullValue(Object o, String[] ignores) {
        Class aClass = o.getClass();
        while (aClass.getSuperclass() != null && aClass != Object.class) {
            Field[] fields = aClass.getDeclaredFields();
            for (int i = 0; i < fields.length; i++) {
                Field field = fields[i];
                String key = field.getName();
                if (ArrayUtils.contains(ignores, key)) {
                    continue;
                }
                Class fieldClass = field.getType();
                Object value = null;
                field.setAccessible(true);
                try {
                    value = field.get(o);
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                }
                if (value == null) {
                    return key;
                }
                if (String.class == fieldClass) {
                    if (StringUtils.isBlank(value.toString())) {
                        return key;
                    }
                }
            }
            aClass = aClass.getSuperclass();
        }
        return null;
    }

}