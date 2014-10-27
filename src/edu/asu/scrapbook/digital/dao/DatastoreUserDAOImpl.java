package edu.asu.scrapbook.digital.dao;

import edu.asu.scrapbook.digital.model.User;
import static com.googlecode.objectify.ObjectifyService.ofy;

public class DatastoreUserDAOImpl implements UserDAO {
	public User findById(String id) throws Exception {
		User newUser = ofy().load().type(User.class).id(id).now();
		return newUser;
	}
	
	public User create(User user) throws Exception {
		ofy().save().entity(user);
		return null;
	}
	
	public User update(User user) throws Exception {
		User updatedUser = ofy().load().type(User.class).id(user.getUsername()).now();
		updatedUser.setSettings(user.getSettings());
		ofy().save().entity(updatedUser);
		return null;
	}
	
	public void delete(String id) throws Exception {
		ofy().delete().type(User.class).id(id);
	}
}
