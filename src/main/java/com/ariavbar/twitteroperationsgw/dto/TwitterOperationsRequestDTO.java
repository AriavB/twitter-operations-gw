package com.ariavbar.twitteroperationsgw.dto;

import javax.validation.constraints.NotNull;

import lombok.Data;

@Data
public class TwitterOperationsRequestDTO {
	
	@NotNull
	private String requestId;
	
}
