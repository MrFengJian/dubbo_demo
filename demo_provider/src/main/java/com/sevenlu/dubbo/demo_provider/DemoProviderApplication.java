package com.sevenlu.dubbo.demo_provider;

import org.springframework.boot.WebApplicationType;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;

@SpringBootApplication
public class DemoProviderApplication {

    public static void main(String[] args) {
        new SpringApplicationBuilder(DemoProviderApplication.class).web(WebApplicationType.NONE).run();
    }

}

