package com.example.backend.utils;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jws;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.security.Key;
import java.util.*;

@Component
public class JwtUtils {

    @Value("${jwt.secret}")
    private String secret;

    @Value("${jwt.expirationMs}")
    private long expirationMs;

    public String generateJwtToken(String email) {
        Date expirationDate = new Date(System.currentTimeMillis() + expirationMs);

        Map<String, Object> claims = new HashMap<>();
        claims.put("sub", email); // Subject (typically user's email)
        claims.put("exp", expirationDate);
        List<String> roles = new ArrayList<>();
        claims.put("roles", roles);

        return Jwts.builder()
                .setClaims(claims)
                .signWith(SignatureAlgorithm.HS256, secret)
                .compact();
    }

    public Claims getClaimsFromJwtToken(String token) {
        return Jwts.parser()
                .setSigningKey(secret)
                .parseClaimsJws(token)
                .getBody();
    }

    public boolean validateToken(String token) {
        try {
            Key key = Keys.hmacShaKeyFor(secret.getBytes()); // Convert the secret key to a Key object
            Jws<Claims> claimsJws = Jwts.parserBuilder()
                    .setSigningKey(key)
                    .build()
                    .parseClaimsJws(token);

            // No exception means the token is valid
            return true;
        } catch (Exception e) {
            // An exception occurred, token is invalid
            return false;
        }
    }
}
