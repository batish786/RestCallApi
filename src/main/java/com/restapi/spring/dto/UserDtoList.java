package com.restapi.spring.dto;

import java.util.List;

public class UserDtoList {
	private List<UserDto> userDtos;

	public List<UserDto> getUserDtos() {
		return userDtos;
	}

	public void setUserDtos(List<UserDto> userDtos) {
		this.userDtos = userDtos;
	}
}
