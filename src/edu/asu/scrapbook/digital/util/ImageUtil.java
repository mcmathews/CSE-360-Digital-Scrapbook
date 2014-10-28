package edu.asu.scrapbook.digital.util;

import java.io.ByteArrayInputStream;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;

import org.glassfish.jersey.media.multipart.FormDataBodyPart;
import org.glassfish.jersey.media.multipart.FormDataMultiPart;

import com.google.appengine.api.blobstore.BlobstoreService;
import com.google.appengine.api.blobstore.BlobstoreServiceFactory;

import edu.asu.scrapbook.digital.model.Image;

public class ImageUtil {
	
	public static String UPLOAD_CALLBACK_URL = "/book/uploadCallback";
	
	public static void updateEditedImage(Image image, byte[] imageData) {
		BlobstoreService blobstoreService = BlobstoreServiceFactory.getBlobstoreService();
		blobstoreService.delete(image.getBlobKey());
		
		String uploadUrl = blobstoreService.createUploadUrl(UPLOAD_CALLBACK_URL);
		
		Client client = ClientBuilder.newClient();
		WebTarget webResource = client.target(uploadUrl);
		
		FormDataMultiPart form = new FormDataMultiPart();
		form.field("filename", image.getFilename());
		form.field("title", image.getTitle());
		form.field("id", image.getId().toString());
		
		FormDataBodyPart bodyPart = new FormDataBodyPart("file", new ByteArrayInputStream(imageData), MediaType.APPLICATION_OCTET_STREAM_TYPE);
		form.bodyPart(bodyPart);
		
		webResource.request().post(Entity.entity(form, MediaType.TEXT_PLAIN_TYPE));
	}
	
}
