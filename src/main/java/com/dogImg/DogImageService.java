package com.dogImg;

import java.util.Map;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class DogImageService {

	
	private static final String dogUrl = "https://dog.ceo/api/breeds/image/random";
	
	public String randomDogimageGenerator() {
		RestTemplate restTemplate=new RestTemplate();
		Map response=restTemplate.getForObject(dogUrl, Map.class);
		return (String)response.get("message");
	}


}
