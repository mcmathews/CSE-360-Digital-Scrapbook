package edu.asu.scrapbook.digital.test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import com.google.appengine.tools.development.testing.LocalDatastoreServiceTestConfig;
import com.google.appengine.tools.development.testing.LocalServiceTestHelper;
import com.google.appengine.tools.development.testing.LocalUserServiceTestConfig;
import com.googlecode.objectify.ObjectifyService;
import com.googlecode.objectify.VoidWork;

import edu.asu.scrapbook.digital.dao.UserDAO;
import edu.asu.scrapbook.digital.dao.UserDAOFactory;
import edu.asu.scrapbook.digital.model.User;
import edu.asu.scrapbook.digital.util.UserUtil;

public class UserUtilTest {
	
	@Test
	public void testGetRequestUsername() {
		LocalServiceTestHelper helper = new LocalServiceTestHelper(new LocalUserServiceTestConfig())
				.setEnvIsLoggedIn(true).setEnvAuthDomain("test").setEnvEmail("test@test.com");
		helper.setUp();
		
		assertEquals("Request username not correct", UserUtil.getRequestUsername(), "test@test.com");
		
		helper.tearDown();
	}
	
	@Test
	public void testGetRequestUsernameNotSignedIn() {
		LocalServiceTestHelper helper = new LocalServiceTestHelper(new LocalUserServiceTestConfig());
		helper.setUp();
		
		assertNull("Request username not correct", UserUtil.getRequestUsername());
		
		helper.tearDown();
	}
	
	@Test
	public void testUserExists() {
		ObjectifyService.run(new VoidWork() {
		    public void vrun() {
		    	LocalServiceTestHelper helper = new LocalServiceTestHelper(new LocalDatastoreServiceTestConfig());
				helper.setUp();
				
				User user = new User();
				user.setUsername("test@test.com");
				
				UserDAO userDAO = UserDAOFactory.getInstance();
				try {
					userDAO.create(user);
					assertTrue("userExists() returned false negative", UserUtil.userExists("test@test.com"));
				} catch (Exception e) {
					throw new RuntimeException("UserDAO failed: " + e);
				}
				
				helper.tearDown();
		    }
		});
	}
	
	@Test
	public void testUserDoesNotExists() {
		ObjectifyService.run(new VoidWork() {
		    public void vrun() {
		    	LocalServiceTestHelper helper = new LocalServiceTestHelper(new LocalDatastoreServiceTestConfig());
				helper.setUp();
				
				try {
					assertFalse("userExists() returned false positive", UserUtil.userExists("test@test.com"));
				} catch (Exception e) {
					throw new RuntimeException("UserDAO failed: " + e);
				}
				
				helper.tearDown();
		    }
		});
	}
	
}
