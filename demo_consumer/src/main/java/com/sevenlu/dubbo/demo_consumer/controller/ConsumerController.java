package com.sevenlu.dubbo.demo_consumer.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.sevenlu.dubbo.api.DemoService;
import com.sevenlu.dubbo.model.User;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ConsumerController {

    @Reference(
            interfaceClass = DemoService.class,
            version = "${demo.service.version}",
            application = "${dubbo.application.id}",
            registry = "${dubbo.registry.address}",
            loadbalance = "roundrobin")
    private DemoService demoService;

    @RequestMapping("/sayHello")
    public String testHello(@RequestParam(value = "name", required = false) String name) {
        return demoService.sayHello(name);
    }

    @RequestMapping("/user")
    public User testUser(@RequestParam(value = "name", required = false) String name) {
        User user = demoService.getUser(name);
        return user;
    }
}
