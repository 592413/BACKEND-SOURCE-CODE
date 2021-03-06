package guru.springframework.msscbeerservice.web.controller;



import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import java.util.UUID;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import guru.springframework.msscbeerservice.services.BeerService;
import guru.springframework.msscbeerservice.web.model.BeerDto;


@WebMvcTest(BeerController.class)
class BeerControllerTest {
	
	@Autowired
    MockMvc mockMvc;
	
	@Autowired
    ObjectMapper objectMapper;
	
	@MockBean
    BeerService beerService;

	@Test
	void getBeerById() throws Exception {
		
		//given(beerService.getById(any(), anyBoolean())).
		mockMvc.perform(get("/api/v1/beer/" + UUID.randomUUID().toString()).accept(MediaType.APPLICATION_JSON))
        .andExpect(status().isOk());
	}
	
	@Test
	void saveNewBeer() throws Exception {
		
		BeerDto beerDto=BeerDto.builder().build();
		String beerDtoJson=objectMapper.writeValueAsString(beerDto);
		mockMvc.perform(post("/api/v1/beer/")
				.contentType(MediaType.APPLICATION_JSON)
				.content(beerDtoJson))
		.andExpect(status().isCreated());
		
	}
	
	void updateBeerById() throws Exception {
		BeerDto beerDto=BeerDto.builder().build();
		String beerDtoJson=objectMapper.writeValueAsString(beerDto);
		mockMvc.perform(put("/api/v1/beer/"+ UUID.randomUUID().toString())
				.contentType(MediaType.APPLICATION_JSON)
				.content(beerDtoJson))
		.andExpect(status().isNoContent());
		
		}
	}