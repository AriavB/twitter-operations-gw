package com.ariavbar.twitteroperationsgw.config;

import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cache.concurrent.ConcurrentMapCacheManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableCaching
public class CachingConfig {
	
	public static final String APPLICATION_CACHE = "tweets";
	
    @Bean
    public CacheManager cacheManager() {
        return new ConcurrentMapCacheManager(APPLICATION_CACHE);
    }
}
