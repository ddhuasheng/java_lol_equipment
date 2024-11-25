package com.peanut.Equipment.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import org.springdoc.core.models.GroupedOpenApi;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class Knife4jConfig {
	@Bean
	public OpenAPI openAPI() {
		return new OpenAPI().info(
				new Info()
						.title("lol装备推荐系统")
						.description("lol装备推荐系统接口文档")
						.version("1.0")
						.contact(
								new Contact()
										.name("peanut")
										.email("1551064289@qq.com")
						)
		);
	}

	@Bean
	public GroupedOpenApi adminAPI() {
		return GroupedOpenApi
				.builder()
				.group("lol装备推荐系统")
				.pathsToMatch("/v1/**")
				.build();
	}
}
