package edu.asu.scrapbook.digital.test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import javax.ws.rs.BadRequestException;
import javax.ws.rs.ClientErrorException;
import javax.ws.rs.NotFoundException;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.google.appengine.tools.development.testing.LocalDatastoreServiceTestConfig;
import com.google.appengine.tools.development.testing.LocalServiceTestHelper;
import com.google.appengine.tools.development.testing.LocalUserServiceTestConfig;
import com.googlecode.objectify.ObjectifyService;
import com.googlecode.objectify.VoidWork;

import edu.asu.scrapbook.digital.api.UserResource;
import edu.asu.scrapbook.digital.dao.UserDAO;
import edu.asu.scrapbook.digital.dao.UserDAOFactory;
import edu.asu.scrapbook.digital.model.ProfileSettings;
import edu.asu.scrapbook.digital.model.User;

public class UserResourceTest {
	
	private UserResource userResource;
	
	@Before
	public void setUp() throws Exception {
		userResource = new UserResource();
	}
	
	@After
	public void tearDown() throws Exception {
	}
	
	@Test
	public void testCreateUser() {
		ObjectifyService.run(new VoidWork() {
		    public void vrun() {
		    	LocalServiceTestHelper helper = new LocalServiceTestHelper(new LocalUserServiceTestConfig(), new LocalDatastoreServiceTestConfig())
		    			.setEnvIsLoggedIn(true).setEnvAuthDomain("test").setEnvEmail("test@test.com");
				helper.setUp();
				
				User user = new User();
				ProfileSettings ps = new ProfileSettings();
				ps.setFirstName("John");
				ps.setLastName("Doe");
				user.setSettings(ps);
				
				User controlUser = TestUtil.clone(user);
				controlUser.setUsername("test@test.com");
				
				User resultUser = userResource.createUser(user);
				
				assertEquals("User returned does not match user given", controlUser, resultUser);
				
				helper.tearDown();
		    }
		});
	}
	
	@Test
	public void testCreateAlreadyExistingUser() {
		ObjectifyService.run(new VoidWork() {
		    public void vrun() {
		    	LocalServiceTestHelper helper = new LocalServiceTestHelper(new LocalUserServiceTestConfig(), new LocalDatastoreServiceTestConfig())
		    			.setEnvIsLoggedIn(true).setEnvAuthDomain("test").setEnvEmail("test1@test1.com");
				helper.setUp();
				
				User user = new User();
				ProfileSettings ps = new ProfileSettings();
				ps.setFirstName("John");
				ps.setLastName("Doe");
				user.setUsername("test1@test1.com");
				user.setSettings(ps);
				
				UserDAO userDAO = UserDAOFactory.getInstance();
				try {
					userDAO.create(user);
				} catch (Exception e) {
					throw new RuntimeException("UserDAO create failed to create initial setup user: " + e);
				}
				
				try {
					userResource.createUser(user);
					fail("Create user didn't throw an exception");
					
				} catch (BadRequestException e) {
					// Success
				} catch (Exception e) {
					fail("Wrong exception thrown: " + e);
				}
				
				helper.tearDown();
		    }
		});
	}

	@Test(expected = BadRequestException.class)
	public void testCreateUserNullUser() {
		LocalServiceTestHelper helper = new LocalServiceTestHelper(new LocalUserServiceTestConfig())
			.setEnvIsLoggedIn(true).setEnvAuthDomain("test").setEnvEmail("test@test.com");
		helper.setUp();
		
		userResource.createUser(null);
		
		helper.tearDown();
	}
	
	@Test(expected = BadRequestException.class)
	public void testCreateUserNullProfileSettings() {
		LocalServiceTestHelper helper = new LocalServiceTestHelper(new LocalUserServiceTestConfig())
			.setEnvIsLoggedIn(true).setEnvAuthDomain("test").setEnvEmail("test@test.com");
		helper.setUp();
		
		User user = new User();
		user.setSettings(null);
		userResource.createUser(user);
		
		helper.tearDown();
	}
	
	@Test
	public void testGetUser() {
		ObjectifyService.run(new VoidWork() {
		    public void vrun() {
		    	LocalServiceTestHelper helper = new LocalServiceTestHelper(new LocalUserServiceTestConfig(), new LocalDatastoreServiceTestConfig())
		    			.setEnvIsLoggedIn(true).setEnvAuthDomain("test").setEnvEmail("test@test.com");
				helper.setUp();
				
				User user = new User();
				ProfileSettings ps = new ProfileSettings();
				ps.setFirstName("John");
				ps.setLastName("Doe");
				user.setUsername("test@test.com");
				user.setSettings(ps);
				
				User controlUser = TestUtil.clone(user);
				
				UserDAO userDAO = UserDAOFactory.getInstance();
				try {
					userDAO.create(user);
				} catch (Exception e) {
					throw new RuntimeException("UserDAO failed to create initial setup user: " + e);
				}
				
				assertEquals("User created was not equal to user from get", controlUser, userResource.getUser());
			
				helper.tearDown();
		    }
		});
	}
	
	@Test
	public void testUpdateUser() {

		ObjectifyService.run(new VoidWork() {
		    public void vrun() {
		    	LocalServiceTestHelper helper = new LocalServiceTestHelper(new LocalUserServiceTestConfig(), new LocalDatastoreServiceTestConfig())
		    			.setEnvIsLoggedIn(true).setEnvAuthDomain("test").setEnvEmail("test@test.com");
				helper.setUp();
				
				User user = new User();
				ProfileSettings ps = new ProfileSettings();
				ps.setFirstName("John");
				ps.setLastName("Doe");
				user.setUsername("test@test.com");
				user.setSettings(ps);
				
				UserDAO userDAO = UserDAOFactory.getInstance();
				try {
					userDAO.create(user);
				} catch (Exception e) {
					throw new RuntimeException("UserDAO create failed to create initial setup user: " + e);
				}

				User modifiedUser = new User();
				ProfileSettings modifiedPs = new ProfileSettings();
				modifiedPs.setFirstName("Jane");
				modifiedPs.setLastName("Doe");
				modifiedUser.setUsername("test@test.com");
				modifiedUser.setSettings(modifiedPs);

				User controlUser = TestUtil.clone(modifiedUser);
				
				try {
					User updatedUser = userResource.updateUser(modifiedUser);
					assertEquals("User not updated", updatedUser, controlUser);
				} catch (ClientErrorException e) {
					fail(e.getMessage());
				} catch (Exception e) {
					throw new RuntimeException(e);
				}
				
				helper.tearDown();
		    }
		});
	}

	@Test(expected = BadRequestException.class)
	public void testUpdateUserNullUser() {
		LocalServiceTestHelper helper = new LocalServiceTestHelper(new LocalUserServiceTestConfig())
			.setEnvIsLoggedIn(true).setEnvAuthDomain("test").setEnvEmail("test@test.com");
		helper.setUp();
		
		userResource.createUser(null);
		
		helper.tearDown();
	}
	
	@Test
	public void testUpdateUserNotFound() {
		ObjectifyService.run(new VoidWork() {
		    public void vrun() {
		    	LocalServiceTestHelper helper = new LocalServiceTestHelper(new LocalUserServiceTestConfig(), new LocalDatastoreServiceTestConfig())
		    			.setEnvIsLoggedIn(true).setEnvAuthDomain("test").setEnvEmail("test@test.com");
				helper.setUp();

				User user = new User();
				
				try {
					userResource.updateUser(user);
					fail("Exception should have been thrown");
					
				} catch (NotFoundException e) {
					// Success
				} catch (Exception e) {
					fail("Wrong exception thrown: " + e);
				}
				
				helper.tearDown();
		    }
		});
	}
}
