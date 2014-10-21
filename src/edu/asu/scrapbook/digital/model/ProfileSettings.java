package edu.asu.scrapbook.digital.model;

public class ProfileSettings {
	
	private String firstName;
	private String lastName;
	private Image profileImage;
	
	public String getFirstName() {
		return firstName;
	}
	
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	
	public String getLastName() {
		return lastName;
	}
	
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	
	public Image getProfileImage() {
		return profileImage;
	}
	
	public void setProfileImage(Image profileImage) {
		this.profileImage = profileImage;
	}
}
