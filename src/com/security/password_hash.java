package com.security;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class password_hash {
    
    private String h;
    private static String algorithm = "MD5";
    
    public String password_hash(String password) throws Exception{   
        return h = generateHash(password, algorithm);
    }

    private String generateHash(String password, String algorithm) throws NoSuchAlgorithmException {
        
        MessageDigest digest = MessageDigest.getInstance(algorithm);
        digest.reset();
        byte[] hash = digest.digest(password.getBytes());
        
        return bytesToStringHex(hash);
    }

    private final static char[] hexArray = "0123456789ABCDEF".toCharArray();
    
    private String bytesToStringHex(byte[] bytes) {
        char[] hexChars = new char[bytes.length * 2];
        for (int j = 0; j<bytes.length ; j++){
            int v = bytes[j] & 0xFF;
            hexChars[j*2] = hexArray[v >>> 4];
            hexChars[j*2+1] = hexArray[v & 0x0F];
        }
        return new String(hexChars);
    }

    
    
}
