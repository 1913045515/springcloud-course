package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@EnableDiscoveryClient
@SpringBootApplication
@RestController
public class SpingCloudConsulApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpingCloudConsulApplication.class, args);
	}

	@RequestMapping(value = "test",method = RequestMethod.GET)
	public String test(){
		try {
			Thread.sleep(15000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		return "success";
	}

	@RequestMapping(value = "info",method = RequestMethod.GET)
	public String info(){
		return "我是provider服务的info接口";
	}
}

