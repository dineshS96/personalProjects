package com.thyme.test.controller;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.thyme.test.entities.loginData;

@Controller
public class myController {
	
	@GetMapping("/form")
	public String openForm(Model m)
	{
		m.addAttribute("loginData",new loginData());
		return "form";
	}
	
	//handler for processing form
	@PostMapping("/process")
	public String processForm(@Valid @ModelAttribute("loginData") loginData login, BindingResult result)
	{
		if(result.hasErrors())
		{
			System.out.println(result);
			return "form";
		}
		System.out.println(login);
		return "success";
	}
}
