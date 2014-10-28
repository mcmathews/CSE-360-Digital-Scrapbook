package edu.asu.scrapbook.digital.servlet;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.appengine.api.blobstore.BlobKey;
import com.google.appengine.api.blobstore.BlobstoreService;
import com.google.appengine.api.blobstore.BlobstoreServiceFactory;
import com.google.appengine.api.images.ImagesService;
import com.google.appengine.api.images.ImagesServiceFactory;
import com.google.appengine.api.images.ServingUrlOptions;
import com.googlecode.objectify.Ref;

import edu.asu.scrapbook.digital.dao.ImageDAO;
import edu.asu.scrapbook.digital.dao.ImageDAOFactory;
import edu.asu.scrapbook.digital.dao.UserDAO;
import edu.asu.scrapbook.digital.dao.UserDAOFactory;
import edu.asu.scrapbook.digital.model.Image;
import edu.asu.scrapbook.digital.model.User;
import edu.asu.scrapbook.digital.util.UserUtil;

public class ImageUploadCallbackServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	public void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String username = UserUtil.getRequestUsername();
		
		UserDAO userDao = UserDAOFactory.getInstance();
		ImageDAO imageDao = ImageDAOFactory.getInstance();
		try {
			User user = userDao.findById(username);
			
			BlobstoreService blobstoreService = BlobstoreServiceFactory.getBlobstoreService();
			Map<String, List<BlobKey>> blobs = blobstoreService.getUploads(request);
			BlobKey blobKey = blobs.get("image").get(0);
			
			Image image = null;
			
			String idParam = request.getParameter("id");
			boolean isEdit = idParam != null;
			if (isEdit) {
				long id = Long.parseLong(idParam);
				image = imageDao.findById(id);
			} else {
				image = new Image();
				String filename = blobstoreService.getFileInfos(request).get("image").get(0).getFilename();
				image.setFilename(filename);
				image.setTitle(request.getParameter("title"));
			}
			
			image.setBlobKey(blobKey);
			
			ImagesService imagesService = ImagesServiceFactory.getImagesService();
			image.setDatastoreLink(imagesService.getServingUrl(ServingUrlOptions.Builder.withBlobKey(image.getBlobKey())));
			
			boolean isProfileImage = request.getParameter("isProfileImage") != null;
			
			if (isProfileImage) {
				if (user.getSettings().getProfileImage() != null) {
					blobstoreService.delete(user.getSettings().getProfileImage().getBlobKey());
				}
				user.getSettings().setProfileImage(image);
				userDao.update(user);
				
			} else if (isEdit) {
				imageDao.update(image);
				
			} else {
				imageDao.create(image);
				user.getImages().add(Ref.create(image));
				userDao.update(user);
			}
			
		} catch (Exception e) {
			throw new ServletException(e);
		}
	}
}
