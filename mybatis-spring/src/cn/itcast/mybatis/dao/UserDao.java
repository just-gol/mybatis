package cn.itcast.mybatis.dao;

import java.util.List;

import cn.itcast.mybatis.po.User;


public interface UserDao {
	User getUserById(int id);
	
	List<User> getUserByName(String username);
	
	void insertUser(User user);
}
