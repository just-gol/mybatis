package cn.itcast.test;

import java.io.IOException;
import java.io.InputStream;
import java.util.Date;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Before;
import org.junit.Test;

import cn.itcast.dao.UserDao;
import cn.itcast.dao.impl.UserDaoImpl;
import cn.itcast.domain.User;

public class UserDaoTest {
	private SqlSessionFactory sqlSessionFactory = null;

	@Before
	public void init() throws IOException {
		String resource = "mybatis/SqlMapConfig.xml";
		InputStream inputStream = Resources.getResourceAsStream(resource);

		sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);

	}

	@Test
	public void testGetUserById() {
		UserDao userDao = new UserDaoImpl(sqlSessionFactory);
		User user = userDao.getUserById(28);
		System.out.println(user);
		
	}

	@Test
	public void testGetUserByName() {
		UserDao userDao = new UserDaoImpl(sqlSessionFactory);
		List<User> user = userDao.getUserByName("张");
		for (User user2 : user) {
			System.out.println(user2);
		}
	}

	@Test
	public void testInsertUser() {
		UserDao userDao = new UserDaoImpl(sqlSessionFactory);
		User user = new User();
		user.setUsername("吕布");
		user.setBirthday(new Date());
		user.setAddress("安徽");
		user.setSex("男");
		userDao.insertUser(user);
	}
}
