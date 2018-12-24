package com.sevenlu.dubbo.demo_consumer;

import com.alibaba.dubbo.config.ApplicationConfig;
import com.alibaba.dubbo.config.ConsumerConfig;
import com.alibaba.dubbo.config.RegistryConfig;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DubboConfiguration {

    @Bean
    public ApplicationConfig getApplicationConfig(){
        ApplicationConfig config=new ApplicationConfig();
        config.setId("consumer");
        config.setName("consumer");
        config.setQosEnable(false);
        config.setQosPort(1111);
        return config;
    }


    @Bean
    public RegistryConfig getRegistryConfig(){
        RegistryConfig config=new RegistryConfig();
        config.setId("demo-registry");
        //设置组播注册
        config.setAddress("multicast://224.5.6.7:1234");
        //设置zookeeper注册
//        config.setAddress("zookeeper://192.168.2.207:2181");
        return config;
    }

    @Bean
    public ConsumerConfig consumerConfig() {
        ConsumerConfig consumerConfig = new ConsumerConfig();
        consumerConfig.setTimeout(3000);
        return consumerConfig;
    }

}
