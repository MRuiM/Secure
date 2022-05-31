package com.example.day19.security.utility;


import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class SHAEncoder implements PasswordEncoder {

    private final Logger logger = LogManager.getLogger(this.getClass());

    @Override
    public String encode(CharSequence charSequence) {
        if(charSequence != null) {
            String hashword = null;
            try {
                MessageDigest md = MessageDigest.getInstance("SHA-1");
                md.update(charSequence.toString().getBytes());
                BigInteger hash = new BigInteger(1, md.digest());
                hashword = hash.toString(16).toUpperCase();
            } catch (NoSuchAlgorithmException ex) {
                this.logger.error("No such algorithm", ex);
            }
            return hashword;
        } else {
            this.logger.warn("Empty encoded password");
            return null;
        }
    }

    @Override
    public boolean matches(CharSequence rawPassword, String encodedPassword) {
        if (encodedPassword != null && encodedPassword.length() != 0) {
            return encode(rawPassword).equals(encodedPassword);
        } else {
            this.logger.warn("Empty encoded password");
            return false;
        }
    }
}

