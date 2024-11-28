package com.peanut.Equipment.common;

import com.peanut.Equipment.domain.entity.User;

public class LoginUserHolder {
	public static ThreadLocal<User> threadLocal = new ThreadLocal<>();

	public static void setLoginUser(User User) {
		threadLocal.set(User);
	}

	public static User getLoginUser() {
		return threadLocal.get();
	}

	public static void clear() {
		threadLocal.remove();
	}
}
