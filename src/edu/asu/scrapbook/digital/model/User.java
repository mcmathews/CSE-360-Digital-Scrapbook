package edu.asu.scrapbook.digital.model;

public class User {
	private String username;
	private ProfileSettings settings;
	
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
	
}