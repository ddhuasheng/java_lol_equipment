package com.peanut.Equipment.controller;

import cn.hutool.core.bean.BeanUtil;
import com.peanut.Equipment.domain.dto.EquipmentDTO;
import com.peanut.Equipment.domain.dto.EquipmentPageDTO;
import com.peanut.Equipment.domain.entity.Equipment;
import com.peanut.Equipment.domain.entity.Hero;
import com.peanut.Equipment.domain.vo.*;
import com.peanut.Equipment.service.EquipmentService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.annotation.Resource;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/v1/equipment")
@Tag(name = "装备信息管理")
public class equipmentController {
	@Resource
	private EquipmentService equipmentService;

	@GetMapping("/page")
	@Operation(summary = "装备信息分页")
	public ResultVO<BasePageVO<EquipmentPageVO>> page(EquipmentPageDTO equipmentPageDTO) {
		BasePageVO<EquipmentPageVO> page = equipmentService.bizPage(equipmentPageDTO);
		return ResultVO.success(page);
	}

	@PostMapping
	@Operation(summary = "新增装备信息")
	public ResultVO<Boolean> create(@Valid @RequestBody EquipmentDTO equipmentDTO) {
		boolean result = equipmentService.save(equipmentDTO);
		return ResultVO.success(result);
	}

	@PutMapping
	@Operation(summary = "更新装备信息")
	public ResultVO<Boolean> update(@Valid @RequestBody EquipmentDTO equipmentDTO) {
		boolean result = equipmentService.updateById(equipmentDTO);
		return ResultVO.success(result);
	}


	@Operation(summary = "删除装备")
	@DeleteMapping
	public ResultVO<Boolean> remove(@RequestBody List<Long> ids) {
		boolean result = equipmentService.removeBatchByIds(ids);
		return ResultVO.success(result);
	}

	@Operation(summary = "根据id查询装备")
	@GetMapping("/{id}")
	public ResultVO<EquipmentVO> find(@PathVariable Long id) {
		Equipment equipment = equipmentService.getById(id);
		EquipmentVO equipmentVO = new EquipmentVO();

		BeanUtil.copyProperties(equipment, equipmentVO);
		return ResultVO.success(equipmentVO);
	}
}
