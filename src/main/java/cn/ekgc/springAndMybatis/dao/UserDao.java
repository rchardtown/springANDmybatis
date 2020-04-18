package cn.ekgc.springAndMybatis.dao;

import cn.ekgc.springAndMybatis.entity.User;

public interface UserDao {

	void saveUser(User user)throws Exception;

}
