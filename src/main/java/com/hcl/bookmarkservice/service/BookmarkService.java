package com.hcl.bookmarkservice.service;

import java.util.List;

import com.hcl.bookmarkservice.model.*;

public interface BookmarkService {
	
	//This is an service that we need to implement in bookmarkserviceimpl class
	
	List<Bookmark> getAllJobDetails();
	
	boolean addJob(Bookmark bookmark);
	
	boolean addToBookmark(Bookmark bookmark);
	
	boolean removefromBookmark(Bookmark bookmark);

}
