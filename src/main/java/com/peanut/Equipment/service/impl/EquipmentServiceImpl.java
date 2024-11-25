package com.peanut.Equipment.service.impl;

import cn.hutool.core.bean.BeanUtil;
import cn.hutool.core.util.StrUtil;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.peanut.Equipment.domain.dto.EquipmentPageDTO;
import com.peanut.Equipment.domain.entity.Equipment;
import com.peanut.Equipment.domain.vo.BasePageVO;
import com.peanut.Equipment.domain.vo.EquipmentPageVO;
import com.peanut.Equipment.service.EquipmentService;
import com.peanut.Equipment.mapper.EquipmentMapper;
import org.springframework.stereotype.Service;

/**
* @author 86139
* @description 针对表【lol_equipment(装备表)】的数据库操作Service实现
* @createDate 2024-11-10 15:16:09
*/
@Service
public class EquipmentServiceImpl extends ServiceImpl<EquipmentMapper, Equipment>
    implements EquipmentService {

	@Override
	public BasePageVO<EquipmentPageVO> bizPage(EquipmentPageDTO equipmentPageDTO) {
		Page<Equipment> pageQuery = new Page<>();
		pageQuery.setSize(equipmentPageDTO.getPageSize());
		pageQuery.setCurrent(equipmentPageDTO.getPageNo());
		Page<Equipment> page = this.lambdaQuery()
				.like(StrUtil.isNotBlank(equipmentPageDTO.getName()), Equipment::getName, equipmentPageDTO.getName())
				.page(pageQuery);

		return BasePageVO.convert(page, (e) -> {
			EquipmentPageVO equipmentPageVO = new EquipmentPageVO();
			BeanUtil.copyProperties(e, equipmentPageVO);
			return equipmentPageVO;
		});
	}
}




