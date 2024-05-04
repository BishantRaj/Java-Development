package com.chirp.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.chirp.model.User;

public interface UserRepository extends JpaRepository<User, Long> {
	public User findByEmail(String email);
	
//f6d5caff-d9cf-4260-8815-5952b51fc737
	@Query("SELECT DISTINCT u FROM User u WHERE u.fullName LIKE %:query% OR u.email LIKE %:query%")
	public List<User> searchUser(@Param("query") String query);

}
