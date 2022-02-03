package com.ravens.urncash.packages.entity;

import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

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
	@JoinColumn(name="serviceId", nullable=false)
	private ServiceMaster service;
	
	@OneToMany(mappedBy="packageMaster")
    private Set<PackageDetails> packageDetails;
	
	@ManyToMany(mappedBy = "packageMasterList")
	Set<CustomerDetails> customerDetailsList;
	
	private Long serviceId;
	
	private String packageId;
	
	private String packageName;
	
	private Long owner;
	
	
}
