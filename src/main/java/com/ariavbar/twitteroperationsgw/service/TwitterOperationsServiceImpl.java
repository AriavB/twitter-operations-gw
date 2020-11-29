package com.ariavbar.twitteroperationsgw.service;

import java.util.stream.Collectors;

import org.springframework.cache.annotation.Cacheable;
import org.springframework.social.twitter.api.Tweet;
import org.springframework.social.twitter.api.Twitter;
import org.springframework.stereotype.Service;

import com.ariavbar.twitteroperationsgw.config.ApplicationConstants;
import com.ariavbar.twitteroperationsgw.dto.TweetDTO;
import com.ariavbar.twitteroperationsgw.dto.TwitterOperationsRequestDTO;
import com.ariavbar.twitteroperationsgw.dto.TwitterOperationsResponseDTO;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@RequiredArgsConstructor
@Slf4j
@Service
public class TwitterOperationsServiceImpl implements TwitterOperationsService {
	
	private final Twitter twitter;

	@Override
	public TwitterOperationsResponseDTO tweet(TwitterOperationsRequestDTO twitterOperationsRequestDTO) {
	    Tweet tweet = null;  
		try {
	         tweet = twitter.timelineOperations().updateStatus(twitterOperationsRequestDTO.getStatusUpdateText());
	     } catch (RuntimeException ex) {
	    	 log.error("Unable to tweet" + ex);
	     }

		return TwitterOperationsResponseDTO.builder()
				.requestId(twitterOperationsRequestDTO.getRequestId())
				.tweetDTO(TweetDTO.builder()
						.tweetCreationTime(tweet.getCreatedAt())
						.tweetId(tweet.getIdStr())
						.tweetText(tweet.getText())
						.tweetHashtags(tweet.getEntities().getHashTags().stream().map(h -> h.getText()).collect(Collectors.toList()))
						.build()).build();
	}

	@Override
	@Cacheable(value = ApplicationConstants.APPLICATION_CACHE, key = "#tweetId")
	public TwitterOperationsResponseDTO show(Long tweetId) {
		Tweet tweet = twitter.timelineOperations().getStatus(tweetId);
		
		return TwitterOperationsResponseDTO.builder()
				.tweetDTO(TweetDTO.builder()
						.tweetCreationTime(tweet.getCreatedAt())
						.tweetId(tweet.getIdStr())
						.tweetText(tweet.getText())
						.tweetHashtags(tweet.getEntities().getHashTags().stream().map(h -> h.getText()).collect(Collectors.toList()))
						.build()).build();					
	}

}
