package com.peanut.Equipment.domain.vo;

import cn.hutool.core.collection.CollectionUtil;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.io.Serializable;
import java.util.List;
import java.util.function.Function;

@Data
@Schema(description = "BasePageV0")
public class BasePageVO<T> implements Serializable {
	@Schema(description = "页面大小")
	private Long pageSize = 10L;
	@Schema(description = "页码")
	private Long pageNo = 1L;
	@Schema(description = "分页数据")
	private List<T> records;
	@Schema(description = "总条数")
	private Long total;

	/**
		* vo类型转换
	 	* @param page source 源类型
	 	* @param function 转换函数
	 	* @return T
		* */
	public static <T, E> BasePageVO<T> convert(Page<E> page, Function<E, T> function) {
		List<E> records1 = page.getRecords();
		BasePageVO<T> tBasePageVO = new BasePageVO<>();
		tBasePageVO.setPageNo(page.getCurrent());
		tBasePageVO.setPageSize(page.getSize());
		tBasePageVO.setTotal(page.getTotal());

		if (CollectionUtil.isEmpty(records1)) {
			return tBasePageVO;
		}

		List<T> list = records1.stream().map(function).toList();
		tBasePageVO.setRecords(list);
		return tBasePageVO;
	}
}
