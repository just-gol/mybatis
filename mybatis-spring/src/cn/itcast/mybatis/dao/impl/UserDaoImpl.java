package cn.itcast.mybatis.dao.impl;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.mybatis.spring.support.SqlSessionDaoSupport;

import cn.itcast.mybatis.dao.UserDao;
import cn.itcast.mybatis.po.User;


public class UserDaoImpl extends SqlSessionDaoSupport implements UserDao {

	

	@Override
	public User getUserById(int id) {
		SqlSession sqlSession = getSqlSession();
		User user = sqlSession.selectOne("getUserById", id);
		//sqlSession.close();
		return user;
	}

	@Override
	public List<User> getUserByName(String username) {
		SqlSession sqlSession = getSqlSession();
		List<User> list = sqlSession.selectList("getUserByName", username);
		//sqlSession.close();
		return list;
	}

	@Override
	public void insertUser(User user) {
		SqlSession sqlSession = getSqlSession();
		sqlSession.insert("insertUser", user);
		sqlSession.commit();
		//sqlSession.close();
		
	}

}
