package com.roman.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import com.roman.model.Book;
import com.roman.service.BookService;

@Controller
public class BookController {
	
	@Autowired
	private BookService bookService;

	@RequestMapping(value = "/book/add", method = RequestMethod.POST)
    public String addBook(@ModelAttribute("book") Book book) {
			bookService.edit(book);
			return "redirect:/book";
    }
	
	@RequestMapping(value = "/book/edit/{bookId}")
    public String editBook(@PathVariable("bookId") Integer bookId, Model model ) {
 		model.addAttribute("book", bookService.getBookById(bookId));
		model.addAttribute("bookList", bookService.getAllBooks());
		return "book";
    }
}
