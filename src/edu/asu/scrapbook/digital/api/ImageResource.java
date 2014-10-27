package edu.asu.scrapbook.digital.api;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.InternalServerErrorException;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import edu.asu.scrapbook.digital.dao.ImageDAO;
import edu.asu.scrapbook.digital.dao.ImageDAOFactory;
import edu.asu.scrapbook.digital.dao.UserDAO;
import edu.asu.scrapbook.digital.dao.UserDAOFactory;
import edu.asu.scrapbook.digital.model.Image;
import edu.asu.scrapbook.digital.model.User;
import edu.asu.scrapbook.digital.util.ImageUtil;
import edu.asu.scrapbook.digital.util.UserUtil;

@Path("/images")
public class ImageResource {
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<Image> getUserImageIds() {
		String username = UserUtil.getRequestUsername();
		
		ImageDAO imageDao = ImageDAOFactory.getInstance();
		UserDAO userDao = UserDAOFactory.getInstance();
		try {
			User user = userDao.findById(username);
			List<Image> imageIds = null;
			// user should never be null
			if (user != null) {
				imageIds = imageDao.getAllImagesByUser(user);
			}
			
			return imageIds;
			
		} catch (Exception e) {
			throw new InternalServerErrorException(e);
		}
	}
	
	@PUT
	@Path("{id}/edit")
	@Consumes(MediaType.APPLICATION_OCTET_STREAM)
	public void editImage(byte[] imageData, @PathParam("id") long id) {
		String username = "";// UserUtil.getRequestUsername();
		
		ImageDAO imageDao = ImageDAOFactory.getInstance();
		UserDAO userDao = UserDAOFactory.getInstance();
		try {
			User user = userDao.findById(username);
			List<Image> userImages = imageDao.getAllImagesByUser(user);
			
			for (Image image : userImages) {
				if (image.getId() == id) {
					ImageUtil.updateEditedImage(image, imageData);
					break;
				}
			}
			
		} catch (Exception e) {
			throw new InternalServerErrorException(e);
		}
	}
}
