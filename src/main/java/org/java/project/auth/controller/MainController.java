package org.java.project.auth.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainController {
	
	@GetMapping("/home-login")
	public String getHome() {
		return "home-login";
	}
	
	@GetMapping("/")
	public String get() {
		return "redirect:/home-login";
	}
}
