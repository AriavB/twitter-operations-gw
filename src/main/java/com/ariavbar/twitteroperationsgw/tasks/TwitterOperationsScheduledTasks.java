package com.ariavbar.twitteroperationsgw.tasks;

import org.springframework.cache.annotation.CacheEvict;
import org.springframework.scheduling.annotation.Scheduled;

import com.ariavbar.twitteroperationsgw.config.ApplicationConstants;

public class TwitterOperationsScheduledTasks {

	@Scheduled(cron = "0 0 6 * * * *") 
	@CacheEvict(value = ApplicationConstants.APPLICATION_CACHE, allEntries = true)
	public void clearTwitterOperationsCache() {}
	
}
