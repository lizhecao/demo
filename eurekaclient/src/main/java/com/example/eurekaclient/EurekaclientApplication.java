package com.example.eurekaclient;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@EnableDiscoveryClient
@RestController
public class EurekaclientApplication {
	@Value("${server.port}")
	String port;

	@RequestMapping(value = "/", method = RequestMethod.POST)
	public String service1(String name) {
		return "hello " + name + ", I'm service-hi from port " + port;
	}

	public static void main(String[] args) {
		SpringApplication.run(EurekaclientApplication.class, args);
	}
}
