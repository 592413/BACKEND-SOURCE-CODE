package guru.springframework.msscbeerservice.web.client;

import static org.junit.jupiter.api.Assertions.*;

import java.util.UUID;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import guru.springframework.msscbeerservice.web.model.BeerDto;

@SpringBootTest
class BreweryClientTest {
	
	@Autowired
	BreweryClient breweryClient;

	@Test
	void testGetBeerById() {
		
		BeerDto beerDto= breweryClient.getBeerById(UUID.randomUUID());
		assertNotNull(beerDto);
		
	}

}
