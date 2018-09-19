package cn.itcast.mybatis.mapper;

import static org.junit.Assert.*;

import java.util.Date;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import cn.itcast.mybatis.po.User;
import cn.itcast.mybatis.po.UserExample;
import cn.itcast.mybatis.po.UserExample.Criteria;

public class UserMapperTest {

	private ApplicationContext applicationContext;
	@Before
	public void init() throws Exception {
		applicationContext = new ClassPathXmlApplicationContext("classpath:spring/applicationContext.xml");
	}


	@Test
	public void testInsert() {
		UserMapper mapper = applicationContext.getBean(UserMapper.class);
		User user = new User();
		user.setUsername("关羽");
		user.setAddress("山东");
		user.setBirthday(new Date());
		user.setSex("男");
		mapper.insert(user);
	}

	@Test
	public void testSelectByExample() {
		UserMapper mapper = applicationContext.getBean(UserMapper.class);
		UserExample example = new UserExample();
//		Criteria createCriteria = example.createCriteria();
//		//模糊查询姓张的
//		createCriteria.andUsernameLike("%张%");
//		List<User> user = mapper.selectByExample(example);
//		for (User user2 : user) {
//			System.out.println(user2);
//		}
			//查询所有
			List<User> list = mapper.selectByExample(example);
			for (User user : list) {
				System.out.println(user);
			}
	}

	/**
	 * 根据主键查询
	 */
	@Test
	public void testSelectByPrimaryKey() {
		UserMapper mapper = applicationContext.getBean(UserMapper.class);
		User user = mapper.selectByPrimaryKey(10);
		System.out.println(user);
	}

}
