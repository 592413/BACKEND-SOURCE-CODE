package com.ravens.urncash.packages.entity;

import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.ravens.urncash.api.entity.ApiClientMaster;
import com.ravens.urncash.user.entity.CustomerDetails;

import lombok.Data;

@Data
@Entity
@Table(name="package_customer")
public class CustomerPackage {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@ManyToOne
	@JoinColumn(name="package_id",referencedColumnName = "packageId", nullable=false)
	private PackageMaster packageMaster;
	
	@ManyToOne
	@JoinColumn(name="customer_id",referencedColumnName = "customerId", nullable=false)
	private CustomerDetails customer;
	
	
}
