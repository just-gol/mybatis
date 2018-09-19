package cn.itcast.utils;

import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import cn.itcast.mybatis.dao.UserDao;
import cn.itcast.mybatis.pojo.User;


public class Mybatis_first {
	private ApplicationContext applicationContext;
	@Before
	public void init() throws Exception {
		//初始化spring容器
		applicationContext = new ClassPathXmlApplicationContext("classpath:spring/applicationContext.xml");
	}
	
	@Test
	public void run1(){
		UserDao userDao = applicationContext.getBean(UserDao.class);
		List<User> use = userDao.selectUser();
		for (User user : use) {
			System.out.println(user);
		}
	}
}
