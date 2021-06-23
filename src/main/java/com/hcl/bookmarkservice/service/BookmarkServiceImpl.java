package com.hcl.bookmarkservice.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hcl.bookmarkservice.model.*;

import com.hcl.bookmarkservice.repository.BookmarkRepository;

@Service
public class BookmarkServiceImpl implements BookmarkService{
	
	
	@Autowired
	BookmarkRepository bookmarkRepository;
	

	public BookmarkServiceImpl(BookmarkRepository bookmarkRepository) {
	    this.bookmarkRepository = bookmarkRepository;
	}

	
	public List<Bookmark> getAllJobDetails() {
		// TODO Auto-generated method stub
		return bookmarkRepository.findAll();
	}

	
	public boolean addJob(Bookmark bookmark) {
		// TODO Auto-generated method stub
		bookmarkRepository.save(bookmark);
		return true;
	}

	
	public boolean addToBookmark(Bookmark bookmark) {
		// TODO Auto-generated method stub
		Bookmark job1 = bookmarkRepository.findById(bookmark.getJobid()).get();
	    job1.setIsbookmark(true);
		System.out.println(bookmarkRepository.save(job1));
		return true;
	}

	
	public boolean removefromBookmark(Bookmark bookmark) {
		// TODO Auto-generated method stub
		/*System.out.println(bookmark.getJobrole());
		Bookmark job1 = bookmarkRepository.findById(bookmark.getJobid()).get();
		job1.setIsbookmark(false);
		System.out.println("ssss"+bookmarkRepository.save(job1));
		System.out.println(bookmarkRepository.findAll().get(0).isIsbookmark());
		return true;*/
		bookmarkRepository.delete(bookmark);
		return true;
	}

	


	
}
