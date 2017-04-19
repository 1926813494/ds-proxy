package com.yaoxun.ds.dao;

import javax.annotation.Resource;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.yaoxun.ds.model.Car;

@Repository("carDao")
public class CarDaoImpl implements CarDao {
	
	@Resource
	private JdbcTemplate jdbcTemplate;
	
	@Override
	public void save(Car car) {
		String sql = "insert into t_car(name,grade) values(?,?)";
		jdbcTemplate.update(sql,car.getName(),car.getGrade());
	}

}
