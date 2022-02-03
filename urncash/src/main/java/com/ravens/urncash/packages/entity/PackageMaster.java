package com.ravens.urncash.packages.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.ravens.urncash.business.entity.ServiceMaster;
import com.ravens.urncash.user.entity.ClientDetails;

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
	
	private Long serviceId;
	
	private String packageId;
	
	private String packageName;
	
	private Long owner;
	
	
}
