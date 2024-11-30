package com.peanut.Equipment.domain.vo;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
@Schema(description = "英雄VO - HeroVO")
public class HeroVO extends BaseVO {
	/**
	 * 英雄名
	 */
	@Schema(description = "英雄名")
	private String name;

	/**
	 * 英雄头像
	 */
	@Schema(description = "英雄头像")
	private Long imgFileId;
}
