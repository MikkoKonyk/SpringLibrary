package com.konyk.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.konyk.model.Autor;
import com.konyk.model.Book;
import com.konyk.model.Reader;
import com.konyk.model.Storage;
import com.konyk.service.AutorService;
import com.konyk.service.BookDtoService;
import com.konyk.service.BookService;
import com.konyk.service.ReaderService;
import com.konyk.service.StorageService;

@Controller
public class LibraryController {
	
		@Autowired
		private BookService bookService;
		@Autowired
		private AutorService autorService;
		@Autowired
		private ReaderService readerService;
		@Autowired
		private StorageService storageService;
		
		@Autowired
		private BookDtoService bookDtoService;
		
		@RequestMapping("/")
		public String showHome(){
			return "home";
		}
		
		@RequestMapping("/home")
		public String showHomeFromButton(){
			return "home";
		}
		
		@RequestMapping("/checkpage")
		public String showcheckPage(){
			return "checkpage";
		}
		
		@RequestMapping("/book")
		public String showBooks( Model model){
			model.addAttribute("book", new Book());
			model.addAttribute("bookList", bookService.getAllBooks());
			return "book";
		}
		
		@RequestMapping("/autor")
		public String showAutors( Model model){
			model.addAttribute("autor", new Autor());
			model.addAttribute("autorList", autorService.getAllAutors());
			return "autor";
		}
		
		@RequestMapping("/reader")
		public String showReaders(Model model){
			model.addAttribute("reader", new Reader());
			model.addAttribute("readerList", readerService.getAllReaders());
			return "reader";
		}
		
		@RequestMapping("/storage")
		public String showStorage(Model model){
			model.addAttribute("storage", new Storage());
			model.addAttribute("storageList", storageService.getAllStorages());
			return "storage";
		}
	}


