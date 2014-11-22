package edu.asu.scrapbook.digital.api;

import java.util.Iterator;
import java.util.List;

import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.InternalServerErrorException;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.google.appengine.api.blobstore.BlobstoreService;
import com.google.appengine.api.blobstore.BlobstoreServiceFactory;

import edu.asu.scrapbook.digital.dao.ImageDAO;
import edu.asu.scrapbook.digital.dao.ImageDAOFactory;
import edu.asu.scrapbook.digital.dao.UserDAO;
import edu.asu.scrapbook.digital.dao.UserDAOFactory;
import edu.asu.scrapbook.digital.model.Image;
import edu.asu.scrapbook.digital.model.User;
import edu.asu.scrapbook.digital.util.UserUtil;

@Path("/images")
public class ImageResource {
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<Image> getUserImages() {
		String username = UserUtil.getRequestUsername();
		
		ImageDAO imageDao = ImageDAOFactory.getInstance();
		UserDAO userDao = UserDAOFactory.getInstance();
		try {
			User user = userDao.findById(username);
			List<Image> imageIds = null;
			if (user != null) {
				imageIds = imageDao.getAllImagesByUser(user);
			}
			
			return imageIds;
			
		} catch (Exception e) {
			throw new InternalServerErrorException(e);
		}
	}
	
	@GET
	@Path("{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Image getImage(@PathParam("id") long id) {
		String username = UserUtil.getRequestUsername();
		
		ImageDAO imageDao = ImageDAOFactory.getInstance();
		UserDAO userDao = UserDAOFactory.getInstance();
		try {
			User user = userDao.findById(username);
			if (user != null) {
				List<Image> userImages = imageDao.getAllImagesByUser(user);
				for (Image image : userImages) {
					if (image.getId() == id) {
						return image;
					}
				}
			}
			
			return null;
			
		} catch (Exception e) {
			throw new InternalServerErrorException(e);
		}
	}
	
	@GET
	@Path("{id}/data")
	@Produces(MediaType.APPLICATION_OCTET_STREAM)
	public Response getImageData(@PathParam("id") long id) {
		try {
			Image image = getImage(id);
			if (image != null) {
				Client client = ClientBuilder.newClient();
				WebTarget webResource = client.target(image.getDatastoreLink());
				
				return webResource.request(MediaType.APPLICATION_OCTET_STREAM).get();
			}
			
			return null;
		} catch (Exception e) {
			throw new InternalServerErrorException(e);
		}
	}
	
	@DELETE
	@Path("{id}")
	public void delete(@PathParam("id") long id) {
		String username = UserUtil.getRequestUsername();
		
		ImageDAO imageDao = ImageDAOFactory.getInstance();
		UserDAO userDao = UserDAOFactory.getInstance();
		try {
			User user = userDao.findById(username);
			if (user != null) {
				List<Image> images = imageDao.getAllImagesByUser(user);
				Image image = images.get(0);
				for (Iterator<Image> iter = images.iterator(); iter.hasNext(); image = iter.next()) {
					if (image.getId() == id) {
						BlobstoreService bs = BlobstoreServiceFactory.getBlobstoreService();
						bs.delete(image.getBlobKey());
						
						iter.remove();
						userDao.update(user);
						
						break;
					}
				}
			}
			
		} catch (Exception e) {
			throw new InternalServerErrorException(e);
		}
	}
}
