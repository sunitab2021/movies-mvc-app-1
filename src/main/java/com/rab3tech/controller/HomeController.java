package com.rab3tech.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.rab3tech.dao.LoginDao;
import com.rab3tech.service.ILoginService;


//This is my model class or Controller class
@Controller
public class HomeController {
	
	@Autowired
	private LoginDao loginDao;
	
	@Autowired
	private ILoginService loginService;
	
	
	@GetMapping("/")
	public String foo() {
		return "index";   // /index.jsp
	}
	
	@GetMapping("/paa")
	public String show() {
		return "index";   // /index.jsp
	}
	
	//METHOD = GET
	//ACTION = login
	@GetMapping("/login")
	public String loginPage() {
		return "clogin";   // /clogin.jsp
	}
	
	
	@PostMapping("/login")
	public String loginSubmit(@RequestParam String username, @RequestParam String password ,Model model) {
		boolean status=loginDao.validateUser(username, password);
		if(status) {
			return "home";
		}else {
		  //Create user into database	
			loginService.save(username,password);
		  //Page ,request ,session ,application	
		  model.addAttribute("message","Hey! username and password are not correct!");
		  return "clogin";   // /index.jsp
		}
	}
	
	
	//ACTION=/login
	//METHOD =POST
	/**
	@PostMapping("/login")
	public String loginSubmit(HttpServletRequest req) {
		String username=req.getParameter("username");
		String password=req.getParameter("password");
		if("jack".equals(username) && "jill".equals(password)) {
			return "home";
		}else {
		  //Page ,request ,session ,application	
		  req.setAttribute("message","Hey! username and password are not correct!");
		  return "clogin";   // /index.jsp
		}
	}*/
	

}
