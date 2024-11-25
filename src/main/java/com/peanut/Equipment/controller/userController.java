package com.peanut.Equipment.controller;

import com.peanut.Equipment.domain.dto.LoginDTO;
import com.peanut.Equipment.domain.vo.CaptchaVo;
import com.peanut.Equipment.domain.vo.ResultVO;
import com.peanut.Equipment.service.UserService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.annotation.Resource;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/v1/user")
@Tag(name = "用户信息管理")
public class userController {
	@Resource
	private UserService userService;

	@GetMapping("/captcha")
	@Operation(summary = "获取验证码")
	public ResultVO<CaptchaVo> captcha() {
		CaptchaVo captchaVo = userService.captcha();
		return ResultVO.success(captchaVo);
	}

	@PostMapping("/login")
	@Operation(summary = "登录")
	public ResultVO<String> login(@Valid @RequestBody LoginDTO loginDTO) {
	  String token = userService.login(loginDTO);
		return ResultVO.success(token);
	}

	@PostMapping("/register")
	@Operation(summary = "注册")
	public ResultVO<String> register(@Valid @RequestBody LoginDTO loginDTO) {
		String token = userService.register(loginDTO);
		return ResultVO.success(token);
	}
}
