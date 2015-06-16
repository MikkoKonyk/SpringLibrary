package com.roman.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.roman.dto.BookDto;
import com.roman.service.BookDtoService;

@Controller
public class BookDtoController {
	
	@Autowired
	private BookDtoService bookDtoService;
	
	@RequestMapping("/bookDto")
	public String bookDto( Model model){
		 model.addAttribute("bookDto", new BookDto());
		 model.addAttribute("bookDtoList", bookDtoService.getAll());
		return "bookDto";
	}

	@RequestMapping(value = "/bookDto/add", method = RequestMethod.POST)
    public String addBook(@ModelAttribute("bookDto") BookDto bookDto) {
 
		  if(bookDto.getBookIdDto() == null){
			  bookDtoService.parseBookDto(bookDto);
	        }else{
	        	bookDtoService.editBookDto(bookDto);
	        }
	     return "redirect:/bookDto";
    }
	
	@RequestMapping(value = "/bookDto/edit/{bookIdDto}")
    public String editBook(@PathVariable("bookIdDto") Integer bookIdDto, Model model ) {
		model.addAttribute("bookDto", bookDtoService.getBookDtoById(bookIdDto));
		model.addAttribute("bookDtoList", bookDtoService.getAll());
       return "bookDto";
    }

	@RequestMapping(value = "/bookDto/delete/{bookIdDto}" )
    public String deleteBook(@PathVariable("bookIdDto") Integer bookIdDto) {
		bookDtoService.deleteEntryDto(bookIdDto);
		return "redirect:/bookDto";
    }
}
