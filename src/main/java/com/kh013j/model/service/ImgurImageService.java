package com.kh013j.model.service;

import org.apache.http.NameValuePair;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;

import javax.json.Json;
import javax.json.JsonObject;
import javax.json.JsonReader;
import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;


public class ImgurImageService{

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

    public static String uploadImage(byte[] imageBytes) throws IOException{
        byte[] imageBase64 = java.util.Base64.getEncoder().encode(imageBytes);
        String link;

        try (CloseableHttpClient client = HttpClients.createDefault()) {
            HttpPost httpPost = new HttpPost(UPLOAD_IMAGE_URL);
            httpPost.addHeader("Authorization", CLIENT_ID);
            List<NameValuePair> params = new ArrayList<>();
            params.add(new BasicNameValuePair("image", new String(imageBase64, "UTF-8")));
            httpPost.setEntity(new UrlEncodedFormEntity(params));
            CloseableHttpResponse response = client.execute(httpPost);

            BufferedReader in = new BufferedReader(
                    new InputStreamReader(response.getEntity().getContent()));
            try (JsonReader jsonReader = Json.createReader(in)) {
                JsonObject object = jsonReader.readObject();
                link = object.getJsonObject("data").getJsonString("link").getString();
            }

            response.getEntity().getContent();
        }

        return link;
    }
}
