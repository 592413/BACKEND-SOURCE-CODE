package com.ravens.urncash.aeps.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class BaseAepsRequestDto {

	private String aepsMode;
	
	private Double aepsAmount;
	
	private String biometricData;
	
	private String aepsCustomerAadhar;
	
	private String iin;
	
	private String longitude;
	
	private String latitude;
	
	private String aepsCustomerMobile;
	
	private Long aepsType;
}
