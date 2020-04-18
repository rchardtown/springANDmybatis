package cn.ekgc.springAndMybatis.service;

import cn.ekgc.springAndMybatis.entity.User;

public interface UserService {
	public boolean saveUser(User user)throws Exception;
}
