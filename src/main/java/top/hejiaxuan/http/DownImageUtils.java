package top.hejiaxuan.http;

import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URL;
import java.net.URLConnection;

/**
 * 图片下载工具
 */
public class DownImageUtils {

    /**
     * 下载图片
     *
     * @param urlString 图片的 http 路径
     * @param filename  保存的文件名称
     * @param savePath  保存的路径
     */
    public static void download(String urlString, String filename, String savePath) {
        try {
            URL url = new URL(urlString);
            URLConnection connection = url.openConnection();
            connection.setRequestProperty("User-Agent", "Mozilla/4.0 (compatible; MSIE 5.0; Windows NT; DigExt)");
            connection.setConnectTimeout(1000 * 10);
            InputStream is = connection.getInputStream();
            byte[] bs = new byte[1024 * 10];
            int len;
            File sf = new File(savePath);
            if (!sf.exists()) {
                sf.mkdirs();
            }
            OutputStream os = new FileOutputStream(sf.getPath() + "/" + filename);
            while ((len = is.read(bs)) != -1) {
                os.write(bs, 0, len);
            }
            os.close();
            is.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
