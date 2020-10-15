package com.ariavbar.twitteroperationsgw.controller;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;

import com.ariavbar.twitteroperationsgw.TestUtil;
import com.ariavbar.twitteroperationsgw.dto.TwitterOperationsRequestDTO;
import com.ariavbar.twitteroperationsgw.dto.TwitterOperationsResponseDTO;
import com.ariavbar.twitteroperationsgw.service.TwitterOperationsService;
import com.fasterxml.jackson.databind.ObjectMapper;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@SpringBootTest
@AutoConfigureMockMvc
class TwitterOperationsControllerTest {
	
	@Autowired
	private MockMvc mockMvc;
	
	@Autowired
	private ObjectMapper mapper;
	
	@MockBean
	private TwitterOperationsService twitterOperationsService;
	
	@Test
	void contextLoads() {}

	@Test
	public void shouldBeCreated() throws Exception {
		TwitterOperationsRequestDTO twitterOperationsRequestDTO = TestUtil.getTwitterOperationsRequestDTO();
		TwitterOperationsResponseDTO twitterOperationsResponseDTO = TestUtil.getTwitterOperationsResponseDTO();
		
		when(twitterOperationsService.tweet(twitterOperationsRequestDTO)).thenReturn(twitterOperationsResponseDTO);
		
		MvcResult mvcResult = mockMvc
								.perform(post("/v1/tweet")
								.content(mapper.writeValueAsString(twitterOperationsRequestDTO))
								.contentType(MediaType.APPLICATION_JSON)
								.accept(MediaType.APPLICATION_JSON))
								.andExpect(status().isCreated())
								.andReturn();
								
		assertEquals(mapper.writeValueAsString(twitterOperationsResponseDTO), mvcResult.getResponse().getContentAsString());
	}
	
	@Test
	public void shouldShowTweet() throws Exception {
		TwitterOperationsResponseDTO twitterOperationsResponseDTO = TestUtil.getTwitterOperationsResponseDTO();
		Long tweetId = Long.valueOf(TestUtil.getTweetId());
		
		when(twitterOperationsService.show(tweetId)).thenReturn(twitterOperationsResponseDTO);

		MvcResult mvcResult = mockMvc
								.perform(get("/v1/show/{tweetId}", tweetId)
								.accept(MediaType.APPLICATION_JSON))
								.andExpect(status().isOk())
								.andReturn();
		
		assertEquals(mapper.writeValueAsString(twitterOperationsResponseDTO), mvcResult.getResponse().getContentAsString());

	}
	
}
