package com.ariavbar.twitteroperationsgw;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;

import com.ariavbar.twitteroperationsgw.dto.TwitterOperationsRequestDTO;
import com.ariavbar.twitteroperationsgw.dto.TwitterOperationsResponseDTO;
import com.fasterxml.jackson.databind.ObjectMapper;

@SpringBootTest
@AutoConfigureMockMvc
public class ComponentTest {
	
	@Autowired
	private MockMvc mockMvc;
	
	@Autowired
	private ObjectMapper mapper;
	
	@Test
	public void shouldBeCreated() throws Exception {
		TwitterOperationsRequestDTO twitterOperationsRequestDTO = TestUtil.getTwitterOperationsRequestDTO();
		TwitterOperationsResponseDTO twitterOperationsResponseDTO = TestUtil.getTwitterOperationsResponseDTO();

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
		
		MvcResult mvcResult = mockMvc
								.perform(get("/v1/show/{tweetId}", tweetId)
								.accept(MediaType.APPLICATION_JSON))
								.andExpect(status().isOk())
								.andReturn();
		
		assertEquals(mapper.writeValueAsString(twitterOperationsResponseDTO), mvcResult.getResponse().getContentAsString());
	}

}
