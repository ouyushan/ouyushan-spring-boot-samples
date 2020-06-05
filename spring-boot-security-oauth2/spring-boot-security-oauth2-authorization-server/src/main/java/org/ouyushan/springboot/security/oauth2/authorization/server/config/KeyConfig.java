package org.ouyushan.springboot.security.oauth2.authorization.server.config;

import org.springframework.core.io.ClassPathResource;
import org.springframework.security.crypto.codec.Base64;
import org.springframework.security.crypto.keygen.KeyGenerators;
import org.springframework.security.oauth2.provider.token.store.KeyStoreKeyFactory;

import java.security.KeyPair;
import java.security.interfaces.RSAPrivateKey;
import java.security.interfaces.RSAPublicKey;

/**
 * @Description:
 * @Author: ouyushan
 * @Email: ouyushan@hotmail.com
 * @Date: 2020/5/11 18:07
 */
class KeyConfig {
    private static final String KEY_STORE_FILE = ".keystore-oauth2-demo";
    private static final String KEY_STORE_PASSWORD = "admin1234";
    private static final String KEY_ALIAS = "oauth2-demo-key";
    private static KeyStoreKeyFactory KEY_STORE_KEY_FACTORY = new KeyStoreKeyFactory(
            new ClassPathResource(KEY_STORE_FILE), KEY_STORE_PASSWORD.toCharArray());
    static final String VERIFIER_KEY_ID = new String(Base64.encode(KeyGenerators.secureRandom(32).generateKey()));

    static RSAPublicKey getVerifierKey() {
        return (RSAPublicKey) getKeyPair().getPublic();
    }

    static RSAPrivateKey getSignerKey() {
        return (RSAPrivateKey) getKeyPair().getPrivate();
    }

    private static KeyPair getKeyPair() {
        return KEY_STORE_KEY_FACTORY.getKeyPair(KEY_ALIAS);
    }
}