package edu.asu.scrapbook.digital.rest;

import javax.ws.rs.BadRequestException;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.NotFoundException;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import edu.asu.scrapbook.digital.dao.UserDAO;
import edu.asu.scrapbook.digital.dao.UserDAOFactory;
import edu.asu.scrapbook.digital.model.User;

@Path("/users")
@Produces(MediaType.APPLICATION_JSON)
public class UserResource {
	
	@GET
	@Path("/{username}")
	public User getOne(@PathParam("username") String username) {
		if (username != null && !username.isEmpty()) {
			UserDAO dao = UserDAOFactory.getInstance();
			try {
				return dao.findById(username);
			} catch (Exception e) {
				return null;
			}
		} else {
			throw new NotFoundException();
		}
	}
	
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	public User add(User user) {
		if (user != null) {
			UserDAO dao = UserDAOFactory.getInstance();
			try {
				// TODO: attr checking
				return user;
				//return dao.create(user);
			} catch (Exception e) {
				return null;
			}
		} else {
			throw new BadRequestException();
		}
	}
}
