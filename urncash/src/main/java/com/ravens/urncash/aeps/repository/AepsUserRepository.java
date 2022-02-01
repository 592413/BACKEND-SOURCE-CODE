package com.ravens.urncash.aeps.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.ravens.urncash.aeps.entity.AepsUser;
import com.ravens.urncash.user.entity.CustomerDetails;

@Repository
public interface AepsUserRepository extends CrudRepository<AepsUser, Long>{
	
	public AepsUser findByCustomer(CustomerDetails customer);

}
