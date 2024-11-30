package com.peanut.Equipment.domain.vo;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
@Schema(description = "装备VO - EquipmentVO")
public class EquipmentVO extends BaseVO {
	/**
	 * 装备名
	 */
	@Schema(description = "装备名")
	private String name;

	/**
	 * 装备头像
	 */
	@Schema(description = "装备头像")
	private Long imgFileId;
}

