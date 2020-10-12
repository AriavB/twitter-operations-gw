package com.ariavbar.twitteroperationsgw.controller.v1;

import javax.validation.Valid;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ariavbar.twitteroperationsgw.dto.TwitterOperationsRequestDTO;
import com.ariavbar.twitteroperationsgw.dto.TwitterOperationsResponseDTO;
import com.ariavbar.twitteroperationsgw.service.TwitterOperationsService;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@RequestMapping("/v1")
public class TwitterOperationsController {
	
	private final TwitterOperationsService twitterOperationsService;
	
	@PostMapping(path = "/tweet", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<TwitterOperationsResponseDTO> tweet(
	         @RequestBody @Valid TwitterOperationsRequestDTO twitterOperationsRequestDTO) {
		TwitterOperationsResponseDTO twitterOperationsResponseDTO =
	    		twitterOperationsService.tweet(twitterOperationsRequestDTO);
		
	    return new ResponseEntity<>(twitterOperationsResponseDTO, HttpStatus.CREATED);
	}
	
}
