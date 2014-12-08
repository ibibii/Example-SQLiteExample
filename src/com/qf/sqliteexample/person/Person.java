package com.qf.sqliteexample.person;

public class Person {
	private String name;
	private int id;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public Person(int id,String name) {
		super();
		this.name = name;
		this.id = id;
	}
	public Person() {
		super();
		// TODO Auto-generated constructor stub
	}
}
