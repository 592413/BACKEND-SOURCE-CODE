package com.ravens.urncash.business.entity;

import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.ravens.urncash.packages.entity.PackageMaster;

import lombok.Data;

@Data
@Entity
@Table(name="service_master")
public class ServiceMaster {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long serviceId;
	
	@OneToMany(mappedBy="service")
    private Set<PackageMaster> packageList;
	
	private String serviceName;
}
