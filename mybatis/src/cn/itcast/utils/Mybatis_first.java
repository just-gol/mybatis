package cn.itcast.utils;

import java.io.IOException;
import java.io.InputStream;
import java.util.Date;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Before;
import org.junit.Test;

import cn.itcast.domain.User;

public class Mybatis_first {
	private SqlSessionFactory sqlSessionFactory = null;

	@Before
	public void init() throws IOException {
		String resource = "mybatis/SqlMapConfig.xml";
		InputStream inputStream = Resources.getResourceAsStream(resource);

		sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);

	}

	@Test
	public void testFindUserById() {
		SqlSession sqlSession = null;
		try {
			sqlSession = sqlSessionFactory.openSession();

			User user = sqlSession.selectOne("getUserById", 10);

			System.out.println(user);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (sqlSession != null) {
				sqlSession.close();
			}
		}
	}

	@Test
	public void getByUser() {
		SqlSession sqlSession = null;
		try {
			sqlSession = sqlSessionFactory.openSession();

			List<User> user = sqlSession.selectList("findUserByUsername", "张");
			for (User user2 : user) {
				System.out.println(user2);
			}

			System.out.println(user);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (sqlSession != null) {
				sqlSession.close();
			}
		}
	}

	@Test
	public void addUser() {
		SqlSession sqlSession = null;
		try {
			sqlSession = sqlSessionFactory.openSession();

			User user = new User();
			user.setUsername("吕布");
			user.setBirthday(new Date());
			user.setAddress("安徽");
			user.setSex("男");
			sqlSession.insert("InsertUser", user);
			System.out.println(user.getId());
			//需要提交事务
			sqlSession.commit();
			System.out.println(user);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (sqlSession != null) {
				sqlSession.close();
			}
		}
	}
	
	@Test
	public void deleteUser() {
		SqlSession sqlSession = null;
		try {
			sqlSession = sqlSessionFactory.openSession();
			
			sqlSession.insert("deleteUser", 29);
			//需要提交事务
			sqlSession.commit();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (sqlSession != null) {
				sqlSession.close();
			}
		}
	}
	
	@Test
	public void updateUser() {
		SqlSession sqlSession = null;
		try {
			sqlSession = sqlSessionFactory.openSession();
			User user = new User();
			user.setUsername("刘备");
			user.setId(28);
			sqlSession.insert("updateUser", user);
			//需要提交事务
			sqlSession.commit();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (sqlSession != null) {
				sqlSession.close();
			}
		}
	}
}
