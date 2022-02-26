package com.restapi.spring.dto;


public class UserDto{

	private int id;
	private String name;
	private String email;
	private String gender;
	private String status;
	private boolean isAdd;
	
	public boolean isAdd() {
		return isAdd;
	}
	public void setAdd(boolean isAdd) {
		this.isAdd = isAdd;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	
	public UserDto() {
		super();
		// TODO Auto-generated constructor stub
	}
	public UserDto(int id, String name, String email, String gender, String status, boolean isAdd) {
		super();
		this.id = id;
		this.name = name;
		this.email = email;
		this.gender = gender;
		this.status = status;
		this.isAdd = isAdd;
	}
	@Override
	public String toString() {
		return "UserDto [id=" + id + ", name=" + name + ", email=" + email + ", gender=" + gender + ", status=" + status
				+ ", isAdd=" + isAdd + "]";
	}
	
	
}
