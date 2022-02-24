package guru.springframework.msscbeerservice.web.client;

import static org.junit.jupiter.api.Assertions.*;

import java.net.URI;
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
	
	 @Test
	    void testSaveNewBeer() {
	        //given
	        BeerDto beerDto = BeerDto.builder().beerName("New Beer").build();

	        URI uri = breweryClient.saveNewBeer(beerDto);

	        assertNotNull(uri);

	        System.out.println(uri.toString());

	    }

}
