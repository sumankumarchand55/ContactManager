package com.smart.contact.service.impl;

import java.io.IOException;
import java.util.Map;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.cloudinary.Cloudinary;
import com.cloudinary.Transformation;
import com.cloudinary.utils.ObjectUtils;
import com.smart.contact.helper.AppConstants;
import com.smart.contact.service.ImageService;

@Service
public class ImageServiceImpl implements ImageService {

	private Cloudinary cloudinary;

	public ImageServiceImpl(Cloudinary cloudinary) {
		this.cloudinary = cloudinary;
	}

	@Override
	public String uploadImage(MultipartFile contactImage, String filename) {
		try {
			byte[] data = new byte[contactImage.getInputStream().available()];
			contactImage.getInputStream().read(data);
			cloudinary.uploader().upload(data, ObjectUtils.asMap("public_id", filename));

			return this.getUrlFromPublicId(filename);
		} catch (IOException e) {
			e.printStackTrace();
			return null;
		}
	}

	@Override
	public String getUrlFromPublicId(String publicId) {

		return cloudinary.url()
				.transformation(new Transformation<>().width(AppConstants.CONTACT_IMAGE_WIDTH)
						.height(AppConstants.CONTACT_IMAGE_HEIGHT).crop(AppConstants.CONTACT_IMAGE_CROP))
				.generate(publicId);

	}

	@Override
	public void deleteImage(String cloudinaryImagePublicId) {
		try {
			// Use Cloudinary's uploader method to delete the image by public_id
			Map<String, String> result = cloudinary.uploader().destroy(cloudinaryImagePublicId, ObjectUtils.emptyMap());
			System.out.println("Image deleted: " + result);

		} catch (IOException e) {
			e.printStackTrace();
			throw new RuntimeException("Failed to delete image from Cloudinary", e);
		}
	}
}