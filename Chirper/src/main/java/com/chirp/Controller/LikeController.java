package com.chirp.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.chirp.dto.LikeDto;
import com.chirp.dto.mapper.LikeDtoMapper;
import com.chirp.exception.TwitException;
import com.chirp.exception.UserException;
import com.chirp.model.Like;
import com.chirp.model.User;
import com.chirp.service.LikeService;
import com.chirp.service.UserService;
import java.util.*;

@RestController
@RequestMapping("/api")
public class LikeController {

	@Autowired
	private UserService userService;

	@Autowired
	private LikeService likeService;

	@PostMapping("{twitId}/likes")
	public ResponseEntity<LikeDto> likeTwit(@PathVariable Long twitId,
			@RequestHeader("Authorisation") String jwt)
			throws UserException, TwitException {
		User user=userService.findUserProfileByJwt(jwt);
		Like like=likeService.likeTwit(twitId, user);
		LikeDto likeDto=LikeDtoMapper.toLikeDto(like, user);
		return new ResponseEntity<LikeDto>(likeDto,HttpStatus.CREATED);

	}
	
	@PostMapping("twit/{twitId}")
	public ResponseEntity<List<LikeDto>> getAllLikes(@PathVariable Long twitId,
			@RequestHeader("Authorisation") String jwt)
					throws UserException, TwitException {
		User user=userService.findUserProfileByJwt(jwt);
		List<Like> like=likeService.getAllLikes(twitId);
		List<LikeDto> likeDtos=LikeDtoMapper.toLikeDtos(like, user);
		return new ResponseEntity<>(likeDtos,HttpStatus.CREATED);
		
	}
}











