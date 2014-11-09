package edu.asu.scrapbook.digital.test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.fail;

import org.junit.Test;

import com.google.appengine.tools.development.testing.LocalDatastoreServiceTestConfig;
import com.google.appengine.tools.development.testing.LocalServiceTestHelper;
import com.googlecode.objectify.ObjectifyService;
import com.googlecode.objectify.VoidWork;

import edu.asu.scrapbook.digital.dao.ImageDAO;
import edu.asu.scrapbook.digital.dao.ImageDAOFactory;
import edu.asu.scrapbook.digital.model.Image;

public class DatastoreImageTest {

	@Test
	public void createImageTest() throws Exception {
		ObjectifyService.run(new VoidWork() {
		    public void vrun() {
		    	LocalServiceTestHelper helper = new LocalServiceTestHelper(new LocalDatastoreServiceTestConfig());
				helper.setUp();
				
				Image testImage = new Image();
				Long testLong = new Long(1234567890);
				testImage.setId(testLong);
				
				ImageDAO dao = ImageDAOFactory.getInstance();
				Image resultImage = null;
				
				try {
					resultImage = dao.create(testImage);
				} catch (Exception e) {
					fail("image could not be created: " + e.getMessage());
				}
				
				assertEquals("Created Image differs from returned Image", testImage, resultImage);
				helper.tearDown();
		    }
		});
	}
	
	@Test
	public void foundImageTest() throws Exception {
		ObjectifyService.run(new VoidWork() {
		    public void vrun() {
		    	LocalServiceTestHelper helper = new LocalServiceTestHelper(new LocalDatastoreServiceTestConfig());
				helper.setUp();
				
				Image testImage = new Image();
				Long testID = new Long(1234567890);
				testImage.setId(testID);
				
				ImageDAO dao = ImageDAOFactory.getInstance();
				Image resultimage = new Image();
				
				try {
					dao.create(testImage);
					resultimage = dao.findById(testImage.getId());
				} catch (Exception e) {
					fail("image was not found: " + e.getMessage());
				}
				assertEquals("image was not found", testImage, resultimage);
				helper.tearDown();
		    }
		});
	}
	
	@Test
	public void imageWithIdNotFoundTest() {
		ObjectifyService.run(new VoidWork() {
		    public void vrun() {
		    	LocalServiceTestHelper helper = new LocalServiceTestHelper(new LocalDatastoreServiceTestConfig());
				helper.setUp();
				ImageDAO dao = ImageDAOFactory.getInstance();
				
				Image testImage = null;
				Long testID = new Long(1234567890);
				
				try {
					testImage = dao.findById(testID);
				} catch (Exception e) {
					fail("Exception was thrown. It shouldn't have done that.");
				}
				assertNull("Object was not null", testImage);
				helper.tearDown();
		    }
		});
	}
	
	@Test
	public void findByIdEmptyLongTest() {
		ObjectifyService.run(new VoidWork() {
		    public void vrun() {
		    	LocalServiceTestHelper helper = new LocalServiceTestHelper(new LocalDatastoreServiceTestConfig());
				helper.setUp();
				ImageDAO dao = ImageDAOFactory.getInstance();
				Long testID = null;
				try {
					dao.findById(testID);
					fail("Test must fail");
				} catch (NullPointerException npe) {
					// Successful test
				} catch (Exception e) {
					fail("Emergency failure. Threw an unexpected exception");
				}
				helper.tearDown();
		    }
		});
	}
	
	@Test
	public void updateImageTest() throws Exception {
		ObjectifyService.run(new VoidWork() {
		    public void vrun() {
		    	LocalServiceTestHelper helper = new LocalServiceTestHelper(new LocalDatastoreServiceTestConfig());
				helper.setUp();
				
				Image controlImage = new Image();
				Image testImage = new Image();
				Long cid = new Long(1234567890);
				Long tid = new Long(1234123451);
				
				controlImage.setId(cid);
				controlImage.setTitle("test update");
				testImage.setId(tid);
				
				ImageDAO dao = ImageDAOFactory.getInstance();
				Image resultimage = null;
				Image updateTestImage = null;
				
				try {
					dao.create(controlImage);
					resultimage = dao.create(testImage);
					resultimage.setTitle("test update");
					updateTestImage = dao.update(resultimage);
				} catch (Exception e) {
					fail("image was not updated " + e.getMessage());
				}
				
				assertEquals("image was not updated. First name differs.", controlImage.getTitle(), updateTestImage.getTitle());
				helper.tearDown();
		    }
		});
	}
	
	@Test
	public void deleteimageTest() throws Exception {
		ObjectifyService.run(new VoidWork() {
		    public void vrun() {
		    	LocalServiceTestHelper helper = new LocalServiceTestHelper(new LocalDatastoreServiceTestConfig());
				helper.setUp();
				
				Image testImage = new Image();
				Long tid = new Long(1234567890);
				
				testImage.setId(tid);
				
				ImageDAO dao = ImageDAOFactory.getInstance();
				
				Image resultimage = null;
				
				try {
					dao.create(testImage);
					dao.delete(testImage.getId());
					resultimage = dao.findById(testImage.getId());
				} catch (Exception e) {
					System.out.println("Something went very wrong");
				}
				assertNull("image was found when they should have been deleted", resultimage);
				helper.tearDown();
		    }
		});
	}
}
