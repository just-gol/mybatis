package cn.itcast.mybatis.dao;

import java.util.List;

import cn.itcast.mybatis.pojo.User;

public interface UserDao {
	List<User> selectUser();
}
