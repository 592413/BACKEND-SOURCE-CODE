package com.ravens.urncash.aeps.controller;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ravens.urncash.aeps.model.AepsBanksDTO;
import com.ravens.urncash.aeps.model.CommonAepsRequestDto;
import com.ravens.urncash.aeps.service.AepsService;

@RestController
@RequestMapping("/api/v1/aeps")
public class AepsController {
	
	private final AepsService aepsService;
	
	public AepsController(AepsService aepsService) {
		this.aepsService=aepsService;
	}
	
	
	@GetMapping({"/{getAepsBanks}"})
    public ResponseEntity<List<AepsBanksDTO>> getAepsBanks(){

        return new ResponseEntity<>(aepsService.getDefaultBanksForAEPS(), HttpStatus.OK);
    }
	
	@PostMapping({"/performAeps"})
	public void performAepsTransaction(@RequestBody CommonAepsRequestDto commonAepsRequestDto) {
		
		
		
	}


}
