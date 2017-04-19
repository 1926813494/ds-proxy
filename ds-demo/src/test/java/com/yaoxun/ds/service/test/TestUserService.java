package com.yaoxun.ds.service.test;

import java.util.Date;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.yaoxun.ds.model.User;
import com.yaoxun.ds.service.UserService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"classpath:applicationContext.xml"})
public class TestUserService {

	@Resource
	private UserService userService;
	
	@Test
	public void testSave() {
		User user = new User();
		user.setName("name1");
		user.setPwd("123456");
		user.setCreateTime(new Date());
		userService.save(user);
	}
	
	@Test
	public void testGet() {
		for(int i = 1;i<=10;i++) {			
			Integer id = 1;
			User user = userService.get(id);
			System.out.println(user);
		}
	}
	
}
