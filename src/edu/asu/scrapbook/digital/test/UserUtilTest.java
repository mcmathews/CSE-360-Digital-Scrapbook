package edu.asu.scrapbook.digital.test;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.google.appengine.tools.development.testing.LocalServiceTestHelper;
import com.google.appengine.tools.development.testing.LocalUserServiceTestConfig;

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
		fail("Not yet implemented");
	}
	
}
