package com.desafiolatam.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.desafiolatam.models.Show;
import com.desafiolatam.service.ShowService;

@Controller
public class HomeController {

	@Autowired
	ShowService showService;
	
	@RequestMapping("/home")
	public String HomeRoute(Model model) {
		
		List<Show> ShowList=showService.findAll();
		
		model.addAttribute("ShowList", ShowList);
		
		return "home.jsp";
	}
	
	
	
}
