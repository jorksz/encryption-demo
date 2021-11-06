package com.example.encrypt_demo.utils;

import cn.hutool.crypto.KeyUtil;

import java.security.KeyPair;
import java.security.PrivateKey;
import java.security.PublicKey;

public class RSAKey {

    private final PublicKey publicKey;
    private final PrivateKey privateKey;
    private static final KeyPair KEY_PAIR = KeyUtil.generateKeyPair("RSA");
    private static volatile RSAKey rsaKey;

    private RSAKey() {
        this.publicKey = KEY_PAIR.getPublic();
        this.privateKey = KEY_PAIR.getPrivate();
    }

    public PublicKey getPublicKey() {
        return publicKey;
    }

    public PrivateKey getPrivateKey() {
        return privateKey;
    }

    public static RSAKey getInstance() {
        if (rsaKey == null) {
            synchronized (RSAKey.class) {
                if (rsaKey == null) {
                    rsaKey = new RSAKey();
                }
            }
        }
        return rsaKey;
    }


}
