package com.kh013j.model.service.interfaces;

public interface ImageService {

    public String getImage(String url) throws Exception;

    public String uploadImage(byte[] imageBytes) throws Exception;
}
