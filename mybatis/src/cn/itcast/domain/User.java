package cn.itcast.domain;

import java.util.Date;

public class User {
	private int id;
	private String username;
	private String sex;
	private Date birthday;
	private String address;
	public void setId(int id) {
		this.id = id;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public int getId() {
		return id;
	}
	public String getUsername() {
		return username;
	}
	public String getSex() {
		return sex;
	}
	public Date getBirthday() {
		return birthday;
	}
	public String getAddress() {
		return address;
	}
	@Override
	public String toString() {
		return "User [id=" + id + ", username=" + username + ", sex=" + sex + ", birthday=" + birthday + ", address="
				+ address + "]";
	}
	
}
