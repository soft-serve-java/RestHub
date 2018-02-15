package com.kh013j.model.service;


import com.kh013j.model.service.interfaces.ImageService;

import javax.json.Json;
import javax.json.JsonObject;
import javax.json.JsonReader;
import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Base64;

public class ImgurImageService implements ImageService {

    private static final String GET_IMAGE_URL = "https://api.imgur.com/3/image/";
    private static final String UPLOAD_IMAGE_URL = "https://api.imgur.com/3/image";
    private static final String CLIENT_ID = "Client-ID 7c12a1234e46fdf";


    public String getImage(String hash) throws Exception {
        String url = GET_IMAGE_URL + hash;

        URL obj = new URL(url);
        HttpURLConnection con = (HttpURLConnection) obj.openConnection();
        con.setRequestProperty("Authorization", CLIENT_ID);
        con.setRequestMethod("GET");

        BufferedReader in = new BufferedReader(
                new InputStreamReader(con.getInputStream()));

        String link;
        try (JsonReader jsonReader = Json.createReader(in)) {
            JsonObject object = jsonReader.readObject();
            link = object.getJsonObject("data").getJsonString("link").getString();
        }

        return link;
    }

    public String uploadImage(byte[] imageBytes) throws Exception{
        byte[] imageBase64 = Base64.getEncoder().encode(imageBytes);

        URL obj = new URL(UPLOAD_IMAGE_URL);
        HttpURLConnection con = (HttpURLConnection) obj.openConnection();
        con.setRequestProperty("Authorization", CLIENT_ID);
        con.setRequestProperty("content-type","multipart/form-data; boundary=----WebKitFormBoundary7MA4YWxkTrZu0gW'");

        con.setDoOutput(true);
        DataOutputStream out = new DataOutputStream(con.getOutputStream());
        out.writeBytes("image=" + new String(imageBase64));
        out.flush();
        out.close();
        con.setRequestMethod("POST");

        BufferedReader in = new BufferedReader(
                new InputStreamReader(con.getInputStream()));
        String link;
        try (JsonReader jsonReader = Json.createReader(in)) {
            JsonObject object = jsonReader.readObject();
            link = object.getJsonObject("data").getJsonString("link").getString();
        }

        return link;
    }

}
