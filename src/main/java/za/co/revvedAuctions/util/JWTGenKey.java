package za.co.revvedAuctions.util;

import java.util.Base64;
import java.security.SecureRandom;

public class JWTGenKey {
    public static void main(String[] args) {
        SecureRandom random = new SecureRandom();
        byte[] key = new byte[32];
        random.nextBytes(key);
        System.out.println(Base64.getEncoder().encodeToString(key));
    }
}

