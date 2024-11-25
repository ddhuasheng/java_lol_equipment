package com.peanut.Equipment.controller;

import cn.hutool.core.bean.BeanUtil;
import com.peanut.Equipment.domain.dto.HeroSkillDTO;
import com.peanut.Equipment.domain.dto.HeroSkillPageDTO;
import com.peanut.Equipment.domain.entity.HeroSkill;
import com.peanut.Equipment.domain.vo.*;
import com.peanut.Equipment.service.HeroSkillService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.annotation.Resource;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/v1/hero/skill")
@Tag(name = "英雄技能信息管理")
public class heroSkillController {
	@Resource
	private HeroSkillService heroSkillService;

	@Operation(summary = "英雄技能分页")
	@GetMapping("/page")
	public ResultVO<BasePageVO<HeroSkillPageVO>> page(HeroSkillPageDTO heroSkillPageDTO) {
		BasePageVO<HeroSkillPageVO> page = heroSkillService.bizPage(heroSkillPageDTO);
		return ResultVO.success(page);
	}

	@Operation(summary = "添加英雄技能")
	@PostMapping
	public ResultVO<Boolean> create(@Valid @RequestBody HeroSkillDTO heroSkillDTO) {
		boolean result = heroSkillService.save(heroSkillDTO);
		return ResultVO.success(result);
	}

	@Operation(summary = "更新英雄技能")
	@PutMapping
	public ResultVO<Boolean> update(@Valid @RequestBody HeroSkillDTO heroSkillDTO) {
		boolean result = heroSkillService.updateById(heroSkillDTO);
		return ResultVO.success(result);
	}

	@Operation(summary = "删除英雄技能")
	@DeleteMapping
	public ResultVO<Boolean> remove(@RequestBody List<Long> ids) {
		boolean result = heroSkillService.removeBatchByIds(ids);
		return ResultVO.success(result);
	}

	@Operation(summary = "根据id查询英雄技能")
	@GetMapping("/{id}")
	public ResultVO<HeroSkillVO> find(@PathVariable Long id) {
		HeroSkill heroSkill = heroSkillService.getById(id);
		HeroSkillVO heroSkillVO = new HeroSkillVO();

		BeanUtil.copyProperties(heroSkill, heroSkillVO);
		return ResultVO.success(heroSkillVO);
	}
}
