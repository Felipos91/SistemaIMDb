package com.desafiolatam.controller;

import javax.persistence.metamodel.SetAttribute;

import org.apache.catalina.connector.Request;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.desafiolatam.models.Show;
import com.desafiolatam.service.ShowService;

@Controller
public class ShowController {
	

	@Autowired
	ShowService showService;
	
	@GetMapping("/addShow")
	public String addShow() {
		return "addShow.jsp";
	}
	
	@PostMapping("/registerShow")
	public String registerShow(Show show, RedirectAttributes redirectAttributes) {
		
		Show showEncontrado=showService.findbyName(show.getName());
		
		if(showEncontrado==null && !show.getName().equals("") && !show.getCadena().equals("") && show.getName()!=null && show.getCadena()!=null) {
			Show showSave=new Show();
			showSave.setName(show.getName());
			showSave.setCadena(show.getCadena());
			showService.save(showSave);
			
			redirectAttributes.addFlashAttribute("Correcto","Successfuly registered");
			return "redirect:/addShow";
		}
		redirectAttributes.addFlashAttribute("Error","This Show is registered!");
		return "redirect:/addShow";
	}
	
	@RequestMapping("/editShow/{id}")
	public String editShow(@ModelAttribute("show") Show show,@PathVariable("id") Long id,Model model) {
		
		show=showService.findbyId(id);
		
		model.addAttribute("show",show);
		return "editShow.jsp";
	}
	
	@PostMapping("/updateShow")
	public String actualizarShow(@ModelAttribute("show") Show show,RedirectAttributes redirectAttributes) {
		showService.save(show);
		redirectAttributes.addFlashAttribute("Correcto","Show Updated");
		return "redirect:/home";
		
	}
	
	@RequestMapping("/deleteShow/{id}")
	public String deleteShow(@PathVariable("id") Long id,RedirectAttributes redirectAttributes) {
		showService.deleteById(id);
		redirectAttributes.addFlashAttribute("Correcto","Show deleted successfuly");
		return "redirect:/home";
	}
	

	
}
