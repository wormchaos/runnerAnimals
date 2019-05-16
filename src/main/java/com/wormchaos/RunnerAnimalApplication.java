package com.wormchaos;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.wormchaos.dao")
public class RunnerAnimalApplication {

	public static void main(String[] args) {
		SpringApplication.run(RunnerAnimalApplication.class, args);
	}

}
