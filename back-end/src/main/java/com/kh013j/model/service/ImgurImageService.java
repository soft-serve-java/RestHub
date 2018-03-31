package com.kh013j.model.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

import java.io.*;

@Service
public class ImgurImageService{

    @Value("${image.url}")
    private String imageUrl;
    @Value("${client.id}")
    private String clientID;

    public  String uploadImage(byte[] imageBytes) throws IOException {
        byte[] imageBase64 = java.util.Base64.getEncoder().encode(imageBytes);
        RestTemplate restTemplate = new RestTemplate();
        HttpHeaders headers = new HttpHeaders();
        headers.set("Authorization", clientID);
        MultiValueMap<String, String> map = new LinkedMultiValueMap<>();
        map.add("image", new String(imageBase64, "UTF-8"));

        HttpEntity<MultiValueMap<String, String>> request = new HttpEntity<>(map, headers);
        ResponseEntity<String> response = restTemplate.postForEntity(imageUrl, request, String.class);

        return new ObjectMapper().readTree(response.getBody()).path("data").path("link").asText();
    }

}
