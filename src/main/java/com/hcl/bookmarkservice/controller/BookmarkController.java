package com.hcl.bookmarkservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.hcl.bookmarkservice.model.Bookmark;
import com.hcl.bookmarkservice.repository.BookmarkRepository;
import com.hcl.bookmarkservice.service.BookmarkService;
import com.hcl.bookmarkservice.service.BookmarkServiceImpl;


@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class BookmarkController {
	
	//Autowired is an annotation used to provide bean configurations
	@Autowired
	private BookmarkService bookmarkService;
	
	

	//This is a HTTP get method ,used to get our request from postman and which is nothing but an api
	@GetMapping("/api/v1/bookmarks/all")
	public ResponseEntity<?> getAllJobdetails(){
		return new ResponseEntity<>(bookmarkService.getAllJobDetails(),HttpStatus.OK);
	}
	
	
	//This is a HTTP post method
	@PostMapping("/api/v1/bookmarks/addjob")
	public ResponseEntity<?> addJob(
			@RequestBody Bookmark bookmark){
		bookmarkService.addJob(bookmark);
		return new ResponseEntity<>("New Job Details added",HttpStatus.CREATED);
	}
	
	@PutMapping("/api/v1/bookmarks/addtobookmark")
	public ResponseEntity<?> addBookToBookmark(@RequestBody Bookmark bookmark){
		bookmarkService.addToBookmark(bookmark);
		return new ResponseEntity<>("Job details added to bookmark",HttpStatus.OK);
	}
	
	@PutMapping("/api/v1/bookmarks/removefrombookmark")
	public ResponseEntity<?> removeBookFromBookmark(@RequestBody Bookmark bookmark){
		bookmarkService.removefromBookmark(bookmark);
		return new ResponseEntity<>("Book removed from bookmark",HttpStatus.OK);
	}


}
