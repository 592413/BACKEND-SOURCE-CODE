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

import com.ravens.urncash.api.entity.ApiClientMaster;
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
	
	@OneToMany(mappedBy="packageMaster")
    private Set<PackageDetails> packageDetails;
	
	@ManyToOne
	@JoinColumn(name="business_id",referencedColumnName = "businessId", nullable=false)
	private ApiClientMaster apiClient;
	
	
	private String packageId;
	
	private String packageName;
	
	private Long owner;
	
	
}
