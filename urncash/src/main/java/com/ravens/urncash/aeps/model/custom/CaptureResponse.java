package com.ravens.urncash.aeps.model.custom;

import lombok.Data;
import lombok.ToString;

@Data
@ToString
public class CaptureResponse {

	private String PidDatatype;
	private String Piddata;
	private String ci;
	private String dc;
	private String dpID;
	private String errCode;
	private String errInfo;
	private String fType;
	private String hmac;
	private String iCount;
	private String mc;
	private String mi;
	private String nmPoints;
	private String pCount;
	private String pType;
	private String qScore;
	private String rdsID;
	private String rdsVer;
	private String sessionKey;
	private String fCount;
}
