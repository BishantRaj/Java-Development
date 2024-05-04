package com.sts;

import java.util.List;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class ReddyJdbcApplication {

	public static void main(String[] args) {
		ApplicationContext context=SpringApplication.run(ReddyJdbcApplication.class, args);
		
		Metal obj=context.getBean(Metal.class);
		obj.setId(112);
		obj.setName("name2");
		obj.setAdd("add2");
		
		MetalRepo repo=context.getBean(MetalRepo.class);
		repo.save(obj);
		
		
		System.out.println(repo.findAll());
	}

}
