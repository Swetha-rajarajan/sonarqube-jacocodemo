package com.hcl.bookmarkservice.test.service;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.hcl.bookmarkservice.model.Bookmark;
import com.hcl.bookmarkservice.repository.BookmarkRepository;
import com.hcl.bookmarkservice.service.BookmarkServiceImpl;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;


public class BookmarkTestService {

	@MockBean
	private Bookmark bookmark;
    
    @Mock
    private BookmarkRepository bookRepository;
    @InjectMocks
    private BookmarkServiceImpl bookmarkServiceImpl;
    private List<Bookmark> bookmarklist = null;
	
	@BeforeEach
	public void setUp() throws Exception {


        MockitoAnnotations.initMocks(this);
        
        bookmark = new Bookmark();
        bookmark.setCompanyname("hcl");
        bookmark.setIsbookmark(true);
        bookmark.setJobid("108");
        bookmark.setJoblocation("chennai");
        bookmark.setJobrole("software engineer");

       	bookmarklist = new ArrayList<>();
        bookmarklist.add(bookmark);

       
    }
	
	 @Test
	 public void insertJobSuccess() {
	        when(bookRepository.insert((Bookmark)any())).thenReturn(bookmark);
	        boolean status = bookmarkServiceImpl.addJob(bookmark);
	        assertEquals(true, status);
	      
	    }
 
	 @Test
	 public void insertJobFailure() {
	        when(bookRepository.insert((Bookmark)any())).thenReturn(null);
	        boolean status = bookmarkServiceImpl.addJob(bookmark);
	        assertEquals(true, status);
	    }
	 
	 
	 



}

