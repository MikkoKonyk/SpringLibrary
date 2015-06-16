package com.roman.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.roman.model.Autor;
import com.roman.service.AutorService;

@Controller
public class AutorController {
	
		@Autowired
		private AutorService autorService;
				
		@RequestMapping(value = "/autor/add", method = RequestMethod.POST)
	     public String addAutor(@ModelAttribute("autor") Autor autor) {
	          autorService.edit(autor);
	          return "redirect:/autor";
	     }
		
		@RequestMapping(value = "/autor/edit/{autorId}")
	     public String editAutor(@PathVariable("autorId") Integer autorId, Model model ) {
			model.addAttribute("autor", autorService.getAutorById(autorId));
			model.addAttribute("autorList", autorService.getAllAutors());
	        return "autor";
	     }
	 
}
