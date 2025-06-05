package com.dogImg.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dogImg.DogImageService;

@RestController
@RequestMapping("/api/v1")
public class DogController {
	
	@Autowired
	public DogImageService dogServ;
	
	@GetMapping("/fetchImage")
	public ResponseEntity<byte[]> fetchDogImage() {
		return dogServ.randomDogimageGenerator();
		
	}

}
