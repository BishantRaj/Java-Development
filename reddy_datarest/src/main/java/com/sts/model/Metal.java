package com.sts.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

@Entity
public class Metal {
	@Id
	@GeneratedValue
	private int id;
	private String name;
	private String prop;
	
	
	
	public Metal() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Metal(int id, String name, String prop) {
		super();
		this.id = id;
		this.name = name;
		this.prop = prop;
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
	public String getProp() {
		return prop;
	}
	public void setProp(String prop) {
		this.prop = prop;
	}
	
	@Override
	public String toString() {
		return "Metal [id=" + id + ", name=" + name + ", prop=" + prop + "]";
	}
	
	
	
}
