package com.ravens.urncash.user.service;

import com.ravens.urncash.user.entity.CustomerDetails;

public interface CustomerService {
	
   public CustomerDetails getCustomerById(Long customerId);	

}
