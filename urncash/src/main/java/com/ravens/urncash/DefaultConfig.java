package com.ravens.urncash;

import org.modelmapper.ModelMapper;
import org.modelmapper.config.Configuration.AccessLevel;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

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

}
