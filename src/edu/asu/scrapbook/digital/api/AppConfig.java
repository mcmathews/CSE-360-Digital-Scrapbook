package edu.asu.scrapbook.digital.api;

import org.glassfish.jersey.server.ResourceConfig;

public class AppConfig extends ResourceConfig {
	
	public AppConfig() {
		register(UserResource.class);
		register(ImageResource.class);
	}
	
}
