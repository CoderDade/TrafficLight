package com.dade.trafficlight.mybatis.test.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;


public class DebugProxy implements InvocationHandler {

    private Object obj;

    private DebugProxy(Object obj)
    {
        //Greet接口的實現：GreetImpl
        this.obj = obj;
    }

    public static Object newInstance(Object obj)
    {
        System.out.println("obj class loader :" + obj.getClass().getClassLoader().toString());
        System.out.println("obj class interface :" + obj.getClass().getInterfaces());
        return Proxy.newProxyInstance(obj.getClass().getClassLoader(),
                obj.getClass().getInterfaces(), new DebugProxy(obj));
    }

    // Method m：調用的方法
    // Object[] args：方法要傳入的參數
    // invoke实现对GreetImpl中方法的调用，同时也可以在这里加入自己想要实现的操作，
    // 虽然调用原GreetImpl中的方法重要，但我想这里更看重的是通过自定义处理实现GreetImpl中没有的功能
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        Object result;
        try {
            //自定義的處理
            System.out.println("--before method " + method.getName());
            //調用GreetImpl中方法
            result = method.invoke(obj, args);
        }catch(InvocationTargetException e) {
            throw e.getTargetException();
        }catch(Exception e) {
            throw new RuntimeException("unexpected invocation exception: " + e.getMessage());
        }finally {
            System.out.println("--after method " + method.getName());
        }
        return result;
    }
}
