package com.hcl.bookmarkservice.repository;






import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.hcl.bookmarkservice.model.Bookmark;


@Repository
public interface BookmarkRepository extends MongoRepository<Bookmark,String> {
	
	//This repository used to retrieve information mongo database -> nosql
	
	
}
