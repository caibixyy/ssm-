package com.xyy.bean;

public class User {
    private int user_id;
    private String username;
    private int age;
    
	public int getUser_id() {
		return user_id;
	}
	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	@Override
	public String toString() {
		return "User [user_id=" + user_id + ", username=" + username + ", age=" + age + "]";
	}

    
}
