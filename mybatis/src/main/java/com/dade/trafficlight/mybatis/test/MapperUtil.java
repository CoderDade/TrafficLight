package com.dade.trafficlight.mybatis.test;

import com.dade.trafficlight.mybatis.test.annotation.FruitColor;
import com.dade.trafficlight.mybatis.test.annotation.FruitName;
import com.dade.trafficlight.mybatis.test.annotation.FruitProvider;
import com.google.common.collect.Lists;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.Map;

public class MapperUtil {

    public static void getMapperInfo(Class<?> clazz) throws NoSuchFieldException, IllegalAccessException {

//        System.out.println(clazz.getAnnotatedInterfaces());
//        System.out.println(clazz.getDeclaredMethods());
        Method[] declaredMethods = clazz.getMethods();
        for (Method method : declaredMethods) {
            if (method.isAnnotationPresent(Select.class)){
                System.out.println(method);
                Select select = method.getAnnotation(Select.class);
                System.out.println(Lists.newArrayList(select.value()));
//                select.value()[select.value().length-1] += "limit 1";
//                System.out.println(Lists.newArrayList(select.value()));
                InvocationHandler h = Proxy.getInvocationHandler(select);
                Field hField = h.getClass().getDeclaredField("memberValues");
                hField.setAccessible(true);
                Map<String, String[]> memberValues = (Map<String, String[]>) hField.get(h);
                String[] newValue = new String[]{"test"};
//                String test[] = new String[0];
//                String test[] = new String[]{};
//                System.out.println(test.length);
                memberValues.put("value", newValue);
                System.out.println(Lists.newArrayList(select.value()));
//                System.out.println(select.value().toString());

            }
        }


    }

}
