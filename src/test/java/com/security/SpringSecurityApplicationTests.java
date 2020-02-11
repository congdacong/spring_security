package com.security;

import org.springframework.security.crypto.bcrypt.BCrypt;

class SpringSecurityApplicationTests {
    public static void main(String[] args) {
        String hashpw = BCrypt.hashpw("000000", BCrypt.gensalt());
        System.out.println(hashpw);
    }


}
