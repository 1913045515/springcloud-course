package com.example.demo.clinet;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by administrator on 2019/1/6.
 */

@FeignClient(value = "provider")
public interface TestClient {
    @RequestMapping(method = RequestMethod.GET, value = "/test")
    public String test();
}
