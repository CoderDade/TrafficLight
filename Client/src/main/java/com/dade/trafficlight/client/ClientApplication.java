package com.dade.trafficlight.client;

import com.dade.trafficlight.client.dal.TLUserDao;
import com.dade.trafficlight.mybatis.util.AnnotationUtil;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ClientApplication implements InitializingBean {

	public static void main(String[] args) {
		SpringApplication.run(ClientApplication.class, args);
	}

	@Override
	public void afterPropertiesSet() throws Exception {
		AnnotationUtil.limit(TLUserDao.class);
	}
}
