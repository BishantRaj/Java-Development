package com.chirp.Controller;

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
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.chirp.dto.TwitDto;
import com.chirp.dto.mapper.TwitDtoMapper;
import com.chirp.exception.TwitException;
import com.chirp.exception.UserException;
import com.chirp.model.Twit;
import com.chirp.model.User;
import com.chirp.request.TwitReplyReq;
import com.chirp.response.ApiResponse;
import com.chirp.service.TwitService;
import com.chirp.service.UserService;

@RestController
@RequestMapping("/api/twits")
public class TwitController {

	@Autowired
	private TwitService twitService;

	private UserService userService;
	
	
	@PostMapping("/create")
	public ResponseEntity<TwitDto>createTwit(@RequestBody Twit req,@RequestHeader("Authorization")String jwt)throws UserException,TwitException{
		User user=userService.findUserProfileByJwt(jwt);
		Twit twit=twitService.createTwit(req, user);
		TwitDto twitDto=TwitDtoMapper.totwitDto(twit, user);
		return new ResponseEntity<>(twitDto,HttpStatus.CREATED);
	}
	
	
	@PostMapping("/reply")
	public ResponseEntity<TwitDto>replyTwit(@RequestBody TwitReplyReq req,@RequestHeader("Authorization")String jwt)throws UserException,TwitException{
		User user=userService.findUserProfileByJwt(jwt);
		Twit twit=twitService.createdReply(req, user);
		TwitDto twitDto=TwitDtoMapper.totwitDto(twit, user);
		return new ResponseEntity<>(twitDto,HttpStatus.CREATED);
	}
	
	
	@PutMapping("/{twitId}/retwit")
	public ResponseEntity<TwitDto>retwit(@PathVariable Long twitId ,@RequestHeader("Authorization")String jwt)throws UserException,TwitException{
		User user=userService.findUserProfileByJwt(jwt);
		Twit twit=twitService.retwit(twitId, user);
		TwitDto twitDto=TwitDtoMapper.totwitDto(twit, user);
		return new ResponseEntity<>(twitDto,HttpStatus.OK);
	}
	
	
	@GetMapping("/{twitId}")
	public ResponseEntity<TwitDto>findTwitById(@PathVariable Long twitId ,@RequestHeader("Authorization")String jwt)throws UserException,TwitException{
		User user=userService.findUserProfileByJwt(jwt);
		Twit twit=twitService.findById(twitId);
		TwitDto twitDto=TwitDtoMapper.totwitDto(twit, user);
		return new ResponseEntity<>(twitDto,HttpStatus.OK);
	}
	
	
	@DeleteMapping("/{twitId}")
	public ResponseEntity<ApiResponse>deleteTwit(@PathVariable Long twitId ,@RequestHeader("Authorization")String jwt)throws UserException,TwitException{
		User user=userService.findUserProfileByJwt(jwt);
		twitService.deleteTwitById(twitId,user.getId());
//		TwitDto twitDto=TwitDtoMapper.totwitDto(twit, user);
		
		ApiResponse res=new ApiResponse();
		res.setMessage("Twit delete successfullt");
		res.setStatus(true);
		return new ResponseEntity<>(res,HttpStatus.OK);
	}
	
	
	@GetMapping("/")
	public ResponseEntity<List<TwitDto>>getAllTwits(@RequestHeader("Authorization")String jwt)throws UserException,TwitException{
		User user=userService.findUserProfileByJwt(jwt);
		List<Twit>twits=twitService.findAllTwit();
		
		List<TwitDto> twitDto=TwitDtoMapper.toTwitDtos(twits, user);
		return new ResponseEntity<>(twitDto,HttpStatus.OK);
	}
	
	@GetMapping("/user/{userId}")
	public ResponseEntity<List<TwitDto>>getUsersAllTwits(@PathVariable Long userId,@RequestHeader("Authorization")String jwt)throws UserException,TwitException{
		User user=userService.findUserProfileByJwt(jwt);
		List<Twit>twits=twitService.getUserTwit(user);
		
		List<TwitDto> twitDto=TwitDtoMapper.toTwitDtos(twits, user);
		return new ResponseEntity<>(twitDto,HttpStatus.OK);
	}
	
	
	@GetMapping("/user/{userId}/likes")
	public ResponseEntity<List<TwitDto>>findTwitByLikesContainesUser(@PathVariable Long userId,@RequestHeader("Authorization")String jwt)throws UserException,TwitException{
		User user=userService.findUserProfileByJwt(jwt);
		List<Twit>twits=twitService.findByLikesContainsUser(user);
		
		List<TwitDto> twitDto=TwitDtoMapper.toTwitDtos(twits, user);
		return new ResponseEntity<>(twitDto,HttpStatus.OK);
	}
	
	
	
}













