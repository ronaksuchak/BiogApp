package com.app.services;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.daos.BlogRepo;
import com.app.pojos.Blog;
import com.app.pojos.Tags;


@Service
@Transactional
public class BlogServiceImpl implements IBlogService{

	@Autowired
	private BlogRepo repo;
	
	@Override
	public List<Blog> getAllBlogs() {
		return repo.findAll();
	}

	@Override
	public List<Blog> findByTag(Tags tag) {
		return repo.findByTags(tag);
	}

	@Override
	public Blog findById(Integer id) {
		return repo.getOne(id);
	}

	@Override
	public Blog add(Blog b) {
		return repo.save(b);
	}

}
