package com.peanut.Equipment.controller;

import com.peanut.Equipment.service.HeroService;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/hero")
public class heroController {
	@Resource
	private HeroService heroService;
}
