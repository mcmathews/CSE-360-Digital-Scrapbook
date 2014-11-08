package edu.asu.scrapbook.digital.model;

import com.google.appengine.api.blobstore.BlobKey;
import com.googlecode.objectify.annotation.Entity;
import com.googlecode.objectify.annotation.Id;

@Entity
public class Image {
	
	@Id
	private Long id;
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
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((blobKey == null) ? 0 : blobKey.hashCode());
		result = prime * result + ((datastoreLink == null) ? 0 : datastoreLink.hashCode());
		result = prime * result + ((filename == null) ? 0 : filename.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((title == null) ? 0 : title.hashCode());
		return result;
	}
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (!(obj instanceof Image))
			return false;
		Image other = (Image) obj;
		if (blobKey == null) {
			if (other.blobKey != null)
				return false;
		} else if (!blobKey.equals(other.blobKey))
			return false;
		if (datastoreLink == null) {
			if (other.datastoreLink != null)
				return false;
		} else if (!datastoreLink.equals(other.datastoreLink))
			return false;
		if (filename == null) {
			if (other.filename != null)
				return false;
		} else if (!filename.equals(other.filename))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (title == null) {
			if (other.title != null)
				return false;
		} else if (!title.equals(other.title))
			return false;
		return true;
	}
}
