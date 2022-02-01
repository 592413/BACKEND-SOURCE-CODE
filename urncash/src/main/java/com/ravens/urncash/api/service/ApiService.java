package com.ravens.urncash.api.service;

import java.net.URI;

import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;

public interface ApiService {

	public ResponseEntity<String> sendRequestToWebService(URI uri,HttpEntity<?> request);
}
