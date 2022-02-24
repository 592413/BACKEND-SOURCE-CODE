package guru.springframework.msscbeerservice.web.client;

import java.net.URI;
import java.util.UUID;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import guru.springframework.msscbeerservice.web.model.BeerDto;

@Component
@ConfigurationProperties(value="sfg.brewery",ignoreUnknownFields = false)
public class BreweryClient {
	
	private String apiHost;
	
	public final String BEER_PATH_V1="/api/v1/beer/";
	
	private final RestTemplate restTemplate;
	
	
	public BreweryClient(RestTemplateBuilder restTemplateBuilder) {
		this.restTemplate = restTemplateBuilder.build();
	}


	public BeerDto getBeerById(UUID uuid) {
		
		return	(BeerDto) restTemplate.getForObject(apiHost+BEER_PATH_V1+uuid.toString(), BeerDto.class);
	
	}

	
	public URI saveNewBeer(BeerDto beerDto){
        return restTemplate.postForLocation(apiHost + BEER_PATH_V1, beerDto);
    }

	public void setApiHost(String apiHost) {
		this.apiHost = apiHost;
	}
	
	

}
