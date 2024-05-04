package com.sts;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;

@Controller
public class HomeController {

	@RequestMapping("home")
	public String home() {
		System.out.println("hlo bro");
		return "home.jsp";
	}
	
//	@RequestMapping("page1")
//	public String page(String name,HttpSession session) {
//		System.out.println(name);
//		session.setAttribute("name",name);
//		return "Page1";
//	}
	
	@RequestMapping("page1")
	public ModelAndView page(@RequestParam("name")String n) {
		ModelAndView mv=new ModelAndView();
		mv.addObject("name",n);
		mv.setViewName("page1");
		return mv;
	}
	
}
