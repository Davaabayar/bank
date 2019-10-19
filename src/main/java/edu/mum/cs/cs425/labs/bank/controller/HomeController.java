package edu.mum.cs.cs425.labs.bank.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {
	@GetMapping(value= {"/", "/bank", "/bank/home"})
	public String home() {
		return "home/index";
	}
}
