package com.java.SpringJobApp;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.java.SpringJobApp.Model.JobPost;
import com.java.SpringJobApp.Service.JobService;


@RestController	
public class JobRestController {
	
	@Autowired
	private JobService service;
	
	
	

	@GetMapping("jobPosts")
	public List<JobPost> getAllJobs() {
		return service.getAllJobs();
		
	}
	
	
	
	
	
	@GetMapping("/jobPost/{postId}")
	public JobPost getJob(@PathVariable int postId) {
		return service.getJob(postId);
	}
	
	
	

	@PostMapping("jobPost")
	public JobPost addJob(@RequestBody JobPost jobPost) {
		service.addJob(jobPost);
		return service.getJob(jobPost.getPostId());
	}
	
	
	
	@PutMapping("jobPost")
	public JobPost updateJob(@RequestBody JobPost jobPost) {
		service.updateJob(jobPost);
		return service.getJob(jobPost.getPostId());
	}
	
	
	
	
	@DeleteMapping("jobPost/{postId}")
	public String deleteJob(@PathVariable int postId)
	{
		service.deleteJob(postId);
		return "Deleted";
	}
	
	
	@GetMapping("load")
	public String loadData() {
		service.load();
		return "success";
	}
	
	@GetMapping("jobposts/keyword/{keyword}")
	public List<JobPost> searchByKeyWord(@PathVariable("keyword") String keyword){
		return service.search(keyword);
	}

}