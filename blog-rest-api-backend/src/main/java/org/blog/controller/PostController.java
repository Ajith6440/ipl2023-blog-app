package org.blog.controller;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.blog.model.Post;
import org.blog.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;


@CrossOrigin(origins = "http://localhost:4200/")
@RestController
@RequestMapping("/api/blog/")
public class PostController {

	@Autowired
	private PostService service;
	
	
	@PostMapping("/post")  //localhost:8080/api/blog
	public ResponseEntity<Map<String,String>> addPost(
			@RequestParam("postId")long postId,
			@RequestParam("postTitle")String postTitle,
			@RequestParam("postContent")String postContent,
			@RequestParam("postImage")MultipartFile postImage) throws IOException
	{
		Post post=new Post();
		post.setPostId(postId);
		post.setPostTitle(postTitle);
		post.setPostContent(postContent);
		post.setPostImage(postImage.getBytes());
		this.service.addPost(post);
		
		Map<String,String> response=new HashMap<String,String>();
		response.put("status", "success");
		response.put("message", "Post added!!");
		
@GetMapping("/posts")
	public ResponseEntity<List<Post>> getAllPosts()
	{
		return new ResponseEntity<List<Post>>(this.service.getAllPosts(), HttpStatus.OK);
	}
	
	
}

