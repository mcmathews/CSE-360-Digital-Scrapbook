package edu.asu.scrapbook.digital.dao;

import java.util.List;

import edu.asu.scrapbook.digital.model.Image;
import edu.asu.scrapbook.digital.model.User;

public interface ImageDAO {
	public Image findById(Long id) throws Exception;
	public List<Image> getAllImagesByUser(User user) throws Exception;
	public Image create(Image image) throws Exception;
	public Image update(Image image) throws Exception;
	public void delete(Long id) throws Exception;
}
