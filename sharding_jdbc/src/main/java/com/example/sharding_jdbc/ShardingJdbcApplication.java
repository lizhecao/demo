package com.example.sharding_jdbc;

import com.example.sharding_jdbc.service.InitService;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
@MapperScan(basePackages = "com.example.sharding_jdbc.mapper")
public class ShardingJdbcApplication {

	public static void main(String[] args) {
		ConfigurableApplicationContext ctx = SpringApplication.run(ShardingJdbcApplication.class, args);
		ctx.getBean(InitService.class).initEnv();
	}

}
