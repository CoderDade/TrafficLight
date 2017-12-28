package com.dade.trafficlight.client;

import com.dade.trafficlight.client.dal.TLUserDao;
import com.dade.trafficlight.client.dal.TLUserEntity;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ClientApplicationTests {

	@Test
	public void contextLoads() {
	}

	@Autowired
	TLUserDao tlUserDao;

	@Test
	public void testRun(){
		List<TLUserEntity> tlUsers = tlUserDao.queryTLUser();
		tlUsers.forEach(System.out::println);
	}


}
