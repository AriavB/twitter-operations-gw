package com.ariavbar.twitteroperationsgw;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import com.ariavbar.twitteroperationsgw.dto.TwitterOperationsRequestDTO;
import com.ariavbar.twitteroperationsgw.service.TwitterOperationsService;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
@AutoConfigureMockMvc
class TwitterOperationsGwApplicationTests {
	
	@Autowired
	private MockMvc mockMvc;
	
	@MockBean
	private TwitterOperationsService twitterOperationsService;
	
	private ObjectMapper mapper = new ObjectMapper().configure(SerializationFeature.WRAP_ROOT_VALUE, false);
	private String requestId = "requestId";
	private TwitterOperationsRequestDTO twitterOperationsRequestDTO = new TwitterOperationsRequestDTO(requestId);
	
	@Test
	void contextLoads() {}

	@Test
	public void shouldReturnDefaultStatus() throws Exception {
		mockMvc.perform(post("/v1/tweet").content(mapper.writeValueAsString(twitterOperationsRequestDTO))
		.contentType(MediaType.APPLICATION_JSON).accept(MediaType.APPLICATION_JSON)).andExpect(status().isCreated());
	}
}
