package com.peanut.Equipment.enums;

import com.baomidou.mybatisplus.annotation.EnumValue;
import lombok.Getter;

/**
 * 出装顺序枚举
 */
@Getter
public enum StageEnum {
	GO_OUT(1, "出门装"),
	CORE(2, "核心装"),
	DEITY(3, "神装");

	@EnumValue
	private final Integer code;
	private final String desc;

	StageEnum(Integer code, String desc) {
		this.code = code;
		this.desc = desc;
	}
}
