package edu.asu.scrapbook.digital.api;

import javax.ws.rs.BadRequestException;
import javax.ws.rs.ClientErrorException;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.InternalServerErrorException;
import javax.ws.rs.NotFoundException;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import edu.asu.scrapbook.digital.dao.UserDAO;
import edu.asu.scrapbook.digital.dao.UserDAOFactory;
import edu.asu.scrapbook.digital.model.User;
import edu.asu.scrapbook.digital.util.UserUtil;

@Path("/user")
@Produces(MediaType.APPLICATION_JSON)
public class UserResource {
	
	@GET
	public User getUser() {
		String username = UserUtil.getRequestUsername();
		
		UserDAO dao = UserDAOFactory.getInstance();
		try {
			User user = dao.findById(username);
			if (user == null) {
				user = new User();
				user.setUsername(username);
			}
			
			return user;
			
		} catch (Exception e) {
			throw new InternalServerErrorException(e);
		}
	}
	
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	public User createUser(User user) {
		String username = UserUtil.getRequestUsername();
		
		if (user == null || user.getSettings() == null) {
			throw new BadRequestException();
		}
		
		user.setUsername(username);
		
		UserDAO dao = UserDAOFactory.getInstance();
		try {
			if (UserUtil.userExists(user.getUsername())) {
				throw new BadRequestException("A user already exists with that username");
			}
			
			return dao.create(user);
		} catch (ClientErrorException e) {
			// Let these types of exception through
			throw e;
		} catch (Exception e) {
			throw new InternalServerErrorException(e);
		}
	}
	
	@PUT
	@Consumes(MediaType.APPLICATION_JSON)
	public User updateUser(User updatedUser) {
		String username = UserUtil.getRequestUsername();
		
		if (updatedUser == null) {
			throw new BadRequestException();
		}
		
		UserDAO dao = UserDAOFactory.getInstance();
		try {
			User user = dao.findById(username);
			if (user == null) {
				throw new NotFoundException();
			}
			
			if (updatedUser.getSettings() != null) {
				user.setSettings(updatedUser.getSettings());
			}
			
			return dao.update(user);
			
		} catch (ClientErrorException e) {
			// Let these types of exception through
			throw e;
		} catch (Exception e) {
			throw new InternalServerErrorException(e);
		}
	}
	
	/*@DELETE
	public void deleteUser() {
		String username = UserUtil.getRequestUsername();
		
		UserDAO dao = UserDAOFactory.getInstance();
		try {
			// TODO: delete images
			dao.delete(username);
		} catch (Exception e) {
			throw new InternalServerErrorException(e);
		}
	}*/
}
