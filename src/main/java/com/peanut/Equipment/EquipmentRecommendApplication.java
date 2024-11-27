package com.peanut.Equipment;

import com.peanut.Equipment.common.MinioProperties;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

@SpringBootApplication
public class EquipmentRecommendApplication {
    public static void main(String[] args) {
        SpringApplication.run(EquipmentRecommendApplication.class, args);
    }
}
