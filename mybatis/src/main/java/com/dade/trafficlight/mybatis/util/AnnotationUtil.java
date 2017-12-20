package com.dade.trafficlight.mybatis.util;

import com.dade.trafficlight.mybatis.annotation.MybatisTL;
import com.dade.trafficlight.mybatis.test.TLUserDao;
import com.google.common.collect.Lists;
import org.apache.ibatis.annotations.Select;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class AnnotationUtil {

    public static void limit() throws NoSuchFieldException, IllegalAccessException {

        Method[] declaredMethods = TLUserDao.class.getMethods();
        for (Method method : declaredMethods) {
            if (method.isAnnotationPresent(Select.class)) {
                Select select = method.getAnnotation(Select.class);
                System.out.println(Lists.newArrayList(select.value()));
//                select.value()[select.value().length-1] += "limit 1";
//                System.out.println(Lists.newArrayList(select.value()));
                InvocationHandler h = Proxy.getInvocationHandler(select);
                Field hField = h.getClass().getDeclaredField("memberValues");
                hField.setAccessible(true);
                Map<String, String[]> memberValues = (Map<String, String[]>) hField.get(h);
                String limitsql = null;
                for (String s : select.value()) {
//                    System.out.println(s);
                    limitsql = limit1ForTest(s);
                    if (limitsql.contains("limit")){
                        System.out.println("Error");
                    }
                    limitsql = "<script>" + limitsql + " limit 1</script>";
//                    System.out.println(limitsql);
                }
                String[] newValue = new String[]{limitsql};
//                String test[] = new String[0];
//                String test[] = new String[]{};
//                System.out.println(test.length);
                memberValues.put("value", newValue);
                System.out.println(Lists.newArrayList(select.value()));
//                System.out.println(select.value().toString());

            }
        }

    }

    public static void checkAnnotation() throws NoSuchFieldException, IllegalAccessException {
        Method[] declaredMethods = TLUserDao.class.getMethods();
        for (Method method : declaredMethods) {
            if (method.isAnnotationPresent(Select.class)) {
                Select select = method.getAnnotation(Select.class);
                System.out.println(Lists.newArrayList(select.value()));

            }
        }
    }

    public static String limit1ForTest(String s){
        Pattern pattern = Pattern.compile("<script>(.*)</script>");
        Matcher matcher = pattern.matcher(s);
        if (matcher.find()){
            return matcher.group(1);
        }
        return null;
    }

}
