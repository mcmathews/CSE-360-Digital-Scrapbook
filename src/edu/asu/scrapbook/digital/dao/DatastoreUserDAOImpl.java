package edu.asu.scrapbook.digital.dao;

import edu.asu.scrapbook.digital.model.User;
import static edu.asu.scrapbook.digital.dao.OfyService.ofy;

public class DatastoreUserDAOImpl implements UserDAO {
	public User findById(String id) throws Exception {
		User newUser = ofy().load().type(User.class).id(id).now();
		return newUser;
	}
	
	public User create(User user) throws Exception {
		ofy().save().entity(user).now();
		return ofy().load().type(User.class).id(user.getUsername()).now();
	}
	
	public User update(User user) throws Exception {
		User updatedUser = ofy().load().type(User.class).id(user.getUsername()).now();
		updatedUser.setSettings(user.getSettings());
		ofy().save().entity(updatedUser).now();
		return ofy().load().type(User.class).id(user.getUsername()).now();
	}
	
	public void delete(String id) throws Exception {
		ofy().delete().type(User.class).id(id).now();
	}
}
