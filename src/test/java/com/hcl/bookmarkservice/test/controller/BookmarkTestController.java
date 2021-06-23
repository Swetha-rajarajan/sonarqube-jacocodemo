package com.hcl.bookmarkservice.test.controller;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.hcl.bookmarkservice.controller.BookmarkController;
import com.hcl.bookmarkservice.model.Bookmark;
import com.hcl.bookmarkservice.repository.BookmarkRepository;
import com.hcl.bookmarkservice.service.BookmarkService;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

@SpringBootTest
@AutoConfigureMockMvc
public class BookmarkTestController {
	
	 	@Autowired
	    private MockMvc mockMvc;
	 	private Bookmark bookmark;

	 	@MockBean
	    private BookmarkService bookmarkService;

	    @InjectMocks
	    private BookmarkController bookmarkController;

	    private List<Bookmark> bookmarkList;
	    @Autowired
	    private BookmarkRepository bookmarkRepository;

	    @BeforeEach
	    public void setUp()
	    {
	    	MockitoAnnotations.initMocks(this);
	        mockMvc = MockMvcBuilders.standaloneSetup(bookmarkController).build();
	        bookmark = new Bookmark();
	        bookmark.setCompanyname("hcl");
	        bookmark.setIsbookmark(true);
	        bookmark.setJobid("108");
	        bookmark.setJoblocation("chennai");
	        bookmark.setJobrole("software engineer");

	       	bookmarkList = new ArrayList<>();
	        bookmarkList.add(bookmark);


	    }

	    @Test
	    public void createJobSuccess() throws Exception
	    {
	        when(bookmarkService.addJob(any())).thenReturn(true);
	        mockMvc.perform(MockMvcRequestBuilders.post("/api/v1/bookmarks/addjob").contentType
	                (MediaType.APPLICATION_JSON)
	                .content(asJsonString(bookmark)))
	                .andExpect(MockMvcResultMatchers.status().isCreated())
	                .andDo(MockMvcResultHandlers.print());

	    }

	    @Test
	    public void createJobFailure() throws Exception
	    {
	        when(bookmarkService.addJob(any())).thenReturn(false);
	        mockMvc.perform(MockMvcRequestBuilders.post("/api/v1/bookmarks/addjob").
	                contentType(MediaType.APPLICATION_JSON)
	                .content(asJsonString(bookmark)))
	                .andExpect(MockMvcResultMatchers.status().is2xxSuccessful())
	                .andDo(MockMvcResultHandlers.print());


	    }
	    
	    @Test
	    public void addToBookmarkFailure() throws Exception
	    {
	        when(bookmarkService.addToBookmark(any())).thenReturn(false);
	        mockMvc.perform(MockMvcRequestBuilders.put("/api/v1/bookmarks/addtobookmark").contentType
	                (MediaType.APPLICATION_JSON)
	                .content(asJsonString(bookmark)))
	                .andExpect(MockMvcResultMatchers.status().is2xxSuccessful())
	                .andDo(MockMvcResultHandlers.print());
	    }
	    
	    @Test
	    public void removedfromBookmarkFailure() throws Exception
	    {
	        when(bookmarkService.removefromBookmark(any())).thenReturn(false);
	        mockMvc.perform(MockMvcRequestBuilders.put("/api/v1/bookmarks/removefrombookmark").
	                contentType(MediaType.APPLICATION_JSON)
	                .content(asJsonString(bookmark)))
	                .andExpect(MockMvcResultMatchers.status().is2xxSuccessful())
	                .andDo(MockMvcResultHandlers.print());


	    }
	    
	    @Test
	    public void removedfromBookmarkSuccess() throws Exception
	    {
	        when(bookmarkService.removefromBookmark(any())).thenReturn(true);
	        mockMvc.perform(MockMvcRequestBuilders.put("/api/v1/bookmarks/removefrombookmark").
	                contentType(MediaType.APPLICATION_JSON)
	                .content(asJsonString(bookmark)))
	                .andExpect(MockMvcResultMatchers.status().is2xxSuccessful())
	                .andDo(MockMvcResultHandlers.print());
	    
	    }
	    
	    @Test
	    public void addToBookmarkSuccess() throws Exception
	    {
	        when(bookmarkService.addToBookmark(any())).thenReturn(true);
	        mockMvc.perform(MockMvcRequestBuilders.put("/api/v1/bookmarks/addtobookmark").contentType
	                (MediaType.APPLICATION_JSON)
	                .content(asJsonString(bookmark)))
	                .andExpect(MockMvcResultMatchers.status().is2xxSuccessful())
	                .andDo(MockMvcResultHandlers.print());
	    }
	    
	    private static String asJsonString(final Object obj) {
	        try {
	            return new ObjectMapper().writeValueAsString(obj);
	        } catch (Exception e) {
	            throw new RuntimeException(e);
	        }
	    }
}



 