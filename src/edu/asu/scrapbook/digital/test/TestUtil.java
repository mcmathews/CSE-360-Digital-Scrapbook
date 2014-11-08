package edu.asu.scrapbook.digital.test;

import edu.asu.scrapbook.digital.model.ProfileSettings;
import edu.asu.scrapbook.digital.model.User;

public class TestUtil {
	
	public static User clone(User user) {
		User clonedUser = null;
		if (user != null) {
			clonedUser = new User();
			clonedUser.setUsername(user.getUsername());
			if (user.getSettings() != null) {
				ProfileSettings settings = new ProfileSettings();
				settings.setFirstName(user.getSettings().getFirstName());
				settings.setLastName(user.getSettings().getLastName());
				settings.setProfileImage(user.getSettings().getProfileImage());
				clonedUser.setSettings(settings);
			}
		}
		
		return clonedUser;
	}
}
