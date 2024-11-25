package com.peanut.Equipment.service.impl;

import cn.hutool.core.util.StrUtil;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.peanut.Equipment.common.JWTUtil;
import com.peanut.Equipment.constant.RedisConstant;
import com.peanut.Equipment.domain.dto.LoginDTO;
import com.peanut.Equipment.domain.entity.User;
import com.peanut.Equipment.domain.vo.CaptchaVo;
import com.peanut.Equipment.enums.BizCodeEnum;
import com.peanut.Equipment.exception.BizException;
import com.peanut.Equipment.mapper.UserMapper;
import com.peanut.Equipment.service.UserService;
import com.wf.captcha.SpecCaptcha;
import com.wf.captcha.base.Captcha;
import jakarta.annotation.Resource;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;

import java.util.UUID;
import java.util.concurrent.TimeUnit;

@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {
	@Resource
	private StringRedisTemplate stringRedisTemplate;

	@Override
	public CaptchaVo captcha() {
		SpecCaptcha specCaptcha = new SpecCaptcha(130, 48, 4);
		specCaptcha.setCharType(Captcha.TYPE_DEFAULT);

		String code = specCaptcha.text().toLowerCase();
		String data = specCaptcha.toBase64();
		String key = RedisConstant.LOGIN_PREFIX + UUID.randomUUID();

		stringRedisTemplate.opsForValue().set(key, code, RedisConstant.LOGIN_CAPTCHA_TTL_SEC, TimeUnit.SECONDS);

		CaptchaVo captchaVo = new CaptchaVo();
		captchaVo.setData(data);
		captchaVo.setKey(key);
		return captchaVo;
	}

	@Override
	public String login(LoginDTO loginDTO) {
		verify(loginDTO);

		LambdaQueryWrapper<User> lambdaQueryWrapper = new LambdaQueryWrapper<>();
		lambdaQueryWrapper
				.eq(User::getUsername, loginDTO.getUsername())
				.eq(User::getPassword, loginDTO.getPassword());
		User user = this.getOne(lambdaQueryWrapper);
		if (user == null) {
			throw BizException.of(BizCodeEnum.BAD_REQUEST, "密码或用户名错误");
		}

		return JWTUtil.createToken(user);
	}

	@Override
	public String register(LoginDTO loginDTO) {
		verify(loginDTO);

		LambdaQueryWrapper<User> lambdaQueryWrapper = new LambdaQueryWrapper<>();
		lambdaQueryWrapper
				.eq(User::getUsername, loginDTO.getUsername());
		User user = this.getOne(lambdaQueryWrapper);

		if (user != null) {
			throw BizException.of(BizCodeEnum.BAD_REQUEST, "用户已存在");
		}

		User userDTO = new User();
		userDTO.setPassword(loginDTO.getPassword());
		userDTO.setUsername(loginDTO.getUsername());

		boolean result = this.save(userDTO);
		if (!result) {
			throw BizException.of(BizCodeEnum.UNKNOWN_ERROR, "注册失败");
		}

		return JWTUtil.createToken(userDTO);
	}

	private void verify(LoginDTO loginDTO) {
		String code = stringRedisTemplate.opsForValue().get(loginDTO.getKey());
		if (code == null) {
			throw BizException.of(BizCodeEnum.BAD_REQUEST,"验证码已过期");
		}

		if (!StrUtil.equals(code, loginDTO.getCode().toLowerCase())) {
			throw BizException.of(BizCodeEnum.BAD_REQUEST, "验证码错误");
		}
	}
}
