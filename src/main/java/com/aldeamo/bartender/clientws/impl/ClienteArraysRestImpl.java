package com.aldeamo.bartender.clientws.impl;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import com.aldeamo.bartender.clientws.ClienteArraysRest;
import com.aldeamo.bartender.dto.ArraysDTO;
import java.net.URI;

@Component
public class ClienteArraysRestImpl implements ClienteArraysRest{
	@Value("${bartender.client.arrays.endPoint}")
	private String serviceUrl;
	
	RestTemplate restTemplate = new RestTemplate();
	
	@Override
	public ArraysDTO getArrays(Integer pila) {
		ArraysDTO respuesta = new ArraysDTO();
		String endpoint;
		
		endpoint = serviceUrl;
        // URI (URL) parameters
        Map<String, Integer> uriParams = new HashMap<String, Integer>();
        uriParams.put("id", pila);

        // Query parameters
        UriComponentsBuilder builder = UriComponentsBuilder.fromUriString(endpoint);

        URI url = builder.buildAndExpand(uriParams).toUri();

        HttpHeaders headers = new HttpHeaders();
        headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON, MediaType.TEXT_PLAIN));

        HttpEntity<Map<String, Integer>> entity = new HttpEntity<>(uriParams, headers);

        respuesta = restTemplate.exchange(url, HttpMethod.GET, entity, new ParameterizedTypeReference<ArraysDTO>() {}).getBody();

		return respuesta;
	}
}
