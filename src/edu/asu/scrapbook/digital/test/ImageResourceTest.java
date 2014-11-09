package edu.asu.scrapbook.digital.test;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.google.appengine.tools.development.testing.LocalDatastoreServiceTestConfig;
import com.google.appengine.tools.development.testing.LocalServiceTestHelper;
import com.google.appengine.tools.development.testing.LocalUserServiceTestConfig;
import com.googlecode.objectify.ObjectifyService;
import com.googlecode.objectify.Ref;
import com.googlecode.objectify.VoidWork;

import edu.asu.scrapbook.digital.api.ImageResource;
import edu.asu.scrapbook.digital.dao.ImageDAO;
import edu.asu.scrapbook.digital.dao.ImageDAOFactory;
import edu.asu.scrapbook.digital.dao.UserDAO;
import edu.asu.scrapbook.digital.dao.UserDAOFactory;
import edu.asu.scrapbook.digital.model.Image;
import edu.asu.scrapbook.digital.model.User;

public class ImageResourceTest {
	
	private ImageResource imageResource;
	
	@Before
	public void setUp() throws Exception {
		imageResource = new ImageResource();
	}
	
	@After
	public void tearDown() throws Exception {
	}
	
	@Test
	public void getUserImagesTest() {
		ObjectifyService.run(new VoidWork() {
		    public void vrun() {
		    	LocalServiceTestHelper helper = new LocalServiceTestHelper(new LocalUserServiceTestConfig(), new LocalDatastoreServiceTestConfig())
		    			.setEnvIsLoggedIn(true).setEnvAuthDomain("test").setEnvEmail("test@test.com");
				helper.setUp();
				
				User user = new User();
				user.setUsername("test@test.com");
				
				Image image1 = TestUtil.getTestImage(1000);
				Image image2 = TestUtil.getTestImage(1001);
				
				List<Ref<Image>> images = new ArrayList<>();
				
				UserDAO userDAO = UserDAOFactory.getInstance();
				ImageDAO imageDAO = ImageDAOFactory.getInstance();
				try {
					imageDAO.create(image1);
					imageDAO.create(image2);
					
					images.add(Ref.create(image1));
					images.add(Ref.create(image2));
					user.setImages(images);
					
					userDAO.create(user);
					
				} catch (Exception e) {
					throw new RuntimeException("DAOs failed initial setup: " + e);
				}
				
				List<Image> testImages = new ArrayList<>();
				testImages.add(image1);
				testImages.add(image2);
				assertEquals("User images created was not equal to user images retrieved", testImages, imageResource.getUserImages());
			
				helper.tearDown();
		    }
		});
	}
	
	@Test
	public void getImageNotFoundTest() {
		ObjectifyService.run(new VoidWork() {
		    public void vrun() {
		    	LocalServiceTestHelper helper = new LocalServiceTestHelper(new LocalUserServiceTestConfig(), new LocalDatastoreServiceTestConfig())
		    			.setEnvIsLoggedIn(true).setEnvAuthDomain("test").setEnvEmail("test@test.com");
				helper.setUp();
				
				User user = new User();
				user.setUsername("test@test.com");
				
				UserDAO userDAO = UserDAOFactory.getInstance();
				try {
					userDAO.create(user);
					
				} catch (Exception e) {
					throw new RuntimeException("DAOs failed initial setup: " + e);
				}
				
				assertNull("User image not null when none existed", imageResource.getImage(1234));
			
				helper.tearDown();
		    }
		});
	}
	
	@Test
	public void getImageTest() {
		ObjectifyService.run(new VoidWork() {
		    public void vrun() {
		    	LocalServiceTestHelper helper = new LocalServiceTestHelper(new LocalUserServiceTestConfig(), new LocalDatastoreServiceTestConfig())
		    			.setEnvIsLoggedIn(true).setEnvAuthDomain("test").setEnvEmail("test@test.com");
				helper.setUp();
				
				User user = new User();
				user.setUsername("test@test.com");
				
				long imageId = 1000L;
				Image image = TestUtil.getTestImage(imageId);
				
				List<Ref<Image>> images = new ArrayList<>();
				images.add(Ref.create(image));
				
				user.setImages(images);
				
				UserDAO userDAO = UserDAOFactory.getInstance();
				ImageDAO imageDAO = ImageDAOFactory.getInstance();
				try {
					userDAO.create(user);
					imageDAO.create(image);
					
				} catch (Exception e) {
					throw new RuntimeException("DAOs failed initial setup: " + e);
				}
				
				assertEquals("Incorrect image returned", image, imageResource.getImage(imageId));
			
				helper.tearDown();
		    }
		});
	}
}
