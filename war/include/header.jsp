<%@ page import="com.google.appengine.api.users.UserService, com.google.appengine.api.users.UserServiceFactory" %>
<% UserService us = UserServiceFactory.getUserService(); %>
<div id="header">
    <div class="navbar navbar-inverse navbar-fixed-top" role="navigation">
        <div class="container">
            <div class="navbar-header">
                <a style="color: white" class="navbar-brand">MyDigitalScrapBook</a>
            </div>

            <div style="padding-top: 8px" class="move-up">
                <div class="move-right">
                    <a href="<%= us.createLogoutURL("/") %>" type="button" class="btn btn-default ">Logout</a>
                </div>
            </div>
        </div>
        <!--/.nav-collapse -->
    </div>
</div>


