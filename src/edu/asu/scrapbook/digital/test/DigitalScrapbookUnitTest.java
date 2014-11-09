package edu.asu.scrapbook.digital.test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import org.junit.Test;

import com.google.appengine.tools.development.testing.LocalDatastoreServiceTestConfig;
import com.google.appengine.tools.development.testing.LocalServiceTestHelper;
import com.googlecode.objectify.ObjectifyService;
import com.googlecode.objectify.VoidWork;

import edu.asu.scrapbook.digital.dao.UserDAO;
import edu.asu.scrapbook.digital.dao.UserDAOFactory;
import edu.asu.scrapbook.digital.model.ProfileSettings;
import edu.asu.scrapbook.digital.model.User;

public class DigitalScrapbookUnitTest {
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
				User resultUser = new User();
				
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
}
