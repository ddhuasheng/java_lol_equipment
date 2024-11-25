package com.peanut.Equipment.controller;

import cn.hutool.core.bean.BeanUtil;
import com.peanut.Equipment.domain.dto.HeroDTO;
import com.peanut.Equipment.domain.dto.HeroPageDTO;
import com.peanut.Equipment.domain.entity.Hero;
import com.peanut.Equipment.domain.vo.*;
import com.peanut.Equipment.service.HeroService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.annotation.Resource;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/v1/hero")
@Tag(name = "英雄信息管理")
public class heroController {
	@Resource
	private HeroService heroService;

	@Operation(summary = "英雄分页")
	@GetMapping("/page")
	public ResultVO<BasePageVO<HeroPageVO>> page(HeroPageDTO heroPageDTO) {
		BasePageVO<HeroPageVO> page = heroService.bizPage(heroPageDTO);
		return ResultVO.success(page);
	}

	@Operation(summary = "添加英雄")
	@PostMapping
	public ResultVO<Boolean> create(@Valid @RequestBody HeroDTO heroDTO) {
		boolean result = heroService.save(heroDTO);
		return ResultVO.success(result);
	}

	@Operation(summary = "更新英雄")
	@PutMapping
	public ResultVO<Boolean> update(@Valid @RequestBody HeroDTO heroDTO) {
		boolean result = heroService.updateById(heroDTO);
		return ResultVO.success(result);
	}

	@Operation(summary = "删除英雄")
	@DeleteMapping
	public ResultVO<Boolean> remove(@RequestBody List<Long> ids) {
		boolean result = heroService.removeBatchByIds(ids);
		return ResultVO.success(result);
	}

	@Operation(summary = "根据id查询英雄")
	@GetMapping("/{id}")
	public ResultVO<HeroVO> find(@PathVariable Long id) {
		Hero hero = heroService.getById(id);
		HeroVO heroVO = new HeroVO();

		BeanUtil.copyProperties(hero, heroVO);
		return ResultVO.success(heroVO);
	}
}
