package com.app.daos;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.app.pojos.Blog;
import com.app.pojos.Tags;


public interface BlogRepo extends JpaRepository<Blog, Integer>{
	List<Blog> findByTags(Tags tag);
	
}
