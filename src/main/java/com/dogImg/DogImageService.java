package com.dogImg;

import java.util.Map;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class DogImageService {

	
	private static final String dogUrl = "https://dog.ceo/api/breeds/image/random";
	
	public ResponseEntity<byte[]> randomDogimageGenerator() {
		RestTemplate restTemplate=new RestTemplate();
		Map response=restTemplate.getForObject(dogUrl, Map.class);
		String imageUrl=(String) response.get("message");
		
		
		ResponseEntity<byte[]> imageResponse=restTemplate.getForEntity(imageUrl,byte[].class );
		
		HttpHeaders http=new HttpHeaders();
		http.setContentType(detectionMediaType(imageUrl));
		return new ResponseEntity<byte[]>(imageResponse.getBody(),http,HttpStatus.OK);
		
	}
	
	private MediaType detectionMediaType(String imageUrl) {
		if(imageUrl.endsWith(".png")) {
			return MediaType.IMAGE_PNG;
		}else if(imageUrl.endsWith(".jpeg")||imageUrl.endsWith(".jpg")) {
			return MediaType.IMAGE_JPEG;
		}else if(imageUrl.endsWith(".gif")) {
			return MediaType.IMAGE_GIF;
		}else {
			return MediaType.APPLICATION_OCTET_STREAM;
		}
	}


}
