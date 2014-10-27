package edu.asu.scrapbook.digital.model;

import com.google.appengine.api.blobstore.BlobKey;
import com.googlecode.objectify.annotation.Entity;
import com.googlecode.objectify.annotation.Id;

@Entity
public class Image {
	
	@Id private Long id;
	private String title;
	private String filename;
	private String datastoreLink;
	private BlobKey blobKey;
	
	public Long getId() {
		return id;
	}
	
	public void setId(Long id) {
		this.id = id;
	}
	
	public String getTitle() {
		return title;
	}
	
	public void setTitle(String title) {
		this.title = title;
	}
	
	public String getFilename() {
		return filename;
	}
	
	public void setFilename(String filename) {
		this.filename = filename;
	}

	public String getDatastoreLink() {
		return datastoreLink;
	}

	public void setDatastoreLink(String datastoreLink) {
		this.datastoreLink = datastoreLink;
	}

	public BlobKey getBlobKey() {
		return blobKey;
	}

	public void setBlobKey(BlobKey blobKey) {
		this.blobKey = blobKey;
	}
}
