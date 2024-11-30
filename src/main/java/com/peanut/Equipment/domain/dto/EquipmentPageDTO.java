package com.peanut.Equipment.domain.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
@Schema(description = "装备信息DTO - EquipmentPageDTO")
public class EquipmentPageDTO extends BasePageDTO {
	/**
	 * 装备名称
	 */
	@Schema(description = "装备名称")
	private String name;
}
