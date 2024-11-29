package com.peanut.Equipment.controller;

import cn.hutool.core.bean.BeanUtil;
import com.peanut.Equipment.common.LoginUserHolder;
import com.peanut.Equipment.domain.dto.EquipmentDTO;
import com.peanut.Equipment.domain.dto.EquipmentRecommendDTO;
import com.peanut.Equipment.domain.dto.EquipmentRecommendPageDTO;
import com.peanut.Equipment.domain.entity.EquipmentRecommend;
import com.peanut.Equipment.domain.entity.User;
import com.peanut.Equipment.domain.vo.*;
import com.peanut.Equipment.service.EquipmentRecommendService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.annotation.Resource;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/v1/equipment/recommend")
@Tag(name = "装备推荐信息管理")
public class equipmentRecommendController {
	@Resource
	private EquipmentRecommendService equipmentRecommendService;

	@GetMapping("/page")
	@Operation(summary = "装备推荐信息分页")
	public ResultVO<BasePageVO<EquipmentRecommendPageVO>> page(EquipmentRecommendPageDTO equipmentRecommendPageDTO) {
		BasePageVO<EquipmentRecommendPageVO> page = equipmentRecommendService.bizPage(equipmentRecommendPageDTO);
		return ResultVO.success(page);
	}

	@PostMapping
	@Operation(summary = "新增装备推荐信息")
	public ResultVO<Boolean> create(@Valid @RequestBody EquipmentRecommendDTO equipmentRecommendDTO) {
		boolean result = equipmentRecommendService.save(equipmentRecommendDTO);
		return ResultVO.success(result);
	}

	@PutMapping
	@Operation(summary = "更新装备推荐信息")
	public ResultVO<Boolean> update(@Valid @RequestBody EquipmentRecommendDTO equipmentRecommendDTO) {
		boolean result = equipmentRecommendService.updateById(equipmentRecommendDTO);
		return ResultVO.success(result);
	}


	@Operation(summary = "删除装备推荐")
	@DeleteMapping
	public ResultVO<Boolean> remove(@RequestBody List<Long> ids) {
		boolean result = equipmentRecommendService.removeBatchByIds(ids);
		return ResultVO.success(result);
	}

	@Operation(summary = "根据id查询装备推荐")
	@GetMapping("/{id}")
	public ResultVO<EquipmentRecommendRecordVO> find(@PathVariable Long id) {
		EquipmentRecommendRecordVO equipmentRecommend = equipmentRecommendService.findById(id);

		return ResultVO.success(equipmentRecommend);
	}
}
