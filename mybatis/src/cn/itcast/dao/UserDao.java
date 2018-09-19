package cn.itcast.dao;

import java.util.List;

import cn.itcast.domain.User;

public interface UserDao {
	User getUserById(int id);
	List<User> getUserByName(String username);
	void insertUser(User user);
}
