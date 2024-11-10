package com.peanut.Equipment.mapper;

import com.peanut.Equipment.domain.entity.Hero;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
* @author 86139
* @description 针对表【lol_hero(英雄表)】的数据库操作Mapper
* @createDate 2024-11-10 15:16:09
* @Entity generator.domain.Hero
*/
@Mapper
public interface HeroMapper extends BaseMapper<Hero> {

}




