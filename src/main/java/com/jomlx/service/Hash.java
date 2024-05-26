package com.jomlx.service;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class Hash {
    public Hash() {   }
    
    public static String hashPassword(char[] password) {
        try {
            MessageDigest md = MessageDigest.getInstance("SHA-256");
            byte[] hashedBytes = md.digest(new String(password).getBytes());
            
            StringBuilder sb = new StringBuilder();
            for (byte b: hashedBytes) {
                sb.append(String.format("%02x", b));
            }
            return sb.toString();
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException("SHA-256 algorithm not found!", e);
        }
    }
}
