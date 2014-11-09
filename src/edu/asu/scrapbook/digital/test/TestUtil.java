package edu.asu.scrapbook.digital.test;

import com.google.appengine.api.blobstore.BlobKey;

import edu.asu.scrapbook.digital.model.Image;
import edu.asu.scrapbook.digital.model.ProfileSettings;
import edu.asu.scrapbook.digital.model.User;

public class TestUtil {
	
	public static User clone(User user) {
		User clonedUser = null;
		if (user != null) {
			clonedUser = new User();
			clonedUser.setUsername(user.getUsername());
			if (user.getSettings() != null) {
				ProfileSettings settings = new ProfileSettings();
				settings.setFirstName(user.getSettings().getFirstName());
				settings.setLastName(user.getSettings().getLastName());
				settings.setProfileImage(user.getSettings().getProfileImage());
				clonedUser.setSettings(settings);
			}
		}
		
		return clonedUser;
	}
	
	public static Image clone(Image image) {
		Image clonedImage = null;
		if (image != null) {
			clonedImage = new Image();
			clonedImage.setBlobKey(image.getBlobKey());
			clonedImage.setDatastoreLink(image.getDatastoreLink());
			clonedImage.setFilename(image.getFilename());
			clonedImage.setId(image.getId());
			clonedImage.setTitle(image.getTitle());
		}
		
		return clonedImage;
	}
	
	public static Image getTestImage() {
		return getTestImage(100);
	}
	
	public static Image getTestImage(long i) {
		Image image = new Image();
		image.setBlobKey(new BlobKey("1234"));
		image.setDatastoreLink("test://test.com/test1234");
		image.setFilename("test.jpg");
		image.setId(i);
		image.setTitle("Test Image");
		
		return image;
	}
}
