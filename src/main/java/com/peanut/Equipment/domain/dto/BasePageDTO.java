package com.peanut.Equipment.domain.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.io.Serializable;

@Data
@Schema(description = "基础分页DTO - BasePageDTO")
public class BasePageDTO implements Serializable {
	@Schema(description = "页面大小")
	private Long pageSize = 10L;
	@Schema(description = "页码")
	private Long pageNo = 1L;
}
