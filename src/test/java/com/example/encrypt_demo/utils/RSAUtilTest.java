package com.example.encrypt_demo.utils;

import org.junit.jupiter.api.Test;

import java.nio.charset.StandardCharsets;
import java.util.Base64;

import static org.junit.jupiter.api.Assertions.*;

class RSAUtilTest {

    @Test
    void encrypt() {
        RSAKey rsaKey = RSAKey.getInstance();
        String test = "haha";
        String encryptStr = RSAUtil.encrypt(test, rsaKey.getPublicKey());
        System.out.println(encryptStr);

        String decryptStr = RSAUtil.decrypt(encryptStr, rsaKey.getPrivateKey());
        System.out.println(new String(Base64.getDecoder().decode(decryptStr), StandardCharsets.UTF_8));
    }

    @Test
    void decrypt() {
    }
}