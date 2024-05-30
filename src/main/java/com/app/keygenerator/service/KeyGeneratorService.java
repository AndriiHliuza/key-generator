package com.app.keygenerator.service;

import org.springframework.stereotype.Service;

import java.security.SecureRandom;

@Service
public class KeyGeneratorService {
    public String generateAESKey() {
        byte[] key = new byte[128 / 8];
        SecureRandom secureRandom = new SecureRandom();
        secureRandom.nextBytes(key);
        StringBuilder stringBuilder = new StringBuilder();
        for (byte b : key) {
            stringBuilder.append(String.format("%02x", b));
        }
        String keyHex = stringBuilder.toString();
        System.out.println("AES key: " + keyHex);
        return keyHex;
    }

    public String generateHMACSHA256CodeForJwt() { //hmac sha-256 code
        byte[] keyBytes = new byte[32];
        SecureRandom secureRandom = new SecureRandom();
        secureRandom.nextBytes(keyBytes);

        StringBuilder hexString = new StringBuilder(2 * keyBytes.length);
        for (byte b : keyBytes) {
            String hex = Integer.toHexString(0xff & b);
            if (hex.length() == 1) {
                hexString.append('0');
            }
            hexString.append(hex);
        }
        String hexKey = hexString.toString().toUpperCase();
        System.out.println("HMAC key: " + hexKey);
        return hexKey;
    }

}
