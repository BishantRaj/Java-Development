package com.sts;

import org.springframework.stereotype.Component;

@Component
public class Address {
	private int road;
	private String city;
	private String State;
	
	
	
	public Address() {
		super();
		
	}
	
	
	public Address(int road, String city, String state) {
		super();
		this.road = road;
		this.city = city;
		State = state;
	}


	public int getRoad() {
		return road;
	}
	public void setRoad(int road) {
		this.road = road;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getState() {
		return State;
	}
	public void setState(String state) {
		State = state;
	}
	
	public void find() {
		System.out.println("find you hahahha");
	}
	
	
}
