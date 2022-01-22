package guru.springframework.msscbrewery.web.controller;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import guru.springframework.msscbrewery.services.CustomerService;
import guru.springframework.msscbrewery.web.model.BeerDto;
import guru.springframework.msscbrewery.web.model.CustomerDto;


@RequestMapping("/api/v1/customer")
@RestController
public class CustomerController {
	
	@Autowired
	private  CustomerService customerService;
	
	@RequestMapping({"/customerId"})
	public ResponseEntity<CustomerDto> getCustomer(@PathVariable("customerId") UUID customerId){
		
			return new ResponseEntity<CustomerDto>(customerService.getCustomerById(customerId), HttpStatus.OK);
	}
	
	@PostMapping
    public ResponseEntity handlePost(CustomerDto customerDto) {
		CustomerDto savedDto=customerService.saveNewCustomer(customerDto);
    	HttpHeaders headers=new HttpHeaders();
    	headers.add("Location", "/api/v1/beer"+savedDto.getId().toString());
    	
    	return new ResponseEntity(headers,HttpStatus.CREATED);
    }
    
    @PutMapping("/{customerId}")
    public ResponseEntity handleUpdate(@PathVariable("customerId") UUID customerId,CustomerDto customerDto) {
    	
    	customerService.updateCustomer(customerId,customerDto);
    	
    	return new ResponseEntity(HttpStatus.NO_CONTENT);
    	
    }
    
    @DeleteMapping("/{customerId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteBeer(@PathVariable("customerId") UUID customerId) {
    	
    	customerService.deleteById(customerId);
    	
    }

}
