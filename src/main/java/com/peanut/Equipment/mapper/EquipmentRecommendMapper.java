package com.peanut.Equipment.mapper;

import com.peanut.Equipment.domain.dto.EquipmentRecommendPageDTO;
import com.peanut.Equipment.domain.entity.EquipmentRecommend;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.peanut.Equipment.domain.vo.EquipmentRecommendPageVO;
import com.peanut.Equipment.domain.vo.EquipmentRecommendRecordVO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
* @author 86139
* @description 针对表【lol_equipment_recommend(出装推荐表)】的数据库操作Mapper
* @createDate 2024-11-10 15:16:09
* @Entity generator.domain.EquipmentRecommend
*/
@Mapper
public interface EquipmentRecommendMapper extends BaseMapper<EquipmentRecommend> {
	/*
	* 根据id查询
	* */
	EquipmentRecommendRecordVO findById(Long id);

	/*
	* page查询
	* */
	List<EquipmentRecommendPageVO> page(EquipmentRecommendPageDTO dto, int offset);
	/*
	* 统计
	* */
	Long count(EquipmentRecommendPageDTO dto);
}




