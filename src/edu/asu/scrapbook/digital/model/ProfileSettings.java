package edu.asu.scrapbook.digital.model;

import com.googlecode.objectify.Ref;

public class ProfileSettings {
	
	private String firstName;
	private String lastName;
	private Ref<Image> profileImageRef;
	
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
		return (profileImageRef != null) ? profileImageRef.get() : null;
	}
	
	public void setProfileImage(Image profileImage) {
		this.profileImageRef = (profileImage != null) ? Ref.create(profileImage) : null;
	}
}
