package com.yaoxun.ds.service;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.yaoxun.ds.dao.UserDao;
import com.yaoxun.ds.model.User;
import com.yaoxun.dynamic.rw.datasource.DataSource;
import com.yaoxun.dynamic.rw.datasource.DataSourceType;

@Service
public class UserService {

	@Resource
	private UserDao userDao;
	
	public void save(User user) {
		userDao.save(user);
	}
	
	@DataSource(DataSourceType.MASTER_SALVE)
	public User get(Integer id) {
		return userDao.get(id);
	}
	
}
