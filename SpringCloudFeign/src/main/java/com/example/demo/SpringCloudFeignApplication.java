package com.example.demo;

import com.example.demo.clinet.TestClient;
import com.example.demo.service.TestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@EnableHystrix
@EnableHystrixDashboard
@EnableCircuitBreaker
@SpringBootApplication
@EnableFeignClients
@EnableDiscoveryClient
@RestController
public class SpringCloudFeignApplication {
	@Autowired(required = false)
	private TestClient testClient;

	@Autowired
	private TestService testService;

	public static void main(String[] args) {
		SpringApplication.run(SpringCloudFeignApplication.class, args);
	}

	@RequestMapping(value = "test",method = RequestMethod.GET)
	public String test(){
		return testClient.test();
	}

	@RequestMapping(value = "info",method = RequestMethod.GET)
	public String getInfo(){
		return "我是consumer服务的info接口";
	}

	@RequestMapping(value = "testLong",method = RequestMethod.GET)
	public String testLong(){
		return testService.testLong();
	}

	@RequestMapping(value = "testShort",method = RequestMethod.GET)
	public String testShort(){
		return testService.testShort();
	}
}

