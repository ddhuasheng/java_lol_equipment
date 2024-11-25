package com.peanut.Equipment.service;


import com.baomidou.mybatisplus.extension.service.IService;
import com.peanut.Equipment.domain.dto.LoginDTO;
import com.peanut.Equipment.domain.entity.User;
import com.peanut.Equipment.domain.vo.CaptchaVo;

public interface UserService extends IService<User> {
	/*
	* 获取验证码
	* */
	CaptchaVo captcha();

	/*
	* 登录
	* */
	String login(LoginDTO loginDTO);

	/*
	* 注册
	* */
	String register(LoginDTO loginDTO);
}
