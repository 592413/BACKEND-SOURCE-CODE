package com.ravens.urncash.aeps.service;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClientException;

import com.google.gson.Gson;
import com.ravens.urncash.ApiWebClient;
import com.ravens.urncash.aeps.entity.AepsBankDetails;
import com.ravens.urncash.aeps.entity.AepsResponse;
import com.ravens.urncash.aeps.entity.AepsUser;
import com.ravens.urncash.aeps.model.AepsBanksDTO;
import com.ravens.urncash.aeps.model.CommonAepsRequestDto;
import com.ravens.urncash.aeps.model.EncoreAepsRequestDto;
import com.ravens.urncash.aeps.model.EncoreAepsResponseDto;
import com.ravens.urncash.aeps.repository.AepsBankRepository;
import com.ravens.urncash.aeps.repository.AepsResponseRepository;
import com.ravens.urncash.aeps.repository.AepsUserRepository;
import com.ravens.urncash.aeps.utility.AepsConstants;
import com.ravens.urncash.aeps.utility.FingerCaptureParser;
import com.ravens.urncash.api.service.ApiService;
import com.ravens.urncash.common.util.GenerateRandomNumber;
import com.ravens.urncash.user.entity.CustomerDetails;
import com.ravens.urncash.user.service.CustomerService;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class AepsServiceImpl implements AepsService  {
	
	
	@Autowired
	ModelMapper modelMapper;
	
	@Autowired
	Gson gson;
	
	@Autowired
	AepsBankRepository aepsBankRepository;
	
	@Autowired
	AepsUserRepository aepsUserRepository;
	
	@Autowired
	CustomerService customerService;
	
	@Autowired
	ApiService apiService;
	
	@Autowired
	AepsResponseRepository aepsResponseRepository;
	
	@Autowired
	ApiWebClient apiWebClient;
	
	private final String baseUrl = apiWebClient.getHost()+apiWebClient.getAPI_PATH()+AepsConstants.AEPS_WEB_URL;

	@Override
	@Transactional
	public List<AepsBanksDTO> getDefaultBanksForAEPS() {
		
		List<AepsBankDetails> aepsBankList=(List<AepsBankDetails>) aepsBankRepository.findAll();
		
		List<AepsBanksDTO> bankDtoList=modelMapper.map(aepsBankList, new TypeToken<List<AepsBanksDTO>>() {}.getType());
		
		return bankDtoList;
	}


	@Override
	public void performAepsTransaction(CommonAepsRequestDto commonAepsRequestDto) {
		
		try {
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
		
		URI uri = new URI(baseUrl);
		HttpHeaders headers = new HttpHeaders();
		HttpEntity<EncoreAepsRequestDto> request = new HttpEntity<>(aepsRequestDto, headers);
		ResponseEntity<EncoreAepsResponseDto> encoreResponse = apiWebClient.getRestTemplate().postForEntity(uri, request, EncoreAepsResponseDto.class);
		
		AepsResponse aepsResponse=AepsResponse.builder()
				.apiId(2L)
				.status(encoreResponse.getBody().getStatusCode()==200?"SUCCESS":"FAILURE")
				.aepsResponse(gson.toJson(encoreResponse.getBody())).build();
		
		aepsResponseRepository.save(aepsResponse);

		
		}catch(URISyntaxException ex) {
			log.error("Exception in performAepsTransaction for creating URI"+ex.getMessage());
		}catch(RestClientException ex) {
			log.error("Exception in performAepsTransaction for Rest Call"+ex.getMessage());
		}catch(Exception ex) {
			log.error("Exception in performAepsTransaction"+ex.getMessage());
		}
		
	}


}
