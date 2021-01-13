package com.app.services;

import java.util.List;

import com.app.pojos.Blog;
import com.app.pojos.Tags;

public interface IBlogService {
	
	public List<Blog> getAllBlogs();
	public List<Blog> findByTag(Tags tag);
	public Blog findById(Integer id);
	public Blog add(Blog b);

}
