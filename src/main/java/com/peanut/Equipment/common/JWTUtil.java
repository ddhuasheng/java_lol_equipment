package com.peanut.Equipment.common;

import com.peanut.Equipment.domain.entity.User;
import com.peanut.Equipment.enums.BizCodeEnum;
import com.peanut.Equipment.exception.BizException;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.JwtException;
import io.jsonwebtoken.JwtParser;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;
import lombok.extern.slf4j.Slf4j;

import java.security.Key;
import java.util.Date;
/*
* 鉴权
* */
@Slf4j
public class JWTUtil {
	private static final long tokenExpiration = 60 * 60 * 1000L;
	private static final Key tokenSignKey = Keys.hmacShaKeyFor("coUV9oVaK2f6wugU6y5BhJVB3MPHIi9A".getBytes());

	/**
	 * 生成token
	 * @param user 用户信息
	 * @return String
	 * */
	public static String createToken(User user) {
		return Jwts.builder()
				.setSubject("USER_INFO")
				.setExpiration(new Date(System.currentTimeMillis() + tokenExpiration))
				.claim("username", user.getUsername())
				.claim("userId", user.getId())
				.signWith(tokenSignKey)
				.compact();
	}

	/**
	 * 解析token
	 * @param token token
	 * */
	public static Claims parseToken(String token) {
		if (token == null) {
			return null;
		}

		try {
			JwtParser build = Jwts.parserBuilder().setSigningKey(tokenSignKey).build();
			return build.parseClaimsJws(token).getBody();
		} catch (JwtException e) {
			log.error("JWT Exception: {}", e.getMessage());
			throw BizException.of(BizCodeEnum.UNKNOWN_ERROR, "JWT Exception: %s", e.getMessage());
		}
	}
}
