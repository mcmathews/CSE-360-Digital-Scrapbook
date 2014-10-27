package edu.asu.scrapbook.digital.dao;

public class ImageDAOFactory {
	public static ImageDAO getInstance() {
		return new BlobstoreImageDAOImpl();
	}
}
