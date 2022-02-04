package com.ravens.urncash.packages.entity;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.ravens.urncash.api.entity.ApiMaster;
import com.ravens.urncash.business.entity.ServiceMaster;
import com.ravens.urncash.user.entity.CustomerDetails;

import lombok.Data;

@Data
@Entity
@Table(name="package_master")
public class PackageMaster {

	@Id
	private Long id;
	
	@ManyToOne
	@JoinColumn(name="service_id", referencedColumnName = "serviceId",  nullable=false)
	private ServiceMaster service;
	
	@OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "api_id", referencedColumnName = "apiId",nullable=false)
    private ApiMaster api;
	
	@OneToMany(mappedBy="packageMaster")
    private Set<PackageDetails> packageDetails;
	
	@ManyToMany(mappedBy = "packageMasterList")
	Set<CustomerDetails> customerDetailsList;
	
	
	private String packageId;
	
	private String packageName;
	
	private Long owner;
	
	
}
