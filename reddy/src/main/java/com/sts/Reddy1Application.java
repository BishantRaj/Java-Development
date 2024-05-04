package com.sts;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class Reddy1Application {

	public static void main(String[] args) {
		ConfigurableApplicationContext context=SpringApplication.run(Reddy1Application.class, args);
		
		Metal o=context.getBean(Metal.class);
		o.show();
		
	}

}
