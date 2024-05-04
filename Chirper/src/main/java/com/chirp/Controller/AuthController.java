package com.chirp.Controller;

import java.sql.Struct;

import org.apache.catalina.authenticator.SpnegoAuthenticator.AuthenticateAction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.chirp.config.JwtProvider;
import com.chirp.exception.UserException;
import com.chirp.model.User;
import com.chirp.model.Varification;
import com.chirp.repository.UserRepository;
import com.chirp.response.AuthResponse;
import com.chirp.service.CustomUserDetailsServiceImplementation;

@RestController
@RequestMapping("/auth")
public class AuthController {
	@Autowired

	private UserRepository userRepository;

	@Autowired
	private PasswordEncoder passwordEncoder;

	@Autowired
	private JwtProvider jwtProvider;

	@Autowired
	private CustomUserDetailsServiceImplementation customeUserDetails;
	
	@PostMapping("/signup")
	public ResponseEntity<AuthResponse>createUserHandle(@RequestBody User user)throws UserException{
		System.out.println("working   "+user);
		String email=user.getEmail();
		String password=user.getPassword();
		String fullName=user.getFullName();
		String birthDate=user.getBirthDate();
		
		User isEmailExist=userRepository.findByEmail(email);
		if(isEmailExist!=null) {
			throw new UserException("Email already used");
		}
		
		User createdUser=new User();
		createdUser.setEmail(email);
		createdUser.setFullName(fullName);
		createdUser.setPassword(passwordEncoder.encode(password));
		createdUser.setBirthDate(birthDate);
		createdUser.setVerification(new Varification());
		
		User savedUser=userRepository.save(createdUser);
		
		Authentication authentication=new UsernamePasswordAuthenticationToken(email, password);
		SecurityContextHolder.getContext().setAuthentication(authentication);
		
		String token=jwtProvider.generateToken(authentication);
		AuthResponse res=new AuthResponse(token,true);	
		return new ResponseEntity<AuthResponse>(res,HttpStatus.CREATED);
		
		
		
	
	}
	@PostMapping("/signin")
	public ResponseEntity<AuthResponse>signin(@RequestBody User user){
		String username=user.getEmail();
		String password=user.getPassword();
		
		System.out.println("working   "+username+" "+password);
		
		Authentication authentication=authenticate(username,password);
		System.out.println("here   "+authentication);
		String token=jwtProvider.generateToken(authentication);
		AuthResponse res=new AuthResponse(token,true);	
		return new ResponseEntity<AuthResponse>(res,HttpStatus.ACCEPTED);
		
	}

	private Authentication authenticate(String username, String password) {
//		System.out.println("authwork1");
		UserDetails userDetails=customeUserDetails.loadUserByUsername(username);
//		System.out.println("asbcajbc");
//		System.out.println("user cred"+userDetails);
		if(userDetails==null) {
			throw new BadCredentialsException("Invalid Username...");
		}
		if(!passwordEncoder.matches(password, userDetails.getPassword())) {
			throw new BadCredentialsException("Invalid Username or Password");
		}
		
		Authentication auth= new UsernamePasswordAuthenticationToken(userDetails, null,userDetails.getAuthorities());
//		System.out.println("authwork"+auth);
		return auth;
	}
}
