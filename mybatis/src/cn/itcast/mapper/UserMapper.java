package cn.itcast.mapper;

import java.util.List;

import cn.itcast.domain.User;

public interface UserMapper {
	User getUserById(int id);
	List<User> getUserByName(String username);
	void insertUser(User user);
}
