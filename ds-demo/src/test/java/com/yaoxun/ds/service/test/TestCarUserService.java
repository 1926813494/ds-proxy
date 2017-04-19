package com.yaoxun.ds.service.test;

import java.util.Date;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.yaoxun.ds.model.Car;
import com.yaoxun.ds.model.User;
import com.yaoxun.ds.service.CarUserService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"classpath:applicationContext.xml"})
public class TestCarUserService {

	@Resource
	private CarUserService carUserService;
	
	@Test
	public void testSave() {
		Car car = new Car();
		car.setName("newcar4343");
		car.setGrade(15);
		User user = new User();
		user.setName("newuser3232");
		user.setPwd("4545");
		user.setCreateTime(new Date());
		carUserService.save(user, car );
	}
	
}
