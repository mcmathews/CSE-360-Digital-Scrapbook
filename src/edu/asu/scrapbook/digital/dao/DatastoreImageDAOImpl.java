package edu.asu.scrapbook.digital.dao;

import static edu.asu.scrapbook.digital.dao.OfyService.ofy;

import java.util.ArrayList;
import java.util.List;

import com.googlecode.objectify.Ref;

import edu.asu.scrapbook.digital.model.Image;
import edu.asu.scrapbook.digital.model.User;

public class DatastoreImageDAOImpl implements ImageDAO {
	public Image findById(Long id) throws Exception {
		Image image = ofy().load().type(Image.class).id(id).now();
		return image;
	}

	public List<Image> getAllImagesByUser(User user) throws Exception {
		List<Ref<Image>> images = ofy().load().type(User.class).id(user.getUsername()).now().getImages();
		List<Image> userImages = new ArrayList<>();
		for (Ref<Image> img : images) {
			userImages.add(img.get());
		}
		return userImages;
	}

	public Image create(Image image) throws Exception {
		ofy().save().entity(image).now();
		return image;
	}

	public Image update(Image image) throws Exception {
		ofy().save().entity(image).now();
		return image;
	}

	public void delete(Long id) throws Exception {
		ofy().delete().type(Image.class).id(id).now();
	}
}
