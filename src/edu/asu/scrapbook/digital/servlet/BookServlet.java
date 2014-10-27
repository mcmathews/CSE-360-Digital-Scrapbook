package edu.asu.scrapbook.digital.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import edu.asu.scrapbook.digital.util.UserUtil;

public class BookServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String username = UserUtil.getRequestUsername();
		
		String forwardUrl = null;
		try {
			if (UserUtil.userExists(username)) {
				forwardUrl = "/profile.jsp";
			} else {
				forwardUrl = "/signup.jsp";
			}
			
			request.getRequestDispatcher(forwardUrl).forward(request, response);
			
		} catch (Exception e) {
			throw new ServletException(e);
		}
	}
}
