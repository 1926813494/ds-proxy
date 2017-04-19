package com.yaoxun.ds.model;

public class Car {

	private Integer id;
	
	private String name;
	
	private int grade;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getGrade() {
		return grade;
	}

	public void setGrade(int grade) {
		this.grade = grade;
	}

	@Override
	public String toString() {
		return "Car [id=" + id + ", name=" + name + ", grade=" + grade + "]";
	}
	
}
