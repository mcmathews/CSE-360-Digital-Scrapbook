package edu.asu.scrapbook.digital.model;

import java.util.List;

import com.googlecode.objectify.Ref;
import com.googlecode.objectify.annotation.Entity;
import com.googlecode.objectify.annotation.Id;

@Entity
public class User {
	@Id private String username;
	private ProfileSettings settings;
	private List<Ref<Image>> images;
	
	public User() {}
	
	public String getUsername() {
		return username;
	}
	
	public void setUsername(String username) {
		this.username = username;
	}
	
	public ProfileSettings getSettings() {
		return settings;
	}
	
	public void setSettings(ProfileSettings settings) {
		this.settings = settings;
	}

	public List<Ref<Image>> getImages() {
		return images;
	}

	public void setImages(List<Ref<Image>> images) {
		this.images = images;
	}
	
}