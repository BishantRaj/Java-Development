package com.chirp.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.chirp.model.Twit;
import com.chirp.model.User;
import com.chirp.model.Like;


public interface TwitRepository extends JpaRepository<Twit, Long>{

	List<Twit>findAllByIsTwitTrueOrderByCreatedAtDesc();
	
	List<Twit>findByRetwitUserContainsOrUser_IdAndIsTwitTrueOrderByCreatedAtDesc(User user,Long userId);
	
	List<Twit>findByLikesContainingOrderByCreatedAtDesc(User user);
	
	@Query("SELECT t FROM Twit t JOIN t.likes l WHERE l.user.id = :userId")
	List<Twit> findByLikesUser_id(Long userId);
	
}


//@Query("Select t from twit t join t.likes l where l.user.id=:userId")