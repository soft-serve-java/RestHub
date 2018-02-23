package com.kh013j.model.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

import java.io.*;
import java.util.Properties;


public class ImgurImageService{

    private static final String IMGUR_PROPERTIES = "imgur.properties";

    private static final String IMAGE_URL;
    private static final String CLIENT_ID;

    private static Logger logger = LoggerFactory.getLogger(ImgurImageService.class);

    static {
        IMAGE_URL = getImageProperties().getProperty("image_url");
        CLIENT_ID = getImageProperties().getProperty("client_id");
    }

    private ImgurImageService() throws IllegalAccessException {
        throw new IllegalAccessException();
    }

    public static String uploadImage(byte[] imageBytes) throws IOException {
        byte[] imageBase64 = java.util.Base64.getEncoder().encode(imageBytes);
        RestTemplate restTemplate = new RestTemplate();
        HttpHeaders headers = new HttpHeaders();
        headers.set("Authorization", CLIENT_ID);
        MultiValueMap<String, String> map= new LinkedMultiValueMap<>();
        map.add("image", new String(imageBase64, "UTF-8"));

        HttpEntity<MultiValueMap<String, String>> request = new HttpEntity<>(map, headers);
        ResponseEntity<String> response = restTemplate.postForEntity(IMAGE_URL, request, String.class);

        return new ObjectMapper().readTree(response.getBody()).path("data").path("link").asText();
    }

    private static Properties getImageProperties() {
        Properties prop = new Properties();
        try {
            prop.load(ImgurImageService.class.getClassLoader().getResourceAsStream(IMGUR_PROPERTIES));
        } catch (IOException e) {
            logger.error("Properties file wasn't found", e);
        }
        return prop;
    }
}
