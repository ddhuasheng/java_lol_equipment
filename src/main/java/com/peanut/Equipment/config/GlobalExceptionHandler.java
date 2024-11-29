package com.peanut.Equipment.config;

import com.peanut.Equipment.domain.vo.ResultVO;
import com.peanut.Equipment.enums.BizCodeEnum;
import com.peanut.Equipment.exception.BizException;
import jakarta.servlet.http.HttpServletRequest;
import lombok.extern.slf4j.Slf4j;
import org.springframework.validation.BindException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.NoHandlerFoundException;

@Slf4j
@ControllerAdvice
@ResponseBody
public class GlobalExceptionHandler {
	/*
	* 业务异常
	* */
	@ExceptionHandler(BizException.class)
	public ResultVO<String> BizExceptionHandler(BizException e) {
		log.error(e.getMessage());
		return ResultVO.fail(e.getCode(), e.getMessage());
	}

	/**
	 * 处理404异常
	 */
	@ExceptionHandler(NoHandlerFoundException.class)
	public ResultVO<String> noHandlerFoundException(HttpServletRequest req, Exception e) {
		log.error("404异常 NoHandlerFoundException, method = {}, path = {} ", req.getMethod(), req.getServletPath(), e);
		return ResultVO.fail(BizCodeEnum.NOT_FOUND);
	}

	/*
	* 处理校验错误
	* */
	@ExceptionHandler(BindException.class)
	public ResultVO<String> bindExceptionHandler(BindException e) {
		String defaultMessage = e.getBindingResult().getAllErrors().stream().findFirst().get().getDefaultMessage();
		log.error(e.getMessage());
		return ResultVO.fail(BizCodeEnum.BAD_REQUEST, defaultMessage);
	}

	/*
	* 处理未知异常
	* */
//	@ExceptionHandler(value = Exception.class)
//	public ResultVO<String> exceptionHandler(Exception e) {
//		log.error(e.getMessage());
//		return ResultVO.fail(BizCodeEnum.UNKNOWN_ERROR , e.getMessage());
//	}
}
