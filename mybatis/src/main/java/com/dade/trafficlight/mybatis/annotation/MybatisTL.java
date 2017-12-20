package com.dade.trafficlight.mybatis.annotation;

import java.lang.annotation.*;

@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface MybatisTL {
    Class type();
    Class collection();
}
