package com.myc.erpsystem;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.transaction.annotation.EnableTransactionManagement;
@EnableCaching
//@EnableTransactionManagement
@MapperScan("com.myc.erpsystem.mapper")
@SpringBootApplication
public class ErpsystemApplication {

    public static void main(String[] args) {
        SpringApplication.run(ErpsystemApplication.class, args);
    }

}
