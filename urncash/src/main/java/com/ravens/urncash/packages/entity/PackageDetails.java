package com.ravens.urncash.packages.entity;

import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;



import lombok.Data;

@Data
@Entity
@Table(name="package_details")
public class PackageDetails {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long packageDetailsId;
	
	@ManyToOne
	@JoinColumn(name="packageId", nullable=false)
	private PackageMaster packageMaster;
	
	@OneToOne
	@JoinColumn(name="slabDetailsId", nullable=false)
	private SlabDetails slabDetails;

	
	private Double charge;
	
	private String chargeType;
	
	private Double commision;
	
	private String commisionType;
}
