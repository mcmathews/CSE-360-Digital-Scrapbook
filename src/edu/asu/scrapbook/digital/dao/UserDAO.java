package edu.asu.scrapbook.digital.dao;

import edu.asu.scrapbook.digital.model.User;

public interface UserDAO {
	public User findById(String id) throws Exception;
	public User create(User user) throws Exception;
	public User update(User user) throws Exception;
	public void delete(String id) throws Exception;
}
