package com.example.demo.service;

import com.example.demo.clinet.TestClient;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by administrator on 2019/1/7.
 */
@Service
public class TestService {
    @Autowired(required = false)
    private TestClient testClient;

    @HystrixCommand(fallbackMethod = "longFallback", commandProperties = {
            @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = "20000")})
    public String testLong() {
        return  testClient.test();
    }

    @HystrixCommand(fallbackMethod = "shortFallback")
    public String testShort() {
        return testClient.test();
    }

    public String shortFallback() {
        return "shortFallback";
    }

    public String longFallback() {
        return "longFallback";
    }
}
