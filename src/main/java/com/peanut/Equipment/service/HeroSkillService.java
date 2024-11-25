package com.peanut.Equipment.service;

import com.peanut.Equipment.domain.dto.HeroSkillPageDTO;
import com.peanut.Equipment.domain.entity.HeroSkill;
import com.baomidou.mybatisplus.extension.service.IService;
import com.peanut.Equipment.domain.vo.BasePageVO;
import com.peanut.Equipment.domain.vo.HeroSkillPageVO;

/**
* @author 86139
* @description 针对表【lol_hero_skill(英雄技能表)】的数据库操作Service
* @createDate 2024-11-10 15:16:09
*/
public interface HeroSkillService extends IService<HeroSkill> {
	/*
	* 英雄技能分页
	* */
	BasePageVO<HeroSkillPageVO> bizPage(HeroSkillPageDTO heroSkillPageDTO);
}
