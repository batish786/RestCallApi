package com.restapi.spring.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.restapi.spring.dto.UserDto;
import com.restapi.spring.model.Users;
import com.restapi.spring.service.UsersService;

@RestController
@RequestMapping("api/v1/users")
public class UsersController {

	@Autowired
	UsersService usersService;
	
	@PostMapping
	public ResponseEntity<?> DataAdd(@RequestBody UserDto userDto) {
		 try {
		    usersService.addData(userDto);
			return new ResponseEntity<>("Data is Adeded",HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<>("something went wrong", HttpStatus.OK);
		}
	}
	
	@GetMapping("{id}")
	public ResponseEntity<?> getData(@PathVariable("id") int id ) {
		 try {
			UserDto data = usersService.getData(id);
			
			return new ResponseEntity<>("Data Fetch SuccessFully", HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<>("Data Not Fetch", HttpStatus.BAD_REQUEST);
		}
	}
	
	@PutMapping
	public ResponseEntity<?> UpdateData(@RequestBody() Users users) {
		 try {
			usersService.Update(users);
			return new ResponseEntity<>("Data Update", HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<>("Something Went Wrong", HttpStatus.BAD_REQUEST);
		}
	}
	
	@DeleteMapping( "{id}")
	public ResponseEntity<?> delete(@PathVariable("id")  int id) {
		try {
			usersService.Delete(id);
			return new ResponseEntity<>("Data Deleted SuccessFully...", HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<>("Something Went Wrong", HttpStatus.BAD_REQUEST);
		}
	}
	
	@GetMapping
	public List<UserDto> getAlldata(){
		return	usersService.getAllData();
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
}
