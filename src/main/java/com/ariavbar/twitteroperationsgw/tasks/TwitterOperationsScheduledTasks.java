package com.ariavbar.twitteroperationsgw.tasks;

import org.springframework.cache.annotation.CacheEvict;
import org.springframework.scheduling.annotation.Scheduled;

public class TwitterOperationsScheduledTasks {

	@Scheduled(cron = "0 0 6 * * * *") 
	@CacheEvict(value = "tweets", allEntries = true)
	public void clearTwitterOperationsCache() {}
}
