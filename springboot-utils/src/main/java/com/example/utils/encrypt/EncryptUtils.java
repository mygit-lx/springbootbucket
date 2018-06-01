package com.example.utils.encrypt;
import javax.crypto.*;

import javax.crypto.spec.SecretKeySpec;

import com.sun.org.apache.xerces.internal.impl.dv.util.Base64;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


public class EncryptUtils {
    
    private static Logger logger = LoggerFactory.getLogger(EncryptUtils.class);

    private static final String Algorithm = "DESede"; //定义 加密算法,可用 DES,DESede,Blowfish

    /**
     * 3des解码
     * @param value 待解密字符串
     * @param key   原始密钥字符串
     * @return
     * @throws Exception
     */
    public static String decrypt3DES(String value, String key) throws Exception {
        byte[] b = decryptMode(getKeyBytes(key), Base64.decode(value));
        return new String(b);
    }

    /**
     * 3des加密
     * @param value 待加密字符串
     * @param key   原始密钥字符串
     * @return
     * @throws Exception
     */
    public static String encrypt3DES(String value, String key) throws Exception {
        String str = byte2Base64(encryptMode(getKeyBytes(key), value.getBytes()));
        return str;
    }


    /**
     * 计算24位长的密码byte值,首先对原始密钥做MD5算hash值，再用前8位数据对应补全后8位
     * @param strKey
     * @return
     * @throws Exception
     */
    public static byte[] getKeyBytes(String strKey) throws Exception {
        if (null == strKey || strKey.length() < 1)
            throw new Exception("key is null or empty!");
        java.security.MessageDigest alg = java.security.MessageDigest.getInstance("MD5");
        alg.update(strKey.getBytes());
        byte[] bkey = alg.digest();
        logger.info("md5key.length={}" , bkey.length);
        logger.info("md5key={}" , byte2hex(bkey));
        int start = bkey.length;
        byte[] bkey24 = new byte[24];
        for (int i = 0; i < start; i++) {
            bkey24[i] = bkey[i];
        }
        for (int i = start; i < 24; i++) {//为了与.net16位key兼容
            bkey24[i] = bkey[i - start];
        }
        logger.info("byte24key.length={}" , bkey24.length);
        logger.info("byte24key={}" , byte2hex(bkey24));
        return bkey24;
    }

    /**
     *
     * @param keybyte 加密密钥，长度为24字节
     * @param src     被加密的数据缓冲区（源）
     * @return
     */
    public static byte[] encryptMode(byte[] keybyte, byte[] src) {
        try {
            //生成密钥
            SecretKey deskey = new SecretKeySpec(keybyte, Algorithm); //加密
            Cipher c1 = Cipher.getInstance(Algorithm);
            c1.init(Cipher.ENCRYPT_MODE, deskey);
            return c1.doFinal(src);
        } catch (java.security.NoSuchAlgorithmException e1) {
            e1.printStackTrace();
        } catch (javax.crypto.NoSuchPaddingException e2) {
            e2.printStackTrace();
        } catch (java.lang.Exception e3) {
            e3.printStackTrace();
        }
        return null;

    }

    /**
     *
     * @param keybyte 加密密钥，长度为24字节
     * @param src     加密后的缓冲区
     * @return
     */
    public static byte[] decryptMode(byte[] keybyte, byte[] src) {
        try { //生成密钥
            SecretKey deskey = new SecretKeySpec(keybyte, Algorithm);
            //解密
            Cipher c1 = Cipher.getInstance(Algorithm);
            c1.init(Cipher.DECRYPT_MODE, deskey);
            return c1.doFinal(src);
        } catch (java.security.NoSuchAlgorithmException e1) {
            e1.printStackTrace();
        } catch (javax.crypto.NoSuchPaddingException e2) {
            e2.printStackTrace();
        } catch (java.lang.Exception e3) {
            e3.printStackTrace();
        }
        return null;
    }

    /**
     * 转换成base64编码
     * @param b
     * @return
     */
    public static String byte2Base64(byte[] b) {
        return Base64.encode(b);
    }

    /**
     * 转换成十六进制字符串
     * @param b
     * @return
     */
    public static String byte2hex(byte[] b) {
        String hs = "";
        String stmp = "";
        for (int n = 0; n < b.length; n++) {
            stmp = (java.lang.Integer.toHexString(b[n] & 0XFF));
            if (stmp.length() == 1)
                hs = hs + "0" + stmp;
            else
                hs = hs + stmp;
            if (n < b.length - 1)
                hs = hs + ":";
        }
        return hs.toUpperCase();
    }

    public static void main(String[] args) {
        String key = "abcd1234";
        String password = "password";
        System.out.println("key=" + key + ",password=" + password);
        System.out.println();
        System.out.println("----------示例开始：使用java写的算法加密解密-----------");
        try {
            String encrypt = "";
            String decrypt = "";
            byte[] bkey = EncryptUtils.getKeyBytes(key);
            encrypt = EncryptUtils.byte2Base64(EncryptUtils.encryptMode(bkey, password.getBytes()));
            System.out.println("用预转换密钥算加密结果=" + encrypt);
            System.out.println("加密后base64表示=" + EncryptUtils.byte2hex(Base64.decode(encrypt)));
            System.out.println("调用原始密钥算加密结果=" + EncryptUtils.encrypt3DES(password, key));
            try {
                decrypt = new String(EncryptUtils.decryptMode(bkey, Base64.decode(encrypt)));
                System.out.println("用预转换密钥算解密结果=" + decrypt);
                System.out.println("调用原始密钥算解密结果=" + EncryptUtils.decrypt3DES(encrypt, key));
            } catch (Exception ex) {
                System.out.println("Exception:" + ex.getMessage());
            }
        } catch (Exception ex) {
            System.out.println("Exception:" + ex.getMessage());
        }
        System.out.println("----------示例结束：使用java写的算法加密解密-----------");
    }

}
