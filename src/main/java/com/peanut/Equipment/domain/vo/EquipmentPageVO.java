package com.peanut.Equipment.domain.vo;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
@Schema(description = "装备信息VO - EquipmentPageVO")
public class EquipmentPageVO extends BaseVO {
	/**
	 * 装备名称
	 */
	@Schema(description = "装备名称")
	private String name;

	/**
	 * 图标id
	 */
	@Schema(description = "图标id")
	private Long imgFileId;
}
