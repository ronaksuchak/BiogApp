package com.app.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.pojos.Blog;
import com.app.services.IBlogService;

@RestController
@RequestMapping("/Blog")
public class BlogController {
	@Autowired
	private IBlogService service;
	public BlogController() {
		System.out.println("in Blog ctor");
	}

	@GetMapping
	public ResponseEntity<?> test() {
		String msg = "it works";
		return new ResponseEntity<>(msg, HttpStatus.OK);
	}

	@GetMapping("/all")
	public ResponseEntity<?> getAllPosts() {
		List<Blog> blogs = service.getAllBlogs();
		if(blogs.isEmpty()) {
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<>(blogs,HttpStatus.OK);
	}

}
