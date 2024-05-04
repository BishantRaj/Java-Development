package com.chirp.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.chirp.dto.UserDto;
import com.chirp.dto.mapper.UserDtoMapper;
import com.chirp.exception.UserException;
import com.chirp.model.User;
import com.chirp.service.UserService;

@RestController
@RequestMapping("/api/users")
public class UserController {

	@Autowired
	private UserService userService;

	@GetMapping("/profile")
	public ResponseEntity<UserDto> getUserProfile(
			@RequestHeader("Authorisation") String jwt) throws UserException {
		User user=userService.findUserProfileByJwt(jwt);
		UserDto userDto=UserDtoMapper.toUserDto(user);
		userDto.setReq_user(true);
		return new ResponseEntity<UserDto>(userDto,HttpStatus.ACCEPTED);
	}
	
	
	@GetMapping("/{userId}")
	public ResponseEntity<UserDto> getUserProfile(
			@RequestHeader("Authorisation") String jwt) throws UserException {
		User user=userService.findUserProfileByJwt(jwt);
		UserDto userDto=UserDtoMapper.toUserDto(user);
		userDto.setReq_user(true);
		return new ResponseEntity<UserDto>(userDto,HttpStatus.ACCEPTED);
	}
}















