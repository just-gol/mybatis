package cn.itcast.mapper;

import java.io.IOException;
import java.io.InputStream;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Before;
import org.junit.Test;

import cn.itcast.domain.User;

public class UserMapperTest {
	private SqlSessionFactory sqlSessionFactory = null;

	@Before
	public void init() throws IOException {
		String resource = "mybatis/SqlMapConfig.xml";
		InputStream inputStream = Resources.getResourceAsStream(resource);

		sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);

	}
	
	@Test
	public void testGetUserById() {
		SqlSession openSession = sqlSessionFactory.openSession();
		UserMapper mapper = openSession.getMapper(UserMapper.class);
		User user = mapper.getUserById(28);
		System.out.println(user);
		openSession.close();
	}

	@Test
	public void testGetUserByName() {
	}

	@Test
	public void testInsertUser() {
	}

}
