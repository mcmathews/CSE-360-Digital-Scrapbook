package edu.asu.scrapbook.digital.rest;

import org.glassfish.jersey.server.ResourceConfig;

public class AppConfig extends ResourceConfig {
	
	public AppConfig() {
		register(UserResource.class);
	}
	
}
