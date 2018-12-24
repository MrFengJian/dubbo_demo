package com.sevenlu.dubbo.demo_provider;

import com.alibaba.dubbo.config.ApplicationConfig;
import com.alibaba.dubbo.config.ProtocolConfig;
import com.alibaba.dubbo.config.RegistryConfig;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DubboConfiguration {

    @Bean
    public ApplicationConfig getApplicationConfig() {
        ApplicationConfig config = new ApplicationConfig();
        config.setLogger("slf4j");
        config.setId("provider");
        config.setName("provider");
        config.setQosEnable(false);
        return config;
    }

    @Bean
    public ProtocolConfig getProtocolConfig() {
        ProtocolConfig config = new ProtocolConfig();
        //对外提供rest协议
        config.setId("rest");
        config.setName("rest");
        config.setPort(8888);
        return config;
    }

    @Bean
    public ProtocolConfig dubboProtocolConfig(){
        ProtocolConfig config=new ProtocolConfig();
        config.setName("dubbo");
        config.setId("dubbo");
        config.setPort(12345);
        config.setStatus("server");
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

}
