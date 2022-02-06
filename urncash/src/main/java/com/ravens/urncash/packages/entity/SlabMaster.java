package com.ravens.urncash.packages.entity;


import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.ravens.urncash.api.entity.ApiClientMaster;
import com.ravens.urncash.api.entity.ApiMaster;
import com.ravens.urncash.user.entity.ClientDetails;

import lombok.Data;

@Data
@Entity
@Table(name="slab_master")
public class SlabMaster {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long slabId;
	
	@OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "business_id", referencedColumnName = "businessId")
    private ApiClientMaster apiClient;
	
	@OneToMany(mappedBy="slab")
    private Set<SlabDetails> slabDetailsList;
}
