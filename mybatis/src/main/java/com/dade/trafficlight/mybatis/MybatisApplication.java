package com.dade.trafficlight.mybatis;

import com.dade.trafficlight.mybatis.util.AnnotationUtil;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class MybatisApplication implements InitializingBean {

	public static void main(String[] args) {
		SpringApplication.run(MybatisApplication.class, args);
	}

	@Override
	public void afterPropertiesSet() throws Exception {
//		AnnotationUtil.limit();
	}
}
