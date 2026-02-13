package org.example.np.util;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;

import javax.security.auth.kerberos.KerberosTicket;
import java.sql.SQLOutput;
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
    public static  String genarateRefreshToken(String email){
        return Jwts.builder()
                .subject(email)
                .expiration(new Date(System.currentTimeMillis() + 24*60*60 *1000))
                .signWith(Keys.hmacShaKeyFor(SECRET.getBytes()))
                .compact();


    }

    public static String validateToken(String token){
        return Jwts.parser()
                .verifyWith(Keys.hmacShaKeyFor(SECRET.getBytes()))
                .build()
                .parseSignedClaims(token)
                .getPayload()
                .getSubject(); //email
    }
}
