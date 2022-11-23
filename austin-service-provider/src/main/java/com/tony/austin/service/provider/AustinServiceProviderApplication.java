package com.tony.austin.service.provider;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.tony.austin.support.mapper")
public class AustinServiceProviderApplication {

    public static void main(String[] args) {
        SpringApplication.run(AustinServiceProviderApplication.class, args);
    }

}
