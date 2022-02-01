package com.ravens.urncash.user.repository;

import org.springframework.data.repository.CrudRepository;

import com.ravens.urncash.user.entity.CustomerDetails;

public interface CustomerDetailsRepository extends CrudRepository<CustomerDetails, Long> {
	
	public CustomerDetails findByCustomerId(Long customerId);
	
	

}
