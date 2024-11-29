package com.peanut.Equipment.service.impl;

import cn.hutool.core.bean.BeanUtil;
import cn.hutool.core.util.StrUtil;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.peanut.Equipment.domain.dto.EquipmentRecommendPageDTO;
import com.peanut.Equipment.domain.entity.EquipmentRecommend;
import com.peanut.Equipment.domain.vo.BasePageVO;
import com.peanut.Equipment.domain.vo.EquipmentRecommendPageVO;
import com.peanut.Equipment.domain.vo.EquipmentRecommendRecordVO;
import com.peanut.Equipment.service.EquipmentRecommendService;
import com.peanut.Equipment.mapper.EquipmentRecommendMapper;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

/**
* @author 86139
* @description 针对表【lol_equipment_recommend(出装推荐表)】的数据库操作Service实现
* @createDate 2024-11-10 15:16:09
*/
@Service
public class EquipmentRecommendServiceImpl extends ServiceImpl<EquipmentRecommendMapper, EquipmentRecommend>
    implements EquipmentRecommendService {

	@Resource
	private EquipmentRecommendMapper equipmentRecommendMapper;

	@Override
	public BasePageVO<EquipmentRecommendPageVO> bizPage(EquipmentRecommendPageDTO equipmentRecommendPageDTO) {
		BasePageVO<EquipmentRecommendPageVO> basePageVO = new BasePageVO<>();
		basePageVO.setPageSize(equipmentRecommendPageDTO.getPageSize());
		basePageVO.setPageNo(equipmentRecommendPageDTO.getPageNo());
		Long count = equipmentRecommendMapper.count(equipmentRecommendPageDTO);
		basePageVO.setTotal(count);
		int offset = (int) ((equipmentRecommendPageDTO.getPageNo() - 1) * equipmentRecommendPageDTO.getPageSize());
		basePageVO.setRecords(equipmentRecommendMapper.page(equipmentRecommendPageDTO, offset));
		return basePageVO;
//		Page<EquipmentRecommend> pageQuery = new Page<>();
//		pageQuery.setSize(equipmentRecommendPageDTO.getPageSize());
//		pageQuery.setCurrent(equipmentRecommendPageDTO.getPageNo());
//
//		Page<EquipmentRecommend> page = this.lambdaQuery()
//				.eq(equipmentRecommendPageDTO.getStage() != null,EquipmentRecommend::getStage, equipmentRecommendPageDTO.getStage())
//				.eq(equipmentRecommendPageDTO.getRecommendType() != null, EquipmentRecommend::getRecommendType, equipmentRecommendPageDTO.getRecommendType())
//				.page(pageQuery);
//
//		return BasePageVO.convert(page, (e) -> {
//			EquipmentRecommendPageVO equipmentRecommendPageVO = new EquipmentRecommendPageVO();
//			BeanUtil.copyProperties(e, equipmentRecommendPageVO);
//			return equipmentRecommendPageVO;
//		});
	}

	@Override
	public EquipmentRecommendRecordVO findById(Long id) {
		return equipmentRecommendMapper.findById(id);
	}
}




