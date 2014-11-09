CSE-360-Digital-Scrapbook
=========================

How to install and setup the app.

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