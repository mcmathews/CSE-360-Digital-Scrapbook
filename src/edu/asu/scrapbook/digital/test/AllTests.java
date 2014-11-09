package edu.asu.scrapbook.digital.test;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class)
@SuiteClasses({ DigitalScrapbookUnitTest.class, DatastoreUserTest.class, ImageResourceTest.class, UserResourceTest.class, UserUtilTest.class })
public class AllTests {}
