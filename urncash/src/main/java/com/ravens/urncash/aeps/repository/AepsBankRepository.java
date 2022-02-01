package com.ravens.urncash.aeps.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.ravens.urncash.aeps.entity.AepsBankDetails;

@Repository
public interface AepsBankRepository extends CrudRepository<AepsBankDetails, Long> {

}
