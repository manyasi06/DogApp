package com.example.demo.controller;

import java.io.IOException;
import java.util.Base64;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.example.demo.model.DogPics;
import com.example.demo.services.DogPicsService;

@RestController
@RequestMapping(name = "/api")
public class DogPicsController {
	
	@Autowired
	DogPicsService photoService;
	
	@PostMapping("/photos/add")
	public String addPhoto(@RequestParam("title") String title, 
	  @RequestParam("image") MultipartFile image, Model model) 
	  throws IOException {
	    String id = photoService.addPhoto(title, image);
	    return "redirect:/photos/" + id;
	}
	
	@GetMapping("/photos/{id}")
	public String getPhoto(@PathVariable String id, Model model) {
	    DogPics photo = photoService.getPhoto(id);
	    model.addAttribute("title", photo.getTitle());
	    model.addAttribute("image", 
	      Base64.getEncoder().encodeToString(photo.getImage().getData()));
	    return "photos";
	}
}
