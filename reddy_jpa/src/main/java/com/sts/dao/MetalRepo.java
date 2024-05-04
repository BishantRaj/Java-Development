package com.sts.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.sts.model.Metal;

@Repository
public interface MetalRepo extends JpaRepository<Metal, Integer>{
	public List<Metal> findByName(String name);
	public List<Metal> findByprop(String prop);
	public List<Metal> findByidGreaterThan(int id);
	
}


