package com.ravens.urncash.api.entity;

import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import com.ravens.urncash.user.entity.ClientDetails;

import lombok.Data;

@Data
@Entity
@Table(name="api_master")
public class ApiMaster {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long apiId;
	
	private String apiName;
	
	private String apiType;
	
	private int activeStatus;
	
	@ManyToMany(mappedBy = "apiMasterList")
	Set<ClientDetails> clientList;
}
