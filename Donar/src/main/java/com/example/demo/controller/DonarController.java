package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.example.demo.service.DonarService;
import com.example.demo.service.imp.DonarServiceImp;

@Controller
public class DonarController {

	private DonarService service;

	public DonarController(DonarService service) {
		super();
		this.service = service;
	}
	@GetMapping("/donar")
	public String listDonars(Model model) {
		model.addAttribute("donar", service.getAllDonars());
		return "donar";
	}
}
