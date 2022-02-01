package com.ravens.urncash.user.entity;

import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.ravens.urncash.api.entity.ApiMaster;

import lombok.Data;

@Data
@Entity
@Table(name="client_details")
public class ClientDetails {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long clientId;
	
	@ManyToMany
	@JoinTable(
	  name = "ClientDetails_ApiMaster", 
	  joinColumns = @JoinColumn(name = "client_Id", referencedColumnName = "clientId"), 
	  inverseJoinColumns = @JoinColumn(name = "api_Id",referencedColumnName = "apiId"))
	 Set<ApiMaster> apiMasterList;
	
	@OneToMany(mappedBy="client")
    private Set<CustomerDetails> customerList;

}
