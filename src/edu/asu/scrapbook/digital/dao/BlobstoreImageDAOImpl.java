package edu.asu.scrapbook.digital.dao;

import java.util.List;

import edu.asu.scrapbook.digital.model.Image;
import edu.asu.scrapbook.digital.model.User;

public class BlobstoreImageDAOImpl implements ImageDAO {
	public Image findById() throws Exception {
		return null;
	}

	public List<Image> getAllImagesByUser(User user) throws Exception {
		return null;
	}

	public Image create(User user, Image image) throws Exception {
		return image;
	}

	public Image update(User user, Image image) throws Exception {
		return image;
	}

	public void delete(User user, String imgId) throws Exception {
		
	}
}
