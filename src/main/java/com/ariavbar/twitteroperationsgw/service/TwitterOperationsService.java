package com.ariavbar.twitteroperationsgw.service;

import com.ariavbar.twitteroperationsgw.dto.TwitterOperationsRequestDTO;
import com.ariavbar.twitteroperationsgw.dto.TwitterOperationsResponseDTO;

public interface TwitterOperationsService {

	TwitterOperationsResponseDTO tweet(TwitterOperationsRequestDTO twitterOperationsRequestDTO);

	TwitterOperationsResponseDTO show(Long tweetId);
	
}
