package com.ariavbar.twitteroperationsgw.dto;

import java.util.Date;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class TweetDTO {
	
	private Date tweetCreationTime;
	private String tweetId;
	private String tweetText;
	private List<String> tweetHashtags;

}
