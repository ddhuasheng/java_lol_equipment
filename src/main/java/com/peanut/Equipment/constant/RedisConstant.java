package com.peanut.Equipment.constant;

import lombok.Getter;

@Getter
public class RedisConstant {
	public static final String LOGIN_PREFIX = "lol:login:";
	public static final Integer LOGIN_CAPTCHA_TTL_SEC = 60;
}
