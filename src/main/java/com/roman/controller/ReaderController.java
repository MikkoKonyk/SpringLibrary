package com.roman.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.roman.model.Reader;
import com.roman.model.Storage;
import com.roman.service.ReaderService;


@Controller
public class ReaderController {
	@Autowired
	private ReaderService readerService;
			
	@RequestMapping(value = "/reader/add", method = RequestMethod.POST)
     public String addReader(@ModelAttribute("reader") Reader reader) {
		if(reader.getReaderId() == null){
			  readerService.add(reader);
	        }else{
	        	readerService.edit(reader);
	        }
	     return "redirect:/reader";
     }
	
	@RequestMapping(value = "/reader/edit/{readerId}")
     public String editReader(@PathVariable("readerId") Integer readerId, Model model ) {
		model.addAttribute("reader", readerService.getReaderById(readerId));
		model.addAttribute("readerList", readerService.getAllReaders());
        return "reader";
     }
 
	
	@RequestMapping(value = "/reader/delete/{readerId}" )
     public String deleteReader(@PathVariable("readerId") Integer readerId) {
		Reader reader = readerService.getReaderById(readerId);
		List<Storage> list = reader.getStorage();
		if(list.size()==0){
			readerService.delete(readerId);
			return "redirect:/reader";
		} else {
			return "error1";
		}
     }
}
