package edu.asu.scrapbook.digital.dao;

public class UserDAOFactory {
	public static UserDAO getInstance() {
		return new UserDAOImpl();
	}
}
