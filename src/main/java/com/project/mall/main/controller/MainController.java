package com.project.mall.main.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainController {
	
	 @Autowired 

	@GetMapping("/")
	public String main() {
		return "home";
	}
	
	@GetMapping("/login")
	public String loginView() {
		return "login";
	}
	
	@GetMapping("/join")
	public String joinView() {
		return "join";
	}

}
