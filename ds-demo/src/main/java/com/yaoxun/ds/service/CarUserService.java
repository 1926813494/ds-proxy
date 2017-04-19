package com.yaoxun.ds.service;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.yaoxun.ds.dao.CarDao;
import com.yaoxun.ds.dao.UserDao;
import com.yaoxun.ds.model.Car;
import com.yaoxun.ds.model.User;

@Service
public class CarUserService {

	@Resource
	private UserDao userDao;
	@Resource
	private CarDao carDao;
	
	@Transactional
	public void save(User user,Car car) {
		userDao.save(user);
		carDao.save(car);
		int i = 1 / 0;
	}
	
}
