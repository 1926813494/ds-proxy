package com.yaoxun.ds.dao;

import javax.annotation.Resource;

import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.yaoxun.ds.model.User;

@Repository
public class UserDao {
	
	@Resource
	private JdbcTemplate jdbcTemplate;

	private String save = "insert into t_user(name,pwd,create_time) values(?,?,?)";
	
	private String getById = "select id,name,pwd,create_time createTime from t_user where id = ?";
	
	public void save(User user) {
		jdbcTemplate.update(save, user.getName(),user.getPwd(),user.getCreateTime());
	}
	
	public User get(Integer id) {
		RowMapper<User> rowMapper = new BeanPropertyRowMapper<>(User.class);
		try {
			return jdbcTemplate.queryForObject(getById, rowMapper, id);			
		}catch(EmptyResultDataAccessException e) {
			return null;
		}
	}
	
}
