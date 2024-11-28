package com.peanut.Equipment.enums;

import com.baomidou.mybatisplus.annotation.EnumValue;
import lombok.AllArgsConstructor;
import lombok.Getter;
/*
* 推荐出装类型枚举
* */
@Getter
@AllArgsConstructor
public enum RecommendTypeEnum {
	TAILWIND(1, "顺风出装"),
	DEADWIND(2, "逆风出装");

	@EnumValue
	private final Integer code;
	private final String desc;
}
