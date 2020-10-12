package com.ariavbar.twitteroperationsgw.exceptions;

import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class ApiErrorResponse {
	
	private String message;
	
}
