package com.ravens.urncash.aeps.service;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ravens.urncash.aeps.entity.AepsBankDetails;
import com.ravens.urncash.aeps.model.AepsBanksDTO;
import com.ravens.urncash.aeps.repository.AepsBankRepository;

@Service
public class AepsServiceImpl implements AepsService  {
	
	
	@Autowired
	ModelMapper modelMapper;
	
	@Autowired
	AepsBankRepository aepsBankRepository;


	@Override
	@Transactional
	public List<AepsBanksDTO> getDefaultBanksForAEPS() {
		
		List<AepsBankDetails> aepsBankList=(List<AepsBankDetails>) aepsBankRepository.findAll();
		
		List<AepsBanksDTO> bankDtoList=modelMapper.map(aepsBankList, new TypeToken<List<AepsBanksDTO>>() {}.getType());
		
		return bankDtoList;
	}

}
