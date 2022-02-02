package com.ravens.urncash.aeps.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class EncoreAepsResponseDto {

	private boolean status;
	private int statusCode;
	private String message;
	private String terminalId;
	private String date;
	private String time;
	private String transactionStatus;
	private String bankRRN;
	private String transactionType;
	private String EncoreTransactionId;
	private String merchantTxnId;
	private String transactionAmount;
	private String balanceAmount;
}
