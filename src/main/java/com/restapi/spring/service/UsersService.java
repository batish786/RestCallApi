package com.restapi.spring.service;

import java.util.List;

import com.restapi.spring.dto.UserDto;
import com.restapi.spring.model.Users;

public interface UsersService {

	public UserDto addData(UserDto userDto);
	
	public UserDto getData(int id);
	
	public UserDto Update(Users users);
	
	public UserDto Delete(int id);
	
	public List<UserDto> getAllData();
	
}
