package com.example.sharding_jdbc;

import org.apache.commons.collections4.map.HashedMap;
import org.apache.commons.dbcp.BasicDataSource;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.sql.DataSource;
import java.util.Map;

@SpringBootApplication
public class ShardingJdbcApplication {

	public static void main(String[] args) {
//		SpringApplication.run(ShardingJdbcApplication.class, args);
		Map<String, DataSource> dataSourceMap = new HashedMap<>();
		BasicDataSource dataSource1 = new BasicDataSource();
		dataSource1.setDriverClassName("com.mysql.jdbc.Driver");
		dataSource1.setUrl("jdbc:mysql://localhost:3306/ds0");

	}

}
