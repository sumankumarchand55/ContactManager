package com.smart.contact.service;

import org.springframework.web.multipart.MultipartFile;

public interface ImageService {
	  String getUrlFromPublicId(String publicId);
	String uploadImage(MultipartFile contactImage, String filename);
	void deleteImage(String cloudinaryImagePublicId);
}
