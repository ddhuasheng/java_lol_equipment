package com.peanut.Equipment.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.peanut.Equipment.domain.entity.Hero;
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

}




