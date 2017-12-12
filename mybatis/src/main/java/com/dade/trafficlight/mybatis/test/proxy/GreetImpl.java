package com.dade.trafficlight.mybatis.test.proxy;

import org.springframework.stereotype.Service;

@Service("greet")
public class GreetImpl implements Greet {
    @Override
    public void sayHello(String name) {
        System.out.println("Hello " + name);
    }

    @Override
    public void goodBye() {
        System.out.println("Good bye.");
    }
}
