package com.restapi.spring.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.restapi.spring.dto.UserDto;
import com.restapi.spring.model.Users;
@Repository
public interface UsersDao extends JpaRepository<Users, Integer>{

	public Users findByid(int id);

}
