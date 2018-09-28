package top.hejiaxuan;

import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class TestOne {

    static List<String> strings = new ArrayList<>();

    {
        strings.add("/home/zhapp/channel/msgs/201706/15163359731660.txt");
        strings.add("/home/zhapp/channel/msgs/201711/15210011611572.txt");
        strings.add("/home/zhapp/channel/msgs/201710/17173036996129.txt");
        strings.add("/home/zhapp/channel/msgs/201710/18232923567991.txt");
        strings.add("/home/zhapp/channel/msgs/201707/31105614985895.txt");
        strings.add("/home/zhapp/channel/msgs/201806/07182045624752.txt");
        strings.add("/home/zhapp/channel/msgs/201710/1821421351797.txt");
        strings.add("/home/zhapp/channel/msgs/201806/07160216025278.txt");
        strings.add("/home/zhapp/channel/msgs/201805/06172033814790.txt");
        strings.add("/home/zhapp/channel/msgs/201806/06153331121861.txt");
        strings.add("/home/zhapp/channel/msgs/201806/05201449810493.txt");
        strings.add("/home/zhapp/channel/msgs/201806/061602070661095.txt");
        strings.add("/home/zhapp/channel/msgs/201706/16140401801374.txt");
        strings.add("/home/zhapp/channel/msgs/201709/111155113721000.txt");
        strings.add("/home/zhapp/channel/msgs/201804/08103539635551.txt");
        strings.add("/home/zhapp/channel/msgs/201806/06095924296931.txt");
        strings.add("/home/zhapp/channel/msgs/201711/16075010323408.txt");
        strings.add("/home/zhapp/channel/msgs/201806/06160240048948.txt");
        strings.add("/home/zhapp/channel/msgs/201707/31142550259223.txt");
        strings.add("/home/zhapp/channel/msgs/201806/201919212521065.txt");
        strings.add("/home/zhapp/channel/msgs/201806/06153932362315.txt");
        strings.add("/home/zhapp/channel/msgs/201710/18235438624109.txt");
        strings.add("/home/zhapp/channel/msgs/201711/01162931841957.txt");
        strings.add("/home/zhapp/channel/msgs/201710/18235909326279.txt");
        strings.add("/home/zhapp/channel/msgs/201803/29111900500170.txt");
        strings.add("/home/zhapp/channel/msgs/201806/06160536892571.txt");
        strings.add("/home/zhapp/channel/msgs/201805/30195607970449.txt");
    }
    @Test
    public void name() throws IOException {
        for (String string : strings) {
            getFile("172.31.100.19", string, "/home/hjx");
        }
    }
    public String getFile(String ip, String remotFilePath, String targetFilePath) throws IOException {
        String command = MessageFormat.format("expect /home/hjx/sh/scp-pubmi.sh {0} {1} {2}", ip, remotFilePath, targetFilePath);
        Process process = Runtime.getRuntime().exec(command);
        InputStream inputStream = process.getInputStream();
        Scanner scanner = new Scanner(inputStream);
        while (scanner.hasNextLine()) {
            String nextLine = scanner.nextLine();
            System.out.println(nextLine);
        }
        return "SUCCESS";
    }
}
