package top.hejiaxuan;

import org.joda.time.DateTime;

import java.util.Random;
import java.util.UUID;

/**
 * uuid_32 工具类
 * <p>
 * Created by hjx on 2017/8/2.
 */
public class RandomUtils {

    /**
     * 32位的uuid
     *
     * @return
     */
    public static String uuid_32() {
        String uuid = UUID.randomUUID().toString();
        uuid = uuid.replace("-", "");
        return uuid;
    }

    /**
     * 16位的uuid
     *
     * @return
     */
    public static String uuid_16() {
        String uuid = UUID.randomUUID().toString();
        uuid = uuid.replace("-", "").substring(0, 16);
        return uuid;
    }

    public static String timeCode() {
        String timeStr = new DateTime().toString("yyyyMMddHH");
        return timeStr;
    }


}
