package edu.asu.scrapbook.digital.dao;

import edu.asu.scrapbook.digital.model.User;

public interface UserDAO {
	public User findById() throws Exception;
	public void create() throws Exception;
	public void update() throws Exception;
	public void delete() throws Exception;
}
