package top.hejiaxuan;

import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;

public class StringUtils  {

    public static final String SPACE = " ";

    public static final String BLANK = "";

    public static final String COMMA = ", ";

    /**
     * 重复字符串
     *
     * @param str
     * @param number
     * @return
     */
    public static String[] repeat(String str, int number) {
        String[] strings = new String[number];
        for (int i = 0; i < number; i++) {
            strings[i] = str;
        }
        return strings;
    }

    /**
     * 组合字符串
     *
     * @param strings
     * @return
     */
    public static String append(final Object... strings) {
        StringBuilder builder = new StringBuilder();
        for (Object s1 : strings) {
            if (s1 == null) {
                continue;
            }
            builder.append(s1.toString());
        }
        return builder.toString();
    }

    /**
     * 组合字符串
     *
     * @param collection
     * @param separator
     * @return
     */
    public static String join(Collection collection, String separator) {
        StringBuffer var2 = new StringBuffer();
        for (Iterator var3 = collection.iterator(); var3.hasNext(); var2.append((String) var3.next())) {
            if (var2.length() != 0) {
                var2.append(separator);
            }
        }
        return var2.toString();
    }

    /**
     * 组合字符串
     *
     * @param objects
     * @param separator
     * @return
     */
    public static String join(Object[] objects, String separator) {
        return join(Arrays.asList(objects), separator);
    }
}