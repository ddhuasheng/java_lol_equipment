package com.peanut.Equipment.config;

import com.peanut.Equipment.common.JWTUtil;
import com.peanut.Equipment.common.LoginUserHolder;
import com.peanut.Equipment.domain.entity.User;
import io.jsonwebtoken.Claims;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.jetbrains.annotations.NotNull;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

@Component
public class AuthenticationInterceptor implements HandlerInterceptor {

		@Override
		public boolean preHandle(@NotNull final HttpServletRequest request, @NotNull final HttpServletResponse response, @NotNull final Object handler) {
			String token = request.getHeader("Authorization");

			if (token == null) {
				return false;
			}

			Claims claims = JWTUtil.parseToken(token);
			Long userId = claims.get("userId", Long.class);
			String username = claims.get("username", String.class);

			User user = new User();
			user.setUsername(username);
			user.setId(userId);

			LoginUserHolder.setLoginUser(user);

			return true;
		}

	@Override
	public void afterCompletion(@NotNull HttpServletRequest request, @NotNull HttpServletResponse response, @NotNull Object handler, Exception ex) throws Exception {
			LoginUserHolder.clear();
	}
}
