package com.peanut.Equipment.common;

import com.peanut.Equipment.domain.entity.User;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;

import java.security.Key;
import java.util.Date;

public class JWTUtil {
	private static final long tokenExpiration = 60 * 60 * 1000L;
	private static final Key tokenSignKey = Keys.hmacShaKeyFor("coUV9oVaK2f6wugU6y5BhJVB3MPHIi9A".getBytes());

	public static String createToken(User user) {
		return Jwts.builder()
				.setSubject("USER_INFO")
				.setExpiration(new Date(System.currentTimeMillis() + tokenExpiration))
				.claim("username", user.getUsername())
				.claim("userId", user.getId())
				.signWith(tokenSignKey)
				.compact();
	}
}
