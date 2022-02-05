package com.ravens.urncash.api.entity;

import java.util.Set;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.ravens.urncash.business.entity.ServiceMaster;
import com.ravens.urncash.user.entity.ClientDetails;

import lombok.Data;

@Data
@Entity
@Table(name="api_client_master")
public class ApiClientMaster {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@ManyToOne
    @JoinColumn(name = "service_id", referencedColumnName = "serviceId")
    private ServiceMaster serviceMaster;
	
	@ManyToOne
    @JoinColumn(name = "client_id", referencedColumnName = "clientId")
    private ClientDetails client;
	
	@ManyToOne
    @JoinColumn(name = "api_id", referencedColumnName = "apiId")
    private ApiMaster api;
	
	private String businessId;
	
	private Integer status;

}
