package com.sts;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Metal {
	private int id;
	private String name;
	@Autowired
	private Address address;

	public Metal() {
		System.out.println("Object create");
	}
	
	
	public Metal(int id, String name, Address address) {
		super();
		this.id = id;
		this.name = name;
		this.address = address;
	}


	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	
	public Address getAddress() {
		return address;
	}


	public void setAddress(Address address) {
		this.address = address;
	}
	
	


	public void show() {
		System.out.println("hello");
		address.find();
	}
	
	
}
