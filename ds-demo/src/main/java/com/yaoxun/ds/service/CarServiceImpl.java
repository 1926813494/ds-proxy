package com.yaoxun.ds.service;

import javax.annotation.Resource;

import com.yaoxun.ds.dao.CarDao;
import com.yaoxun.ds.model.Car;

public class CarServiceImpl implements CarService {
	
	@Resource
	private CarDao carDao;
	
	@Override
	public void save(Car car) {
		carDao.save(car);
	}

	
	
}
