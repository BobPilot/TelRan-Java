package main.java.controller;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.Arrays;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.http.StreamingHttpOutputMessage.Body;
import org.springframework.web.client.RestTemplate;

import main.java.model.Post;

public class SptingAppl {

	public static void main(String[] args) throws URISyntaxException {

		RestTemplate restTemplate = new RestTemplate();
		
		String url = "https://jsonplaceholder.typicode.com/posts";
		HttpHeaders headers = new HttpHeaders();
		HttpEntity<String> requestEntity = new HttpEntity<>(headers);
		ResponseEntity<Post[]> response = restTemplate.exchange(url, HttpMethod.GET, requestEntity, Post[].class);
		
		//System.out.println(Arrays.toString(response.getBody()));
		System.out.println(response.getHeaders().getContentType());
		
		url += "/4";
		ResponseEntity<Post> post4 = restTemplate.exchange(url, HttpMethod.GET, requestEntity, Post.class);
		
		System.out.println(post4.getBody());
		 
		System.out.println(response.getStatusCode());
		
		
		
	}

}
