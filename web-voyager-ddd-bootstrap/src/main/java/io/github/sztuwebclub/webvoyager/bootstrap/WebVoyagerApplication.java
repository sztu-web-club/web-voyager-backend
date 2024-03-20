package io.github.sztuwebclub.webvoyager.bootstrap;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.scheduling.annotation.EnableAsync;

@SpringBootApplication
@EnableAsync
@ComponentScan(basePackages = { "io.github.sztuwebclub.webvoyager.application", "io.github.sztuwebclub.webvoyager.bootstrap", "io.github.sztuwebclub.webvoyager.domain", "io.github.sztuwebclub.webvoyager.infra" })
@MapperScan(basePackages = "io.github.sztuwebclub.webvoyager.infra.dao")
public class WebVoyagerApplication {

    public static void main(String[] args) {
        SpringApplication.run(WebVoyagerApplication.class, args);
    }

}
