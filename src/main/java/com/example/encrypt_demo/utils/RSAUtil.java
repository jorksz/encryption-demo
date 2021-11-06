package com.example.encrypt_demo.utils;

import cn.hutool.crypto.CipherMode;
import cn.hutool.crypto.KeyUtil;
import org.springframework.util.Base64Utils;

import javax.crypto.Cipher;
import java.nio.charset.StandardCharsets;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.util.Base64;

public class RSAUtil {

    private RSAUtil() {

    }

    private static final String RSA = "RSA/ECB/OAEPWithSHA-256AndMGF1Padding";


    public static String encrypt(String content, PublicKey publicKey) {
        try {
            Cipher cipher = Cipher.getInstance(RSA);
            cipher.init(Cipher.ENCRYPT_MODE, publicKey);
            byte[] chars = cipher.doFinal(content.getBytes(StandardCharsets.UTF_8));
            return Base64.getEncoder().encodeToString(chars);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "";
    }


    public static String decrypt(String base64Content, PrivateKey privateKey) {
        try {
            Cipher cipher = Cipher.getInstance(RSA);
            cipher.init(Cipher.DECRYPT_MODE, privateKey);
            System.out.println(base64Content);
            byte[] bytes = cipher.doFinal(Base64.getDecoder().decode(base64Content));
            return new String(bytes, StandardCharsets.UTF_8);
        } catch (Exception e ) {
            e.printStackTrace();
        }

        return "";
    }

}
