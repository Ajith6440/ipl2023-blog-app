package org.blog.service;

import java.util.List;
import java.util.Optional;

import org.blog.model.Post;
import org.blog.repository.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PostServiceImpl implements PostService {

	@Autowired
	private PostRepository postRepository;
	
	
	@Override
	public void addPost(Post post) {
		
	  this.postRepository.save(post);
	}

	@Override
	public List<Post> getAllPosts() {
		
		return this.postRepository.findAll();
	}

}
