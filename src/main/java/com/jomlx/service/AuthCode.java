package com.jomlx.service;

import java.util.Random;

public class AuthCode {
    private static final int OTP_LENGTH = 6;
    
    public AuthCode() { }
    public static String generateOTP() {
        StringBuilder otp = new StringBuilder();
        Random random = new Random();
        for (int i = 0; i < OTP_LENGTH; i++) {
            otp.append(random.nextInt(10));
        }
        return otp.toString();
    }
    
}
