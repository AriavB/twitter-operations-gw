package com.ariavbar.twitteroperationsgw.dto;

import com.fasterxml.jackson.annotation.JsonInclude;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class TwitterOperationsResponseDTO {
	
	private String requestId;
	private TweetDTO tweetDTO;

}
