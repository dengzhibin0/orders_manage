package com.dzb.ssm.utils;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class BCryptPasswordEncoderUtils {
    private static BCryptPasswordEncoder bCryptPasswordEncoder=new BCryptPasswordEncoder();
    public static String encodePassword(String password){
        return bCryptPasswordEncoder.encode(password);
    }

    public static void main(String[] args) {
        String password="123456";
        String pwd = encodePassword(password);
        System.out.println(pwd);
        //$2a$10$ezFdU89965wNUJCikbFwq.2DsuPGXGMgb4.3kp9oCZnmxmRPp1T4m

        System.out.print(pwd.length());
    }
}
