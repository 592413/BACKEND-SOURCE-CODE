package com.ravens.urncash;

import org.modelmapper.ModelMapper;
import org.modelmapper.config.Configuration.AccessLevel;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

@Configuration
public class DefaultConfig {
	
	
	@Bean
	public ModelMapper getModelMapper() {
		ModelMapper mapper=new ModelMapper();
		mapper.getConfiguration()
		.setMatchingStrategy(MatchingStrategies.STRICT)
		.setFieldMatchingEnabled(true).setFieldAccessLevel(AccessLevel.PRIVATE);
		
		
		return mapper;
	}
	
	@Bean
	public Gson getGson() {
		 Gson gson = new GsonBuilder().create(); 
		 return gson;
	}

}
