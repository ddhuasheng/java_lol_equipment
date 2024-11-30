package com.peanut.Equipment.domain.vo;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
@Schema(description = "装备推荐记录VO - EquipmentRecommendRecordVO")
public class EquipmentRecommendRecordVO extends EquipmentRecommendVO {
	/*
	 * 英雄名称
	 * */
	@Schema(description = "英雄名称")
	private String heroName;

	/*
	 * 装备名称
	 * */
	@Schema(description = "装备名称")
	private String equipmentName;
}
