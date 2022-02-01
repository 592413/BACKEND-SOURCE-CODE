package com.ravens.urncash.aeps.service;

import java.util.List;

import com.ravens.urncash.aeps.model.AepsBanksDTO;
import com.ravens.urncash.aeps.model.CommonAepsRequestDto;

public interface AepsService {
	
	public List<AepsBanksDTO> getDefaultBanksForAEPS();
	
	public void performAepsTransaction(CommonAepsRequestDto commonAepsRequestDto);

}
