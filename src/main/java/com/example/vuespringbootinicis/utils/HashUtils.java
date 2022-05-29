package com.example.vuespringbootinicis.utils;


import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;

public class HashUtils {

    public static String getSignature(String oid, int price, long timestamp) {
        String params = "oid=" + oid + "&price=" + price + "&timestamp=" + timestamp;
        return sha256Encrypt(params);
    }

    public static String getMkey(String mid) {
        return sha256Encrypt(mid);
    }

    private static String sha256Encrypt(String params) {
        try{
            MessageDigest digest = MessageDigest.getInstance("SHA-256");
            byte[] hash = digest.digest(params.getBytes(StandardCharsets.UTF_8));
            StringBuilder hexString = new StringBuilder();

            for (byte b : hash) {
                String hex = Integer.toHexString(0xff & b);
                if (hex.length() == 1) hexString.append('0');
                hexString.append(hex);
            }
            return hexString.toString();
        } catch(Exception ex){
            throw new RuntimeException(ex);
        }
    }
}
