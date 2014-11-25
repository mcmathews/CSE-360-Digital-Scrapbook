#CSE-360-Digital-Scrapbook
=========================

##How to install and setup the app.

1. There is some required software in order to setup this project.
Ensure you have Eclipse along with the Google App Engine and EGit plugins installed.
Instructions for installing the GAE plugin for Eclipse can be found here:
https://cloud.google.com/appengine/docs/java/tools/eclipse

2. In order to add the project to Eclipse, go to File -> Import and under Git select Projects from Git.
3. Enter the following url to clone the repository: https://github.com/mcmathews/CSE-360-Digital-Scrapbook.git
4. Add all of the jars in /war/WEB-INF/lib directory to the build path.
5. Ensure the proper src directory is set as the project source directory (which would be /src).
6. Ensure under Project properties -> Google, Use App Engine is checked.
7. You should be good to go!

============================

##Running Tests

###Unit Tests

Once the app is set up in eclipse, the JUnit tests can be run through the Eclipse.
Running the AllTests.java test suite will run all the unit tests.

###Functional Tests

1. The Functional Tests we're written using Selenium IDE, so this plugin is required for Firefox to run the tests.
2. In Firefox, make sure to log out of all Google Services before continuing.
3. In Firefox, go to http://accounts.google.com and sign in with the username: CSE.360.Project.Test.User@gmail.com and the password: mUOkM9$#3c6P8KMXRAWP&59r!JcMQoSaEYWF
4. Then log out of Google.  
5. Now open Selenium IDE
6. Open the test suite in the project folder in /war/tests/FunctionalTestSuite.html
7. Make sure to set the slider in the top left corner of the Selenium IDE to "Slow"
8. Run the Suite.
