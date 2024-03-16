package io.github.sztuwebclub.webvoyager.constant.utils;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;

import javax.crypto.SecretKey;
import java.util.Date;
import java.util.Map;

public class JwtUtil {
    // TODO: Use asymmetric key
    private static final SecretKey KEY = Jwts.SIG.HS256.key().build();

    // TODO: Type-safe claims
    public static String createJWT(String secretKey, long ttlMillis, Map<String, Object> claims) {

        long expMillis = System.currentTimeMillis() + ttlMillis;
        Date exp = new Date(expMillis);

        // 设置jwt的body
        var builder = Jwts.builder()
                .claims(claims)
                .expiration(exp)
                .signWith(KEY);

        return builder.compact();
    }

    public static Claims parseJWT(String secretKey, String token) {
        return Jwts.parser()
                .verifyWith(KEY)
                .build()
                .parseSignedClaims(token).getPayload();
    }

}
