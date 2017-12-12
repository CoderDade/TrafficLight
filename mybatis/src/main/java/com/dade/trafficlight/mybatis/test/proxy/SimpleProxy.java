package com.dade.trafficlight.mybatis.test.proxy;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SimpleProxy implements Greet {

    @Autowired
    Greet greet;

    @Override
    public void sayHello(String name) {
        System.out.println("--before method sayHello");
        greet.sayHello(name);
        System.out.println("--after method sayHello");
    }

    @Override
    public void goodBye() {
        System.out.println("--before method goodBye");
        greet.goodBye();
        System.out.println("--after method goodBye");
    }
}
