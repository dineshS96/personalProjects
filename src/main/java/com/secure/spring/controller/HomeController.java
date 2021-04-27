package com.secure.spring.controller;

import java.security.Principal;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HomeController {

	@RequestMapping("/")
	public String home()
	{
		return "home.jsp";
	}
	
	@RequestMapping(value="/login")
	public String loginPage()
	{
		return "login.jsp";
	}
	
	@RequestMapping(value = "/logout-success")
	public String logoutPage()
	{
		return "logout.jsp";
	}
	
	@RequestMapping("/user")
	@ResponseBody
	public Principal user(Principal principal)
	{
		return principal;
	}
	
}
