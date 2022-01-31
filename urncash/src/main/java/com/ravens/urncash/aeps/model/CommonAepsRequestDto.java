package com.ravens.urncash.aeps.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper=false)
public class CommonAepsRequestDto extends BaseAepsRequestDto {
	
	private Long apiId;
	

}
