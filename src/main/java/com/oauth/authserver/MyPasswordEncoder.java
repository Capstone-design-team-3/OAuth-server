package com.oauth.authserver;

import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;

public class MyPasswordEncoder {
    
    public static void main(String[] args) {
        PasswordEncoder passwordEncoder = PasswordEncoderFactories.createDelegatingPasswordEncoder();
    
        System.out.println("bar : " + passwordEncoder.encode("bar"));
        System.out.println("pass : " + passwordEncoder.encode("pass"));
    }
    
}
