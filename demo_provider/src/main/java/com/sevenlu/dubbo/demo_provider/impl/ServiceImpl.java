package com.sevenlu.dubbo.demo_provider.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.sevenlu.dubbo.api.DemoService;
import com.sevenlu.dubbo.model.User;
import org.springframework.stereotype.Component;

import java.lang.management.ManagementFactory;
import java.lang.management.RuntimeMXBean;

@Service(version = "${demo.service.version}")
@Component
public class ServiceImpl implements DemoService {
    @Override
    public String sayHello(String input) {
        return getProcessID() + "----says: " + "Hello " + input.toUpperCase();
    }

    @Override
    public User getUser(String name) {
        User user = new User();
        user.setName(getProcessID() + ":" + name.toUpperCase());
        user.setId(name.trim().length());
        return user;
    }

    public static final int getProcessID() {
        RuntimeMXBean runtimeMXBean = ManagementFactory.getRuntimeMXBean();
        return Integer.valueOf(runtimeMXBean.getName().split("@")[0])
                .intValue();
    }
}
