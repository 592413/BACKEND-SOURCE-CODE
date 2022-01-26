package com.ravens.urncash.aeps.repository;

import org.springframework.data.repository.CrudRepository;

import com.ravens.urncash.aeps.entity.AepsBankDetails;

public interface AepsBankRepository extends CrudRepository<AepsBankDetails, Long> {

}
