package com.ariavbar.twitteroperationsgw;

import java.sql.Date;
import java.time.LocalDate;
import java.util.List;

import com.ariavbar.twitteroperationsgw.dto.TweetDTO;
import com.ariavbar.twitteroperationsgw.dto.TwitterOperationsRequestDTO;
import com.ariavbar.twitteroperationsgw.dto.TwitterOperationsResponseDTO;

public class TestUtil {
	
	private static final String requestId = "requestId";
	private static final String statusUpdateText = "statusUpdateText";
	private static final Date tweetCreationTime = Date.valueOf(LocalDate.now());
	private static final String tweetId = "1000";
	private static final String tweetText = "tweetText";
	private static final List<String> tweetHashtags = List.of("#tweet", "#hash", "#tags");
	
	public static TwitterOperationsRequestDTO getTwitterOperationsRequestDTO() {
		TwitterOperationsRequestDTO twitterOperationsRequestDTO = new TwitterOperationsRequestDTO();
		twitterOperationsRequestDTO.setRequestId(requestId);
		twitterOperationsRequestDTO.setStatusUpdateText(statusUpdateText);
		
		return twitterOperationsRequestDTO;
	}

	public static String getTweetId() {
		return tweetId;
	}

	public static TwitterOperationsResponseDTO getTwitterOperationsResponseDTO() {
		TwitterOperationsResponseDTO twitterOperationsResponseDTO = new TwitterOperationsResponseDTO();
		twitterOperationsResponseDTO.setRequestId(requestId);
		twitterOperationsResponseDTO.setTweetDTO(getTweet());
		
		return twitterOperationsResponseDTO;
	}

	private static TweetDTO getTweet() {
		return TweetDTO.builder()
				.tweetCreationTime(tweetCreationTime)
				.tweetId(tweetId)
				.tweetText(tweetText)
				.tweetHashtags(tweetHashtags)
				.build();
	}
	
}
