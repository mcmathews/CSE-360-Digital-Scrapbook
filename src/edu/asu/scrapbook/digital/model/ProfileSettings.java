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

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((firstName == null) ? 0 : firstName.hashCode());
		result = prime * result + ((lastName == null) ? 0 : lastName.hashCode());
		result = prime * result + ((profileImageRef == null) ? 0 : profileImageRef.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ProfileSettings other = (ProfileSettings) obj;
		if (firstName == null) {
			if (other.firstName != null)
				return false;
		} else if (!firstName.equals(other.firstName))
			return false;
		if (lastName == null) {
			if (other.lastName != null)
				return false;
		} else if (!lastName.equals(other.lastName))
			return false;
		if (profileImageRef == null) {
			if (other.profileImageRef != null)
				return false;
		} else if (!profileImageRef.equals(other.profileImageRef))
			return false;
		return true;
	}
}
