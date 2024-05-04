package com.sts.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.sts.dao.MetalRepo;
import com.sts.model.Metal;

import jakarta.websocket.server.PathParam;

@RestController
public class MetalController {
	
	@Autowired
	MetalRepo repo;
	
	@RequestMapping("/")
	public String home() {
		return "home.jsp";
	}
	
	@RequestMapping("/addMetal")
	public String addMetal(Metal m) {
		repo.save(m);
		return "home.jsp";
	}
	
	@RequestMapping("/getMetal")
	public ModelAndView getMetal(int id) {
		ModelAndView mv=new ModelAndView("result.jsp"); 
		Metal m=repo.findById(id).orElse(new Metal(201,"error","error"));
		System.out.println(m);
		mv.addObject("key",m);
		return mv;
	}
	@RequestMapping("/delMetal")
	public String delMetal(int id)  {
		repo.deleteById(id);
		return "home.jsp";
	}
	@RequestMapping("/getallMetal")
	public ModelAndView getallMetal(String name)  {
		System.out.println(name);
		ModelAndView mv=new ModelAndView("result.jsp");
		List<Metal> l=repo.findByName(name);
		System.out.println(repo.findByidGreaterThan(103));
		System.out.println(repo.findAll());
		mv.addObject("k1",l);
		return mv;
	}
	
	@RequestMapping("/metal")
	@ResponseBody
	public String getMetals() {
		return repo.findAll().toString();
	}
	
	@RequestMapping("/metal/{id}")
	@ResponseBody
	public String getid(@PathVariable("id") int id) {
		return repo.findById(id).toString();
	}
	
	@RequestMapping("/jmetal")
	@ResponseBody
	public  List<Metal> jgetMetals() {  //jackson core dependency convert java object into json
		return repo.findAll();
	}
	
	@RequestMapping("/jmetal/{id}")
	@ResponseBody
	public Optional<Metal> jgetid(@PathVariable("id") int id) {
		return repo.findById(id);
	}
	
	@PostMapping("/pmetal")
	public Metal postMetal(@RequestBody Metal m) {
		System.out.println(m);
		repo.save(m);
		return m;
	}
	
	@DeleteMapping("/dmetal")
	public String dMetal(@RequestBody Metal m) {
		int j=m.getId();
		Metal i=repo.getOne(j);
		repo.delete(i);
		return "delete";
	}
	
	@PutMapping("/pumetal")
	public Metal putMetal(@RequestBody Metal m) {
		repo.save(m);
		System.out.println(m);
		return m;
	}
	
}
