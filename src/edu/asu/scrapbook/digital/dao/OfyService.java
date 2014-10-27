package edu.asu.scrapbook.digital.dao;

import com.googlecode.objectify.Objectify;
import com.googlecode.objectify.ObjectifyFactory;
import com.googlecode.objectify.ObjectifyService;

import edu.asu.scrapbook.digital.model.User;
import edu.asu.scrapbook.digital.model.Image;

public class OfyService {
	static {
		factory().register(User.class);
		factory().register(Image.class);
	}
	
	public static Objectify ofy() {
		return ObjectifyService.ofy();
	}
	
	public static ObjectifyFactory factory() {
		return ObjectifyService.factory();
	}
}
