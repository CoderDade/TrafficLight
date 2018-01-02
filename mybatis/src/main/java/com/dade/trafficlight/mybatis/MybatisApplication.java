package com.dade.trafficlight.mybatis;

import com.dade.trafficlight.mybatis.annotation.MybatisTL;
import com.dade.trafficlight.mybatis.util.AnnotationUtil;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.autoconfigure.orm.jpa.HibernateJpaAutoConfiguration;

@SpringBootApplication
@EnableAutoConfiguration(exclude = {DataSourceAutoConfiguration.class, HibernateJpaAutoConfiguration.class})
public class MybatisApplication implements InitializingBean {

	public static void main(String[] args) {
		SpringApplication.run(MybatisApplication.class, args);
	}

	@Override
	public void afterPropertiesSet() throws Exception {
//		AnnotationUtil.limit(MybatisTL.class);
	}
}
