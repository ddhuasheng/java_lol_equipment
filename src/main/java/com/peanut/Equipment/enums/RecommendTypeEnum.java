package com.peanut.Equipment.enums;

import com.baomidou.mybatisplus.annotation.EnumValue;
import lombok.Getter;
/*
* 推荐出装类型枚举
* */
@Getter
public enum RecommendTypeEnum {
	TAILWIND(1, "顺风出装"),
	DEADWIND(2, "逆风出装");

	@EnumValue
	private final Integer code;
	private final String desc;

	RecommendTypeEnum(Integer code, String desc) {
		this.desc = desc;
		this.code = code;
	}

}
