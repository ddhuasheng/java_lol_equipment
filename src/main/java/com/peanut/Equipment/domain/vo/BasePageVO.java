package com.peanut.Equipment.domain.vo;

import lombok.Data;

import java.io.Serializable;

@Data
public class BasePageVO<T> implements Serializable {
	private Long pageSize = 10L;
	private Long pageNo = 1L;
	private T data;
	private Long total;
}
