package org.example.np.util;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;

import java.util.Date;

public class JwtUtil {

    private static final String SECRET = "javax.crypto.spec.SecretKeySpec@58824b0";

    public static String genarateToken(String email) {
       return Jwts.builder()
                .setSubject(email)
                .issuedAt(new Date())
                .expiration(new Date(System.currentTimeMillis() + 24 * 60 * 1000)).
                signWith(Keys.hmacShaKeyFor(SECRET.getBytes()))
                .compact();

    }
}
