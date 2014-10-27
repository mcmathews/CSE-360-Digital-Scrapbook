package edu.asu.scrapbook.digital.util;

import com.google.appengine.api.users.UserService;
import com.google.appengine.api.users.UserServiceFactory;

import edu.asu.scrapbook.digital.dao.UserDAO;
import edu.asu.scrapbook.digital.dao.UserDAOFactory;

public class UserUtil {
	public static String getRequestUsername() {
		UserService userService = UserServiceFactory.getUserService();
		return userService.getCurrentUser().getEmail();
	}
	
	public static boolean userExists(String username) throws Exception {
		UserDAO dao = UserDAOFactory.getInstance();
		return dao.findById(username) != null;
	}
}
