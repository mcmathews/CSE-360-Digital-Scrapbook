package edu.asu.scrapbook.digital.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.appengine.api.blobstore.BlobstoreService;
import com.google.appengine.api.blobstore.BlobstoreServiceFactory;

import edu.asu.scrapbook.digital.util.ImageUtil;

public class ImageUploadServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		BlobstoreService blobstoreService = BlobstoreServiceFactory.getBlobstoreService();
		String url = blobstoreService.createUploadUrl(ImageUtil.UPLOAD_CALLBACK_URL);
		
		request.setAttribute("uploadUrl", url);
		request.getRequestDispatcher("/upload-image.jsp").forward(request, response);
	}
}
