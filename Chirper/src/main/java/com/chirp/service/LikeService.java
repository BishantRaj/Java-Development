package com.chirp.service;

import java.util.List;

import com.chirp.exception.TwitException;
import com.chirp.exception.UserException;
import com.chirp.model.Like;
import com.chirp.model.User;

public interface LikeService {
	public Like likeTwit(Long twitId,User user)throws UserException,TwitException;
	
	public List<Like>getAllLikes(Long twitId)throws TwitException;
}
