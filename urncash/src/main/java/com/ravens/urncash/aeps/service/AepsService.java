package com.ravens.urncash.aeps.service;

import java.util.List;

import com.ravens.urncash.aeps.model.AepsBanksDTO;

public interface AepsService {
	
	public List<AepsBanksDTO> getDefaultBanksForAEPS();

}
