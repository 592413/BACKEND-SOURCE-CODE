package com.ravens.urncash.user.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ravens.urncash.user.entity.CustomerDetails;
import com.ravens.urncash.user.repository.CustomerDetailsRepository;


@Service
public class CustomerServiceImpl implements CustomerService {

	@Autowired
	CustomerDetailsRepository customerDetailsRepository;
	
	
	@Override
	public CustomerDetails getCustomerById(Long customerId) {
		
		return customerDetailsRepository.findByCustomerId(customerId);
	}

}
