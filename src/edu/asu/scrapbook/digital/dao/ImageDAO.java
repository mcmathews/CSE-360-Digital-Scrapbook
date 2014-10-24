package edu.asu.scrapbook.digital.dao;

import java.util.List;

import edu.asu.scrapbook.digital.model.Image;
import edu.asu.scrapbook.digital.model.User;

public interface ImageDAO {
	public Image findById() throws Exception;
	public List<Image> getAllImagesByUser(User user) throws Exception;
	public Image create(User user, Image image) throws Exception;
	public Image update(User user, Image image) throws Exception;
	public void delete(User user, String imgId) throws Exception;
}
