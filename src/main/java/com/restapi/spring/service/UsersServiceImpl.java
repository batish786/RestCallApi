package com.restapi.spring.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.restapi.spring.dto.UserDto;
import com.restapi.spring.dto.UserDtoList;
import com.restapi.spring.model.Users;
import com.restapi.spring.repository.UsersDao;

@Service
public class UsersServiceImpl implements UsersService {

	@Autowired
	private UsersDao usersDao;

	@Autowired
	private RestTemplate restTemplate;
	String url = "https://gorest.co.in/public/v2/users";

	@Override
	public UserDto addData(UserDto userDto) {
		HttpHeaders headers = new HttpHeaders();
		headers.setBearerAuth("eeba090e7f7116538bff5fc051ea35b46003dfd435e11cc3a1c80e329b7901ca");
		HttpEntity<UserDto> httpEntity = new HttpEntity<>(userDto, headers);
		UserDto userDto1 = restTemplate.postForObject(url, httpEntity, UserDto.class);
		Users users = new Users();
		BeanUtils.copyProperties(userDto1, users);
		Users users2 = usersDao.save(users);
		BeanUtils.copyProperties(users2, userDto1);
		if (userDto1.getEmail().equalsIgnoreCase(users2.getEmail()))
			userDto1.setAdd(true);
		else
			userDto1.setAdd(false);
		return userDto1;
	}

	@Override
	public UserDto getData(int id) {
		HttpHeaders headers = new HttpHeaders();
		headers.setBearerAuth("eeba090e7f7116538bff5fc051ea35b46003dfd435e11cc3a1c80e329b7901ca");
		HttpEntity<UserDto> httpEntity = new HttpEntity<>(null, headers);
		ResponseEntity<UserDto> response = restTemplate.exchange(url + "/" + id, HttpMethod.GET, httpEntity,
				UserDto.class);
		UserDto userDto = response.getBody();
		System.out.println(userDto);
		usersDao.findById(id).get();
		return userDto;
	}

	@Override
	public UserDto Update(Users users) {
		HttpHeaders headers = new HttpHeaders();
		headers.setBearerAuth("eeba090e7f7116538bff5fc051ea35b46003dfd435e11cc3a1c80e329b7901ca");
		HttpEntity<Users> httpEntity = new HttpEntity<>(users, headers);
		ResponseEntity<UserDto> response = restTemplate.exchange(url + "/" + users, HttpMethod.PUT, httpEntity,
				UserDto.class);
		UserDto users2 = response.getBody();
		usersDao.save(users);
		return users2;

	}

	@Override
	public UserDto Delete(int id) {
		HttpHeaders headers = new HttpHeaders();
		headers.setBearerAuth("eeba090e7f7116538bff5fc051ea35b46003dfd435e11cc3a1c80e329b7901ca");
		HttpEntity<UserDto> httpEntity = new HttpEntity<>(null, headers);
		ResponseEntity<UserDto> responseEntity = restTemplate.exchange(url + "/" + id, HttpMethod.DELETE, httpEntity,
				UserDto.class);
		UserDto userdto = responseEntity.getBody();
		usersDao.findByid(id).getId();
		usersDao.deleteById(id);
		return userdto;

	}

	@Override
	public List<UserDto> getAllData() {
		HttpHeaders headers = new HttpHeaders();
		headers.setBearerAuth("eeba090e7f7116538bff5fc051ea35b46003dfd435e11cc3a1c80e329b7901ca");
		HttpEntity<Users> httpEntity = new HttpEntity<>(null, headers);
		ResponseEntity<List<UserDto>> responseEntity = restTemplate.exchange(url, HttpMethod.GET, httpEntity,
				new ParameterizedTypeReference<List<UserDto>>() {
				});
		List<UserDto> userDtos = responseEntity.getBody();
		List<Users> users = new ArrayList<>();
		for (UserDto userDto : userDtos) {
			Users user=new Users();
			BeanUtils.copyProperties(userDto, user);
			System.out.println(user);
			users.add(user);
		}
		System.out.println(users+" users");
		usersDao.saveAll(users);
		return userDtos;
	}

}
