package com.chirp.dto.mapper;

import java.util.*;

import com.chirp.dto.UserDto;
import com.chirp.model.User;

public class UserDtoMapper {
	public static UserDto toUserDto(User user) {
		UserDto userDto=new UserDto();
		userDto.setId(user.getId());
		userDto.setEmail(user.getEmail());
		userDto.setFullName(user.getFullName());
		userDto.setImage(user.getImage());
		userDto.setBackgroundImage(user.getBackgroundImage());
		userDto.setBio(user.getBio());
		userDto.setBirthDate(user.getBirthDate());
		userDto.setFollowers(toUserDto(user.getFollowers()));
		userDto.setFollowers(toUserDto(user.getFollowing()));
		userDto.setLogin_with_google(user.isLogin_with_google());
		userDto.setLocation(user.getLocation());
//		userDto.isVerified(false);
		
		return userDto;
	}

	private static List<UserDto> toUserDto(List<User> followers) {
		List<UserDto>userDtos=new ArrayList<>();
		
		for(User user:followers) {
			UserDto userDto=new UserDto();
			userDto.setId(user.getId());
			userDto.setEmail(user.getEmail());
			userDto.setFullName(user.getFullName());
			userDto.setImage(user.getImage());
			userDtos.add(userDto);
		}
		return userDtos;
	}
}
