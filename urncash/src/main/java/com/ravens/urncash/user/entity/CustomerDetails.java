package com.ravens.urncash.user.entity;

import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.ravens.urncash.api.entity.ApiMaster;

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

}
