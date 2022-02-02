package com.ravens.urncash.aeps.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.ravens.urncash.aeps.entity.AepsResponse;

@Repository
public interface AepsResponseRepository extends CrudRepository<AepsResponse, Long> {

}
