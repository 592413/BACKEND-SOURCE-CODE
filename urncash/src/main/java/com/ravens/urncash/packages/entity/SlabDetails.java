package com.ravens.urncash.packages.entity;

import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.ravens.urncash.user.entity.ClientDetails;

import lombok.Data;

@Data
@Entity
@Table(name="slab_details")
public class SlabDetails {
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long slabDetailsId;
	
	@ManyToOne
	@JoinColumn(name="slabId", nullable=false)
	private SlabMaster slab;
	
	@OneToOne(mappedBy="slabDetails")
    private PackageDetails packageDetail;
	
	private Double lowerSlab;
	
	private Double upperSlab;
	

}
