package com.example.demo.security;

import com.example.demo.entity.User;
import io.jsonwebtoken.*;
import java.util.*;

public class JwtUtil {

    private final String SECRET = "secretkey123456";

    public String generateTokenForUser(User user) {
        Map<String, Object> claims = new HashMap<>();
        claims.put("userId", user.getId());
        claims.put("email", user.getEmail());
        claims.put("role", user.getRole());

        return Jwts.builder()
                .setClaims(claims)
                .setSubject(user.getEmail())
                .signWith(SignatureAlgorithm.HS256, SECRET)
                .compact();
    }

    public Claims parseToken(String token) {
        return Jwts.parser().setSigningKey(SECRET)
                .parseClaimsJws(token).getBody();
    }

    public String extractUsername(String token) {
        return parseToken(token).getSubject();
    }

    public String extractRole(String token) {
        return parseToken(token).get("role", String.class);
    }

    public Long extractUserId(String token) {
        return parseToken(token).get("userId", Long.class);
    }

    public boolean isTokenValid(String token, String username) {
        return extractUsername(token).equals(username);
    }
}
