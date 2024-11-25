package com.peanut.Equipment.domain.vo;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.io.Serializable;
import java.time.LocalDateTime;

@Data
@Schema(description = "基础VO - BaseVO")
public class BaseVO implements Serializable {
	@Schema(description = "创建时间")
	private LocalDateTime createTime;

	@Schema(description = "版本")
	private Integer version;

	@Schema(description = "id")
	private Long id;

	@Schema(description = "更新时间")
	private LocalDateTime updateTime;
}
