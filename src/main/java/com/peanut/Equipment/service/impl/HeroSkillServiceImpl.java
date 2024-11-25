package com.peanut.Equipment.service.impl;

import cn.hutool.core.bean.BeanUtil;
import cn.hutool.core.util.StrUtil;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.peanut.Equipment.domain.dto.HeroSkillPageDTO;
import com.peanut.Equipment.domain.entity.HeroSkill;
import com.peanut.Equipment.domain.vo.BasePageVO;
import com.peanut.Equipment.domain.vo.HeroSkillPageVO;
import com.peanut.Equipment.service.HeroSkillService;
import com.peanut.Equipment.mapper.HeroSkillMapper;
import org.springframework.stereotype.Service;

/**
* @author 86139
* @description 针对表【lol_hero_skill(英雄技能表)】的数据库操作Service实现
* @createDate 2024-11-10 15:16:09
*/
@Service
public class HeroSkillServiceImpl extends ServiceImpl<HeroSkillMapper, HeroSkill>
    implements HeroSkillService {

	@Override
	public BasePageVO<HeroSkillPageVO> bizPage(HeroSkillPageDTO heroSkillPageDTO) {
		Page<HeroSkill> pageQuery = new Page<>();
		pageQuery.setCurrent(heroSkillPageDTO.getPageNo());
		pageQuery.setSize(heroSkillPageDTO.getPageSize());

		Page<HeroSkill> page = this.lambdaQuery()
				.like(StrUtil.isNotBlank(heroSkillPageDTO.getName()), HeroSkill::getName, heroSkillPageDTO.getName())
				.page(pageQuery);

		return BasePageVO.convert(page, (e) -> {
			HeroSkillPageVO heroSkillPageVO = new HeroSkillPageVO();
			BeanUtil.copyProperties(e, heroSkillPageVO);
			return heroSkillPageVO;
		});
	}
}




