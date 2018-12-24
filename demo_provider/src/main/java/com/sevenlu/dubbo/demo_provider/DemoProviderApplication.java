package com.sevenlu.dubbo.demo_provider;

import com.alibaba.dubbo.config.spring.context.annotation.DubboComponentScan;
import org.springframework.boot.WebApplicationType;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;

@SpringBootApplication
@DubboComponentScan(basePackages = "com.sevenlu.dubbo.demo_provider.impl")
public class DemoProviderApplication {

    public static void main(String[] args) {
        new SpringApplicationBuilder(DemoProviderApplication.class).web(WebApplicationType.NONE).run();
    }

}

