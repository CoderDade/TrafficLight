package com.dade.trafficlight.mybatis;

import com.dade.trafficlight.mybatis.annotation.TestService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class MybatisApplicationTests {

	@Test
	public void contextLoads() {
	}

	@Autowired
	TestService testServicet;

	@Test
	public void testApplication(){
		System.out.println(testServicet.testService());
	}

}
