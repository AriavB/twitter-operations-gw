package com.ariavbar.twitteroperationsgw.tweeter;

import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.social.twitter.api.Twitter;

import com.ariavbar.twitteroperationsgw.TestUtil;

@SpringBootTest
public class TweeterTemplateTest {
	
	@Autowired
	Twitter twitterTemplate;
	
	@Test
	public void shouldShowTweet() throws Exception {
		assertThrows(Exception.class, () -> twitterTemplate.timelineOperations().getStatus(Long.valueOf(TestUtil.getTweetId())));
	}
}
