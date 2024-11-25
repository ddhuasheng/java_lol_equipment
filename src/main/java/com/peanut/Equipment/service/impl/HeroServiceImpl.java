package com.peanut.Equipment.service.impl;

import cn.hutool.core.util.StrUtil;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.peanut.Equipment.domain.dto.HeroPageDTO;
import com.peanut.Equipment.domain.entity.Hero;
import com.peanut.Equipment.domain.vo.BasePageVO;
import com.peanut.Equipment.domain.vo.HeroPageVO;
import com.peanut.Equipment.service.HeroService;
import com.peanut.Equipment.mapper.HeroMapper;
import org.springframework.stereotype.Service;

/**
* @author 86139
* @description 针对表【lol_hero(英雄表)】的数据库操作Service实现
* @createDate 2024-11-10 15:16:09
*/
@Service
public class HeroServiceImpl extends ServiceImpl<HeroMapper, Hero>
    implements HeroService {

	@Override
	public BasePageVO<HeroPageVO> bizPage(HeroPageDTO heroPageDTO) {
		Page<Hero> pageQuery = new Page<>();
		pageQuery.setCurrent(heroPageDTO.getPageNo());
		pageQuery.setSize(heroPageDTO.getPageSize());

		Page<Hero> page = this.lambdaQuery()
				.like(StrUtil.isNotBlank(heroPageDTO.getName()), Hero::getName, heroPageDTO.getName())
				.page(pageQuery);

		return BasePageVO.convert(page, (e) -> {
			HeroPageVO heroPageVO = new HeroPageVO();
			heroPageVO.setName(e.getName());
			heroPageVO.setImgFileId(e.getImgFileId());
			heroPageVO.setVersion(e.getVersion());
			heroPageVO.setCreateTime(e.getCreateTime());
			heroPageVO.setUpdateTime(e.getUpdateTime());
			heroPageVO.setId(e.getId());
			return heroPageVO;
		});
	}
}




