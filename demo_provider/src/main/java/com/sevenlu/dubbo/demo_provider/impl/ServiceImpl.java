package com.sevenlu.dubbo.demo_provider.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.sevenlu.dubbo.api.DemoService;
import com.sevenlu.dubbo.model.User;
import jdk.nashorn.internal.objects.annotations.Getter;
import org.springframework.stereotype.Component;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import java.lang.management.ManagementFactory;
import java.lang.management.RuntimeMXBean;

@Service(
        interfaceClass = DemoService.class,
        version = "${demo.service.version}",
        application = "${dubbo.application.id}",
        protocol = "${dubbo.protocol.id}",
        registry = "${dubbo.registry.id}"
)
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
