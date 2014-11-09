package edu.asu.scrapbook.digital.test;

import static org.junit.Assert.*;

import org.junit.Test;

import com.google.appengine.tools.development.testing.LocalDatastoreServiceTestConfig;
import com.google.appengine.tools.development.testing.LocalServiceTestHelper;
import com.googlecode.objectify.ObjectifyService;
import com.googlecode.objectify.SaveException;
import com.googlecode.objectify.VoidWork;

import edu.asu.scrapbook.digital.dao.UserDAO;
import edu.asu.scrapbook.digital.dao.UserDAOFactory;
import edu.asu.scrapbook.digital.model.ProfileSettings;
import edu.asu.scrapbook.digital.model.User;

public class DatastoreUserTest {
	@Test
	public void createUserTest() throws Exception {
		ObjectifyService.run(new VoidWork() {
		    public void vrun() {
		    	LocalServiceTestHelper helper = new LocalServiceTestHelper(new LocalDatastoreServiceTestConfig());
				helper.setUp();
				
				User testUser = new User();
				ProfileSettings ps = new ProfileSettings();
				
				ps.setFirstName("John");
				ps.setLastName("Doe");
				testUser.setUsername("testID");
				testUser.setSettings(ps);
				
				UserDAO dao = UserDAOFactory.getInstance();
				User resultUser = null;
				
				try {
					resultUser = dao.create(testUser);
				} catch (Exception e) {
					fail("User could not be created: " + e.getMessage());
				}
				
				assertEquals("Created user differs from returned user", testUser, resultUser);
				helper.tearDown();
		    }
		});
	}
	
	@Test
	public void failToCreateUserTest() {
		ObjectifyService.run(new VoidWork() {
		    public void vrun() {
		    	LocalServiceTestHelper helper = new LocalServiceTestHelper(new LocalDatastoreServiceTestConfig());
				helper.setUp();
				UserDAO dao = UserDAOFactory.getInstance();
				User testUser = new User();
				try {
					dao.create(testUser);
					fail("Test must fail");
				} catch (SaveException se) {
					// Successful test
				} catch (Exception e) {
					fail("Emergency failure. Threw an unknown exception");
				}
				helper.tearDown();
		    }
		});
	}
	
	@Test
	public void foundUserTest() throws Exception {
		ObjectifyService.run(new VoidWork() {
		    public void vrun() {
		    	LocalServiceTestHelper helper = new LocalServiceTestHelper(new LocalDatastoreServiceTestConfig());
				helper.setUp();
				
				User testUser = new User();
				ProfileSettings ps = new ProfileSettings();
				
				ps.setFirstName("John");
				ps.setLastName("Doe");
				testUser.setUsername("testID");
				testUser.setSettings(ps);
				
				UserDAO dao = UserDAOFactory.getInstance();
				User resultUser = new User();
				
				try {
					dao.create(testUser);
					resultUser = dao.findById("testID");
				} catch (Exception e) {
					fail("User was not found: " + e.getMessage());
				}
				assertEquals("User was not found", testUser, resultUser);
				helper.tearDown();
		    }
		});
	}
	
	@Test
	public void userWithIdNotFoundTest() {
		ObjectifyService.run(new VoidWork() {
		    public void vrun() {
		    	LocalServiceTestHelper helper = new LocalServiceTestHelper(new LocalDatastoreServiceTestConfig());
				helper.setUp();
				UserDAO dao = UserDAOFactory.getInstance();
				User testUser = new User();
				
				try {
					testUser = dao.findById("testID");
				} catch (Exception e) {
					fail("Exception was thrown. It shouldn't have done that.");
				}
				assertNull("Object was not null", testUser);
				helper.tearDown();
		    }
		});
	}
	
	@Test
	public void findByIdEmptyStringTest() {
		ObjectifyService.run(new VoidWork() {
		    public void vrun() {
		    	LocalServiceTestHelper helper = new LocalServiceTestHelper(new LocalDatastoreServiceTestConfig());
				helper.setUp();
				UserDAO dao = UserDAOFactory.getInstance();
				
				try {
					dao.findById("");
					fail("Test must fail");
				} catch (IllegalArgumentException iae) {
					// Successful test
				} catch (Exception e) {
					fail("Emergency failure. Threw an unexpected exception");
				}
				helper.tearDown();
		    }
		});
	}
	
	@Test
	public void updateUserTest() throws Exception {
		ObjectifyService.run(new VoidWork() {
		    public void vrun() {
		    	LocalServiceTestHelper helper = new LocalServiceTestHelper(new LocalDatastoreServiceTestConfig());
				helper.setUp();
				
				User controlUser = new User();
				User testUser = new User();
				ProfileSettings cps = new ProfileSettings();
				ProfileSettings ps = new ProfileSettings();
				
				cps.setFirstName("Jane");
				cps.setLastName("Doe");
				controlUser.setUsername("otherID");
				controlUser.setSettings(cps);

				ps.setFirstName("John");
				ps.setLastName("Doe");
				testUser.setUsername("testID");
				testUser.setSettings(ps);
				
				UserDAO dao = UserDAOFactory.getInstance();
				User resultUser = null;
				User updateTestUser = null;
				
				try {
					dao.create(controlUser);
					resultUser = dao.create(testUser);
					resultUser.getSettings().setFirstName("Jane");
					updateTestUser = dao.update(resultUser);
				} catch (Exception e) {
					fail("User was not updated " + e.getMessage());
				}
				
				assertEquals("User was not updated. First name differs.", controlUser.getSettings().getFirstName(), updateTestUser.getSettings().getFirstName());
				helper.tearDown();
		    }
		});
	}
	
	@Test
	public void failToUpdateUserTest() throws Exception {
		ObjectifyService.run(new VoidWork() {
		    public void vrun() {
		    	LocalServiceTestHelper helper = new LocalServiceTestHelper(new LocalDatastoreServiceTestConfig());
				helper.setUp();
				
				User testUser = new User();
				ProfileSettings ps = new ProfileSettings();
				
				ps.setFirstName("Jane");
				ps.setLastName("Doe");
				testUser.setUsername("");
				testUser.setSettings(ps);
				
				UserDAO dao = UserDAOFactory.getInstance();
				
				try {
					dao.update(testUser);
					fail("Test must fail");
				} catch (IllegalArgumentException iae) {
					// Successful test
				} catch (Exception e) {
					fail("Emergency failure. Threw an unexpected exception");
				}
				helper.tearDown();
		    }
		});
	}
	
	@Test
	public void deleteUserTest() throws Exception {
		ObjectifyService.run(new VoidWork() {
		    public void vrun() {
		    	LocalServiceTestHelper helper = new LocalServiceTestHelper(new LocalDatastoreServiceTestConfig());
				helper.setUp();
				
				User testUser = new User();
				ProfileSettings ps = new ProfileSettings();
				
				ps.setFirstName("John");
				ps.setLastName("Doe");
				testUser.setUsername("testID");
				testUser.setSettings(ps);
				
				UserDAO dao = UserDAOFactory.getInstance();
				
				User resultUser = null;
				
				try {
					dao.create(testUser);
					dao.delete(testUser.getUsername());
					resultUser = dao.findById(testUser.getUsername());
				} catch (Exception e) {
					System.out.println("Something went very wrong");
				}
				assertNull("User was found when they should have been deleted", resultUser);
				helper.tearDown();
		    }
		});
	}
	
	@Test
	public void failToDeleteUserTest() throws Exception {
		ObjectifyService.run(new VoidWork() {
		    public void vrun() {
		    	LocalServiceTestHelper helper = new LocalServiceTestHelper(new LocalDatastoreServiceTestConfig());
				helper.setUp();
				
				User testUser = new User();
				ProfileSettings ps = new ProfileSettings();
				
				ps.setFirstName("John");
				ps.setLastName("Doe");
				testUser.setUsername("testID");
				testUser.setSettings(ps);
				
				UserDAO dao = UserDAOFactory.getInstance();
				
				try {
					dao.create(testUser);
					dao.delete("");
				} catch (IllegalArgumentException iae) {
					// Successful test
				} catch (Exception e) {
					fail("Emergency failure. Threw an unexpected exception");
				}
				helper.tearDown();
		    }
		});
	}
}
