package com.peanut.Equipment.domain.vo;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;


@Schema(description = "英雄分页VO - HeroPageVO")
@Data
public class HeroPageVO extends BaseVO {
	/*
	* 英雄名
	* */
	@Schema(description = "英雄名")
  private String name;
	/*
	 * 英雄头像
	 * */
	@Schema(description = "英雄头像")
	private Long imgFileId;
}
