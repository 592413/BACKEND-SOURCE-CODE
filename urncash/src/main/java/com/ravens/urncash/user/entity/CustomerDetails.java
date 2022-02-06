package com.ravens.urncash.user.entity;

import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.ravens.urncash.api.entity.ApiMaster;
import com.ravens.urncash.packages.entity.CustomerPackage;
import com.ravens.urncash.packages.entity.PackageMaster;
import com.ravens.urncash.packages.entity.SlabDetails;

import lombok.Data;

@Data
@Entity
@Table(name="customer_details")
public class CustomerDetails {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long customerId;
	
	 @ManyToOne
	 @JoinColumn(name="clientId", nullable=false)
	 private ClientDetails client;

	 @OneToMany(mappedBy="customer")
	 private Set<CustomerPackage> customerPackageList;
}
