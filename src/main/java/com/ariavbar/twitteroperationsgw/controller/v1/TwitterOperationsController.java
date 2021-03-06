package com.ariavbar.twitteroperationsgw.controller.v1;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ariavbar.twitteroperationsgw.dto.TwitterOperationsRequestDTO;
import com.ariavbar.twitteroperationsgw.dto.TwitterOperationsResponseDTO;
import com.ariavbar.twitteroperationsgw.exceptions.ApiErrorResponse;
import com.ariavbar.twitteroperationsgw.service.TwitterOperationsService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@RequestMapping("/v1")
public class TwitterOperationsController {
	
	private final TwitterOperationsService twitterOperationsService;
	
	@Operation(summary = "Tweet using app's twitter client",responses = { 
				@ApiResponse(responseCode = "201", description = "successfuly tweeted", content = @Content(schema = @Schema(implementation = TwitterOperationsResponseDTO.class))),
				@ApiResponse(responseCode = "400", description = "bad request", content = @Content(schema = @Schema(implementation = ApiErrorResponse.class)))})
	@PostMapping(path = "/tweet", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<TwitterOperationsResponseDTO> tweet(
	         @RequestBody @Valid TwitterOperationsRequestDTO twitterOperationsRequestDTO) {
		TwitterOperationsResponseDTO twitterOperationsResponseDTO =
	    		twitterOperationsService.tweet(twitterOperationsRequestDTO);
		
	    return new ResponseEntity<>(twitterOperationsResponseDTO, HttpStatus.CREATED);
	}
	
	@Operation(summary = "Show tweet by tweetId",responses = { 
			@ApiResponse(responseCode = "200", description = "successfuly fetched", content = @Content(schema = @Schema(implementation = TwitterOperationsResponseDTO.class))),
			@ApiResponse(responseCode = "404", description = "invalid or missing tweetId ", content = @Content(schema = @Schema(implementation = ApiErrorResponse.class)))})
	@GetMapping(path = "/show/{tweetId}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<TwitterOperationsResponseDTO> show(@PathVariable @NotNull Long tweetId) {
		TwitterOperationsResponseDTO twitterOperationsResponseDTO =
	    		twitterOperationsService.show(tweetId);
		
	    return new ResponseEntity<>(twitterOperationsResponseDTO, HttpStatus.OK);
	}
	
}
