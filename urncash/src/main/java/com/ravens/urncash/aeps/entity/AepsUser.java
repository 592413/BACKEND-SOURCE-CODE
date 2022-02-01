package com.ravens.urncash.aeps.entity;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.ravens.urncash.api.entity.ApiMaster;
import com.ravens.urncash.user.entity.CustomerDetails;

import lombok.Data;

@Data
@Entity
@Table(name="aeps_user")
public class AepsUser {

	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "customer_id", referencedColumnName = "customerId")
    private CustomerDetails customer;
	
	
	@OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "api_id", referencedColumnName = "apiId")
    private ApiMaster api;
	
	private String agentCode;
}
