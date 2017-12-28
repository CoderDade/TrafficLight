package com.dade.trafficlight.mybatis;

import com.dade.trafficlight.mybatis.test.*;
import com.dade.trafficlight.mybatis.test.annotation.Apple;
import com.dade.trafficlight.mybatis.test.annotation.FruitInfoUtil;
import com.dade.trafficlight.mybatis.test.proxy.DebugProxy;
import com.dade.trafficlight.mybatis.test.proxy.Greet;
import com.dade.trafficlight.mybatis.test.proxy.GreetImpl;
import com.dade.trafficlight.mybatis.test.proxy.SimpleProxy;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

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

	@Test
	public void testAnnotation(){
		FruitInfoUtil.getFruitInfo(Apple.class);
	}

//	@Test
//	public void testAnnotationMapper() throws NoSuchFieldException, IllegalAccessException {
//		MapperUtil.getMapperInfo(TLUserDao.class);
//	}

//	@Autowired
//	TLUserDao tlUserDao;

//	@Test
//	public void testMybatis(){
//		List<TLUserEntity> tlusers = tlUserDao.queryTLUser();
//		tlusers.forEach(System.out::println);
//	}

	@Autowired
    SimpleProxy simpleProxy;

	@Autowired
    GreetImpl greet;

	@Test
    public void testProxy(){
//        simpleProxy.sayHello("walter");
//        simpleProxy.goodBye();
//        Greet tmp = new GreetImpl();
//        Greet greet = (Greet) DebugProxy.newInstance(tmp);
        Greet greetProxy = (Greet) DebugProxy.newInstance(greet);
        //生成的greet和tmp有相同的hashCode
        //通过DebugProxy构造的greet比原temp拥有更多功能
        greetProxy.sayHello("walter");
        greet.goodBye();

        System.out.println(greetProxy.getClass().getName());
        System.out.println(greet.getClass().getName());


    }

    @Test
	public void testRun(){
		System.out.println("Hello Java Application!");
	}


}
