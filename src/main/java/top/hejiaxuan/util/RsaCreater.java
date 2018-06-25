package top.hejiaxuan.util;


import sun.misc.BASE64Encoder;

import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.interfaces.RSAPrivateKey;
import java.security.interfaces.RSAPublicKey;


/**
 * rsa秘钥的生成工具类
 */
public class RsaCreater {


    private String publicKey;
    private String privateKey;


    /**
     * 獲取公钥和私钥
     *
     * @return
     */
    public static RsaCreater getKey() {
        RsaCreater rsaUtils = new RsaCreater();
        try {
            rsaUtils.initKey();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return rsaUtils;
    }


    static final String KEY_ALGORITHM = "RSA";


    //编码返回字符串
    String encryptBASE64(byte[] key) throws Exception {
        return (new BASE64Encoder()).encodeBuffer(key);
    }

    //map对象中存放公私钥
    void initKey() throws Exception {
        //获得对象 KeyPairGenerator 参数 RSA 1024个字节
        KeyPairGenerator keyPairGen = KeyPairGenerator.getInstance(KEY_ALGORITHM);
        keyPairGen.initialize(1024);
        //通过对象 KeyPairGenerator 获取对象KeyPair
        KeyPair keyPair = keyPairGen.generateKeyPair();
        //通过对象 KeyPair 获取RSA公私钥对象RSAPublicKey RSAPrivateKey
        RSAPublicKey publicKey = (RSAPublicKey) keyPair.getPublic();
        RSAPrivateKey privateKey = (RSAPrivateKey) keyPair.getPrivate();

        this.privateKey = encryptBASE64(privateKey.getEncoded());
        this.publicKey = encryptBASE64(publicKey.getEncoded());

    }

    private RsaCreater() {

    }

    public String getPublicKey() {
        return publicKey;
    }

    public String getPrivateKey() {
        return privateKey;
    }
}