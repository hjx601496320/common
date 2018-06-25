package top.hejiaxuan.util;


import com.alibaba.fastjson.JSONObject;

import java.lang.reflect.Field;
import java.util.*;

/**
 * 对象的工具类
 * Created by hjx on 2017/8/3.
 */
public class ObjectUtils {

    /**
     * 将 Object 转换为Map,包含其父类的属性（排除Object）
     *
     * @param bean
     * @return
     * @author hejiaxuan  by 2017/3/24 0024-10:13
     */
    public static Map<String, String> toMap(Object bean) {
        Map<String, String> map = new HashMap<>();
        Field[] fields = getDeclaredFields(bean);
        for (Field field : fields) {
            field.setAccessible(true);
            Object v = getV(bean, field);
            String n = field.getName();
            map.put(n, v != null ? v.toString() : null);
        }
        return map;
    }


    /**
     * 将 Object 转换为Map,包含其父类的属性（排除Object）
     * 只取出传入数组中的参数
     *
     * @param bean
     * @param names
     * @return
     */
    public static Map<String, String> toMap(Object bean, String[] names) {
        Map<String, String> map = new HashMap<>();
        List<String> nameList = Arrays.asList(names);
        Field[] fields = getDeclaredFields(bean);
        for (Field field : fields) {
            String name = field.getName();
            if (nameList.indexOf(name) > -1) {
                field.setAccessible(true);
                Object v = getV(bean, field);
                String n = field.getName();
                map.put(n, v != null ? v.toString() : null);
            }
        }
        return map;
    }

    public static Field[] getDeclaredFields(Object object) {
        List<Field> fieldList = new ArrayList<>();
        Class<?> clazz = object.getClass();
        for (; clazz != Object.class; clazz = clazz.getSuperclass()) {
            try {
                Field[] fields = clazz.getDeclaredFields();
                fieldList.addAll(Arrays.asList(fields));
            } catch (Exception e) {
            }
        }
        return fieldList.toArray(new Field[]{});
    }

    private static Object getV(Object bean, Field field) {
        try {
            return field.get(bean);
        } catch (IllegalAccessException e) {
            return null;
        }
    }

}
