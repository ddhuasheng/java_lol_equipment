package com.peanut.Equipment.service;

import com.peanut.Equipment.domain.dto.EquipmentRecommendPageDTO;
import com.peanut.Equipment.domain.entity.EquipmentRecommend;
import com.baomidou.mybatisplus.extension.service.IService;
import com.peanut.Equipment.domain.vo.BasePageVO;
import com.peanut.Equipment.domain.vo.EquipmentRecommendPageVO;
import com.peanut.Equipment.domain.vo.EquipmentRecommendRecordVO;

/**
* @author 86139
* @description 针对表【lol_equipment_recommend(出装推荐表)】的数据库操作Service
* @createDate 2024-11-10 15:16:09
*/
public interface EquipmentRecommendService extends IService<EquipmentRecommend> {

	/*
	* 推荐装备分页
	* */
	BasePageVO<EquipmentRecommendPageVO> bizPage(EquipmentRecommendPageDTO equipmentRecommendPageDTO);

	/*
	* 根据id查询装备分页
	* */
	EquipmentRecommendRecordVO findById(Long id);
}
