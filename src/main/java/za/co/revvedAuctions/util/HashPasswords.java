package za.co.revvedAuctions.util;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class HashPasswords {
    public static void main(String[] args) {
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        String rawPassword = "test1234";
        String encodedPassword = encoder.encode(rawPassword);
        System.out.println(encodedPassword);
    }
}
