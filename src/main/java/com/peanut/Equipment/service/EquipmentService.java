package com.peanut.Equipment.service;

import com.peanut.Equipment.domain.dto.EquipmentPageDTO;
import com.peanut.Equipment.domain.entity.Equipment;
import com.baomidou.mybatisplus.extension.service.IService;
import com.peanut.Equipment.domain.vo.BasePageVO;
import com.peanut.Equipment.domain.vo.EquipmentPageVO;

/**
* @author 86139
* @description 针对表【lol_equipment(装备表)】的数据库操作Service
* @createDate 2024-11-10 15:16:09
*/
public interface EquipmentService extends IService<Equipment> {
	/*
	* 分页
	* */
	BasePageVO<EquipmentPageVO> bizPage(EquipmentPageDTO equipmentPageDTO);
}
