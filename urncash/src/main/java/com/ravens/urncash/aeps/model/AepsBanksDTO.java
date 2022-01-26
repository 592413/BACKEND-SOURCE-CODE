package com.ravens.urncash.aeps.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class AepsBanksDTO {
	
	private Long id;
	private String bank_name;
	private String bank_id;
	private String iin;
}
