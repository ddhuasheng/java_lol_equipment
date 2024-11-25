package com.peanut.Equipment.service;

import com.peanut.Equipment.domain.dto.HeroPageDTO;
import com.peanut.Equipment.domain.entity.Hero;
import com.baomidou.mybatisplus.extension.service.IService;
import com.peanut.Equipment.domain.vo.BasePageVO;
import com.peanut.Equipment.domain.vo.HeroPageVO;

/**
* @author 86139
* @description 针对表【lol_hero(英雄表)】的数据库操作Service
* @createDate 2024-11-10 15:16:09
*/
public interface HeroService extends IService<Hero> {
	/*
	* 英雄分页
	* */
	BasePageVO<HeroPageVO> bizPage(HeroPageDTO heroPageDTO);
}
