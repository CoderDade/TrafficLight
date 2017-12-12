package com.dade.trafficlight.mybatis.test;

import com.dade.trafficlight.mybatis.test.annotation.FruitColor;
import com.dade.trafficlight.mybatis.test.annotation.FruitName;
import com.dade.trafficlight.mybatis.test.annotation.FruitProvider;
import com.google.common.collect.Lists;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class MapperUtil {

    public static void getMapperInfo(Class<?> clazz){

//        System.out.println(clazz.getAnnotatedInterfaces());
//        System.out.println(clazz.getDeclaredMethods());
        Method[] declaredMethods = clazz.getMethods();
        for (Method method : declaredMethods) {
            if (method.isAnnotationPresent(Select.class)){
                System.out.println(method);
                Select select = method.getAnnotation(Select.class);
                System.out.println(Lists.newArrayList(select.value()));
            }
        }


    }

}
