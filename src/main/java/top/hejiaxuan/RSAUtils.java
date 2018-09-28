package top.hejiaxuan;


import org.apache.commons.lang3.StringUtils;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.StringWriter;
import java.security.KeyFactory;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.Signature;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.PKCS8EncodedKeySpec;
import java.security.spec.X509EncodedKeySpec;

/**
 * RSA 工具类
 */
public class RSAUtils {

    /**
     * 签名
     *
     * @param content
     * @param privateKey
     * @param charset
     * @param signType
     * @return
     */
    public static String rsaSign(String content, String privateKey, String charset, String signType) {
        if ("RSA".equals(signType)) {
            return rsaSign(content, privateKey, charset);
        } else if ("RSA2".equals(signType)) {
            return rsa256Sign(content, privateKey, charset);
        } else {
            throw new RuntimeException("Sign Type is Not Support : signType=" + signType);
        }
    }

    /**
     * 验证签名
     *
     * @param content
     * @param sign
     * @param publicKey
     * @param charset
     * @param signType
     * @return
     */
    public static boolean rsaCheck(String content, String sign, String publicKey, String charset, String signType) {
        if ("RSA".equals(signType)) {
            return rsaCheckContent(content, sign, publicKey, charset);
        } else if ("RSA2".equals(signType)) {
            return rsa256CheckContent(content, sign, publicKey, charset);
        } else {
            throw new RuntimeException("Sign Type is Not Support : signType=" + signType);
        }
    }

    /**********************************************************************************************************************************************************/


    private static String rsa256Sign(String content, String privateKey, String charset) {
        try {
            PrivateKey e = getPrivateKeyFromPKCS8("RSA", new ByteArrayInputStream(privateKey.getBytes()));
            Signature signature = Signature.getInstance("SHA256WithRSA");
            signature.initSign(e);
            if (StringUtils.isBlank(charset)) {
                signature.update(content.getBytes());
            } else {
                signature.update(content.getBytes(charset));
            }

            byte[] signed = signature.sign();
            return new String(Base64Utils.encodeBase64(signed));
        } catch (Exception var6) {
            throw new RuntimeException("RSAcontent = " + content + "; charset = " + charset, var6);
        }
    }

    private static boolean rsaCheckContent(String content, String sign, String publicKey, String charset) {
        try {
            PublicKey e = getPublicKeyFromX509("RSA", new ByteArrayInputStream(publicKey.getBytes()));
            Signature signature = Signature.getInstance("SHA1WithRSA");
            signature.initVerify(e);
            if (StringUtils.isEmpty(charset)) {
                signature.update(content.getBytes());
            } else {
                signature.update(content.getBytes(charset));
            }
            return signature.verify(Base64Utils.decodeBase64(sign.getBytes()));
        } catch (Exception var6) {
            throw new RuntimeException("RSAcontent = " + content + ",sign=" + sign + ",charset = " + charset, var6);
        }
    }

    private static boolean rsa256CheckContent(String content, String sign, String publicKey, String charset) {
        try {
            PublicKey e = getPublicKeyFromX509("RSA", new ByteArrayInputStream(publicKey.getBytes()));
            Signature signature = Signature.getInstance("SHA256WithRSA");
            signature.initVerify(e);
            if (StringUtils.isEmpty(charset)) {
                signature.update(content.getBytes());
            } else {
                signature.update(content.getBytes(charset));
            }

            return signature.verify(Base64Utils.decodeBase64(sign.getBytes()));
        } catch (Exception var6) {
            throw new RuntimeException("RSAcontent = " + content + ",sign=" + sign + ",charset = " + charset, var6);
        }
    }

    private static String rsaSign(String content, String privateKey, String charset) {
        try {
            PrivateKey e = getPrivateKeyFromPKCS8("RSA", new ByteArrayInputStream(privateKey.getBytes()));
            Signature signature = Signature.getInstance("SHA1WithRSA");
            signature.initSign(e);
            if (StringUtils.isEmpty(charset)) {
                signature.update(content.getBytes());
            } else {
                signature.update(content.getBytes(charset));
            }

            byte[] signed = signature.sign();
            return new String(Base64Utils.encodeBase64(signed));
        } catch (InvalidKeySpecException var6) {
            throw new RuntimeException("RSA私钥格式不正确，请检查是否正确配置了PKCS8格式的私钥", var6);
        } catch (Exception var7) {
            throw new RuntimeException("RSAcontent = " + content + "; charset = " + charset, var7);
        }
    }


    private static PrivateKey getPrivateKeyFromPKCS8(String algorithm, InputStream ins) throws Exception {
        if (ins != null && !StringUtils.isEmpty(algorithm)) {
            KeyFactory keyFactory = KeyFactory.getInstance(algorithm);
            byte[] encodedKey = StreamUtil.readText(ins).getBytes();
            encodedKey = Base64Utils.decodeBase64(encodedKey);
            return keyFactory.generatePrivate(new PKCS8EncodedKeySpec(encodedKey));
        } else {
            return null;
        }
    }


    private static PublicKey getPublicKeyFromX509(String algorithm, InputStream ins) throws Exception {
        KeyFactory keyFactory = KeyFactory.getInstance(algorithm);
        StringWriter writer = new StringWriter();
        StreamUtil.io(new InputStreamReader(ins), writer);
        byte[] encodedKey = writer.toString().getBytes();
        encodedKey = Base64Utils.decodeBase64(encodedKey);
        return keyFactory.generatePublic(new X509EncodedKeySpec(encodedKey));
    }


}
