package com.example.demo.filter;

import org.springframework.cloud.netflix.zuul.filters.route.FallbackProvider;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.client.ClientHttpResponse;
import org.springframework.stereotype.Component;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;

/**
 * Created by administrator on 2019/1/7.
 */
@Component
public class ServiceFallbackProvider implements FallbackProvider {
    @Override
    public String getRoute() {
        return null;
    }

    public ClientHttpResponse fallbackResponse() {
        return new ClientHttpResponse() {
            @Override
            public HttpStatus getStatusCode() throws IOException {
                return HttpStatus.INTERNAL_SERVER_ERROR;
            }
            @Override
            public int getRawStatusCode() throws IOException {
                return 505;
            }
            @Override
            public String getStatusText() throws IOException {
                return "服务无响应";
            }
            @Override
            public void close() {}
            @Override
            public InputStream getBody() throws IOException {
                return new ByteArrayInputStream("服务无响应".getBytes());
            }
            @Override
            public HttpHeaders getHeaders() {
                HttpHeaders headers = new HttpHeaders();
                headers.setContentType(MediaType.APPLICATION_JSON);
                return headers;
            }
        };
    }

    @Override
    public ClientHttpResponse fallbackResponse(String s, Throwable throwable) {
        System.out.println("服务名称:"+s+"   Exception:"+throwable.getMessage());
        return fallbackResponse();
    }
}
