package com.ariavbar.twitteroperationsgw.logging;

import java.io.IOException;

import org.springframework.http.HttpRequest;
import org.springframework.http.client.ClientHttpRequestExecution;
import org.springframework.http.client.ClientHttpRequestInterceptor;
import org.springframework.http.client.ClientHttpResponse;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class LoggingInterceptor implements ClientHttpRequestInterceptor {
	
	@Override
	public ClientHttpResponse intercept(HttpRequest request, byte[] body, ClientHttpRequestExecution execution)
			throws IOException {

		logRequest(request, body);
		ClientHttpResponse response = execution.execute(request, body);
		logResponse(response);
		
		return response;
	}

	private void logRequest(HttpRequest request, byte[] body) {
		log.info(request.getURI().toString());
		log.info(body.toString());
	}

	private void logResponse(ClientHttpResponse response) {
		try {
			log.info(response.getBody().toString());
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
}
