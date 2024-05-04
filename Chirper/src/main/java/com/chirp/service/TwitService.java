package com.chirp.service;

import java.util.List;

import com.chirp.exception.TwitException;
import com.chirp.exception.UserException;
import com.chirp.model.Twit;
import com.chirp.model.User;
import com.chirp.request.TwitReplyReq;

public interface TwitService {
	public Twit createTwit(Twit req,User user)throws UserException;
	public List<Twit>findAllTwit();
	public Twit retwit(Long twitId,User user)throws UserException,TwitException;
	public Twit findById(Long twitId)throws TwitException ;
	
	public void deleteTwitById(Long twitId,Long userId)throws TwitException,UserException;
		
	public Twit removeFromRetwit(Long twitId,User user)throws TwitException,UserException;
	public Twit createdReply(TwitReplyReq req,User user)throws TwitException;
	
	public List<Twit>getUserTwit(User user);
	
	public List<Twit>findByLikesContainsUser(User user);
	
}
