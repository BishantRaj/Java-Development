package com.chirp.dto.mapper;

import java.util.*;

import com.chirp.dto.LikeDto;
import com.chirp.dto.TwitDto;
import com.chirp.dto.UserDto;
import com.chirp.model.Like;
import com.chirp.model.User;

public class LikeDtoMapper {
	public static LikeDto toLikeDto(Like like,User reqUser) {
		UserDto user=UserDtoMapper.toUserDto(like.getUser());
		UserDto reqUserDto=UserDtoMapper.toUserDto(reqUser);
		TwitDto twit=TwitDtoMapper.totwitDto(like.getTwit(), reqUser);
		
		LikeDto likeDto=new LikeDto();
		likeDto.setId(like.getId());
		likeDto.setTwit(twit);
		likeDto.setUser(user);
		
		
		return likeDto;
	}
	
	public static List<LikeDto>toLikeDtos(List<Like>likes,User reqUser){
		List<LikeDto>likeDtos=new ArrayList<>();
		for(Like like:likes) {
			UserDto user=UserDtoMapper.toUserDto(like.getUser());
			TwitDto twit=TwitDtoMapper.totwitDto(like.getTwit(), reqUser);
			LikeDto likeDto=new LikeDto();
			likeDto.setId(like.getId());
			likeDto.setTwit(twit);
			likeDto.setUser(user);
		}
		
		return likeDtos;
	}
}
