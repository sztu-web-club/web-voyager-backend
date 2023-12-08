package io.github.sztuwebclub.webvoyager.bootstrap;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = {"io.github.sztuwebclub.webvoyager"})
@EntityScan(basePackages = {"io.github.sztuwebclub.webvoyager"})
public class WebVoyagerApplication {

    public static void main(String[] args) {
        SpringApplication.run(WebVoyagerApplication.class, args);
    }

}
