package com.example.yeomanbg;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;

@MapperScan({"com.example.yeomanbg.dao"})
@SpringBootApplication(exclude={DataSourceAutoConfiguration.class})
public class YeomanBgApplication {

    public static void main(String[] args) {
        SpringApplication.run(YeomanBgApplication.class, args);
    }

}
