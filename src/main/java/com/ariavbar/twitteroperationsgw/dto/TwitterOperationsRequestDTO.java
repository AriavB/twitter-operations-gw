package com.ariavbar.twitteroperationsgw.dto;

import javax.validation.constraints.NotNull;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class TwitterOperationsRequestDTO {
	
	@NotNull
	private String requestId;
	
}
