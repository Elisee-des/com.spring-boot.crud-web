package com.crud.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.crud.model.Employee;
import com.crud.service.EmplService;

import jakarta.servlet.http.HttpSession;


@Controller
public class EmployeController {
	
	@Autowired
	private EmplService emplService;

	@GetMapping("/")
	public String home(Model m)
	{
		
		List<Employee> empls = emplService.getAllEmpl();
		m.addAttribute("empls", empls);
		
		return "index";
	}
	
	@GetMapping("/addempl")
	public String addEmpl()
	{
		return "add_empl";
	}
	
	@PostMapping("/register")
	public String empRegister(@ModelAttribute Employee e, HttpSession session)
	{
		System.out.println(e);
		
		emplService.addEmpl(e);
		session.setAttribute("msg", "Employé ajouter  avec succès !");
		
		return "redirect:/";
	}
	
	@GetMapping("/edit/{id}")
	public String edit(@PathVariable int id, Model m)
	{
		Employee e = emplService.getEMpById(id);
		m.addAttribute("empl", e);
		
		return "edit_empl";
	}
	
	@PostMapping("/update")
	public String updateEmp(@ModelAttribute Employee e, HttpSession session) {
		emplService.addEmpl(e);
		session.setAttribute("msg", "Employé mise à jour avec succès !");
		return "redirect:/";
	}
	
	@GetMapping("/delete/{id}")
	public String deleteEMp(@PathVariable int id, HttpSession session) {
		emplService.deleteEMp(id);
		session.setAttribute("msg", "Employé supprimer avec succès !");
		return "redirect:/";
	}
	

}
