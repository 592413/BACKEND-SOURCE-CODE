package com.ravens.urncash.aeps.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;


@Data
@Entity
@Table(name="aepsbankdetail")
public class AepsBankDetails {

	@Id
	private Long id;
	private String bank_name;
	private String bank_id;
	private String iin;
}
