package com.ravens.urncash.aeps.service;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ravens.urncash.aeps.entity.AepsBankDetails;
import com.ravens.urncash.aeps.entity.AepsUser;
import com.ravens.urncash.aeps.model.AepsBanksDTO;
import com.ravens.urncash.aeps.model.CommonAepsRequestDto;
import com.ravens.urncash.aeps.model.EncoreAepsRequestDto;
import com.ravens.urncash.aeps.repository.AepsBankRepository;
import com.ravens.urncash.aeps.repository.AepsUserRepository;
import com.ravens.urncash.aeps.utility.FingerCaptureParser;
import com.ravens.urncash.common.util.GenerateRandomNumber;
import com.ravens.urncash.user.entity.CustomerDetails;
import com.ravens.urncash.user.service.CustomerService;

@Service
public class AepsServiceImpl implements AepsService  {
	
	
	@Autowired
	ModelMapper modelMapper;
	
	@Autowired
	AepsBankRepository aepsBankRepository;
	
	@Autowired
	AepsUserRepository aepsUserRepository;
	
	@Autowired
	CustomerService customerService;


	@Override
	@Transactional
	public List<AepsBanksDTO> getDefaultBanksForAEPS() {
		
		List<AepsBankDetails> aepsBankList=(List<AepsBankDetails>) aepsBankRepository.findAll();
		
		List<AepsBanksDTO> bankDtoList=modelMapper.map(aepsBankList, new TypeToken<List<AepsBanksDTO>>() {}.getType());
		
		return bankDtoList;
	}


	@Override
	public void performAepsTransaction(CommonAepsRequestDto commonAepsRequestDto) {
		
		//This will come from Spring Security. Will implement later
		Long customerId=5L;
		
		//Find Customer From CustomerId
		
		CustomerDetails customer=customerService.getCustomerById(customerId);
		
		//Find Aeps User By Customer Id
		
		AepsUser aepsUser=aepsUserRepository.findByCustomer(customer);
		
		//Creating Some Important Data for FingPay Specific AEPS
		
		String deviceIMEI=FingerCaptureParser.captureResponse(commonAepsRequestDto.getBiometricData());
		String order_id=GenerateRandomNumber.generateIPtid("mobile");
		String date=GenerateRandomNumber.getCurrentDate();
		String time=GenerateRandomNumber.getCurrentTime();
		
		//Creating Encore Aeps Request For WebService Call
		EncoreAepsRequestDto aepsRequestDto=EncoreAepsRequestDto.builder()
				.AID(aepsUser.getAgentCode())
				.date(date)
				.deviceIMEI(deviceIMEI)
				.order_id(order_id)
				.time(time)
				.Username("bappa")
				.Password("Test")
				.commonAepsRequestDto(commonAepsRequestDto)
				.build();
		
		
	}

	
	/*
	 * 
	 * 
	 * 
	 * 
	 * RestTemplate restTemplate = new RestTemplate();
    final String baseUrl = "http://localhost:"+randomServerPort+"/employees/";
    URI uri = new URI(baseUrl);
    Employee employee = new Employee(null, "Adam", "Gilly", "test@email.com");
     
    HttpHeaders headers = new HttpHeaders();
    headers.set("X-COM-PERSIST", "true");    
    headers.set("X-COM-LOCATION", "USA");      
 
    HttpEntity<Employee> request = new HttpEntity<>(employee, headers);
     
    ResponseEntity<String> result = restTemplate.postForEntity(uri, request, String.class);*/
}
