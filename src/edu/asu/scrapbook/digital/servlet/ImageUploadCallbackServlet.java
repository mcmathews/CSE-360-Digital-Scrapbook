package edu.asu.scrapbook.digital.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ImageUploadCallbackServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	public void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// Handle Blobstore callback after image is added to blobstore
		
		// check for id of previous image
		// if id
		//		update old Image
		// else 
		// 		make new Image
		//		add to user
	}
}
