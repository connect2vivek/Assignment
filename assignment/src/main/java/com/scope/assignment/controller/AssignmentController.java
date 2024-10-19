package com.scope.assignment.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.scope.assignment.model.AssignmentModel;
import com.scope.assignment.repository.AssignmentRepository;

@Controller
public class AssignmentController {
	@Autowired
	private AssignmentRepository repository;
	
	@RequestMapping("/")
	public String showDashboard(Model model) {
		List<AssignmentModel> users = repository.findAll();
		model.addAttribute("list",users);
		return "dashboard";
	}
	
	@GetMapping("/adduser")
	public String showAdduser(Model model) {
		model.addAttribute("user1",new AssignmentModel());
		return "adduser";
	}
	
	@PostMapping("/verify")
	public String verifyUser(@ModelAttribute AssignmentModel assign,Model model) {
		model.addAttribute("user1",assign);
		if (repository.findByEmail(assign.getEmail())!=null) {
			model.addAttribute("emailError", "Email already exists!");
			return "adduser";
		}
		repository.save(assign);
		return "redirect:/";
	}
	
	@GetMapping("/edit/{id}")
	public String showEditPage(Model model,@PathVariable("id") int id) {
		AssignmentModel asmodel=repository.findById(id);
		if (asmodel != null) {
	        model.addAttribute("user", asmodel);
	        return "edituser";
	    }
	    return "redirect:/"; 
	}
	
	@PostMapping("/update")
	public String updatePage(Model model,@ModelAttribute AssignmentModel asmodel) {
		model.addAttribute("user",asmodel);
		repository.save(asmodel);
		return "redirect:/";
	}
	
	@GetMapping("/delete/{id}")
	public String delete(Model model,@PathVariable("id") int id) {
		AssignmentModel asmodel=repository.findById(id);
		if (asmodel!=null) {
			repository.delete(asmodel);
		}
		return "redirect:/";
	}
}
