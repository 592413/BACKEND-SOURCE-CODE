package com.ravens.urncash;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
@ConfigurationProperties(value="api.urncash",ignoreUnknownFields = false)
public class ApiWebClient {
	
	private String host;
	
	public final String API_PATH="/api/v1/rest/";
	
	private final RestTemplate restTemplate;
	
	
	public ApiWebClient(RestTemplateBuilder restTemplateBuilder) {
		this.restTemplate = restTemplateBuilder.build();
	}



	public void setHost(String host) {
		this.host = host;
	}
	
	public String getHost() {
		return host;
	}
	
	public String getAPI_PATH() {
		return API_PATH;
	}



	public RestTemplate getRestTemplate() {
		return restTemplate;
	}
	
	
	

}
