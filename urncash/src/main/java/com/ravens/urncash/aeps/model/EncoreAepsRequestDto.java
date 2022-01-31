package com.ravens.urncash.aeps.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper=true)
@Builder
public class EncoreAepsRequestDto extends BaseAepsRequestDto {
	
	private String date;
	private String time;
	private String order_id;
	private String deviceIMEI;
	private String Username;
	private String Password;
	private String AID;

}
