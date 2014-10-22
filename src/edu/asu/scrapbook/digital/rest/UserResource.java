package edu.asu.scrapbook.digital.rest;

import javax.ws.rs.GET;
import javax.ws.rs.NotFoundException;
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
				return dao.findById();
			} catch (Exception e) {
				return null;
			}
		} else {
			throw new NotFoundException();
		}
	}
}
