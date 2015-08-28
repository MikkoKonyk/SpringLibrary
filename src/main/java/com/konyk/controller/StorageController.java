package com.konyk.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.konyk.model.Reader;
import com.konyk.model.Storage;
import com.konyk.service.ReaderService;
import com.konyk.service.StorageService;

@Controller
public class StorageController {

		@Autowired
		private StorageService storageService;
		
		@Autowired
		private ReaderService readerService;
		
		@RequestMapping(value = "/storage/issue/{copyId}")
	    public String issueBook(@PathVariable("copyId") Integer copyId, Model model) {
			model.addAttribute("storage", storageService.getStorageById(copyId));
			model.addAttribute("storageList", storageService.getAllStorages());
			model.addAttribute("readerList", readerService.getAllReaders());
			return "storage";
		}
		
		@RequestMapping(value = "/storage/return/{copyId}")
	    public String returnBook(@PathVariable("copyId") Integer copyId, Model model) {
			Storage storage =  storageService.getStorageById(copyId);
			storage.setDateTaken(null);
			storage.setDateToReturn(null);
			storage.setAvailable("YES");	
			storage.setReader(null);
			storageService.edit(storage);
			return "redirect:/storage";
		}
		
		@RequestMapping(value = "/storage/edit", method = RequestMethod.POST)
	    public String addBook(@ModelAttribute("storage") Storage storage, Model model) {
			Reader reader = readerService.getReaderById(storage.getReader().getReaderId());	
				if(reader!=null){
					List<Storage> list = reader.getStorage();
					int newBookId =  storage.getBook().getBookId();
					int existingBookId = 0;
					for (Storage storageEntry : list) {
						existingBookId= storageEntry.getBook().getBookId();
						if(newBookId==existingBookId){
							return "error2";
							}
						}
					} 
				storage.setReader(reader);
				reader.getStorage().add(storage);
				storageService.edit(storage);
				return "redirect:/storage";
		}
}
