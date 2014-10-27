<!DOCTYPE html>
<html>

<head>
    <meta charset="UTF-8">
    <title>profilePage</title>

    <%@ include file="/include/cssimports.jsp" %>

        <link rel="stylesheet" type="text/css" href="/css/profile-style.css" />
        <link rel="stylesheet" type="text/css" href="/css/main.css" />



</head>

<body>

    <%@ include file="/include/header.jsp" %>

        <h2 style="padding-top:50px">My Profile</h2>

        <div class="container" style="padding-top: 100px">
            <div class="row">


                <div class="col-md-12">
                    <div clas="col-md-6">
                        <div class="col-xs-12 col-sm-6 col-md-6">
                            <div class="well well-sm">
                                <div class="row">
                                    <div class="col-sm-6 col-md-4">
                                        <img src="http://placehold.it/380x500" alt="" class="img-rounded img-responsive" />
                                    </div>
                                    <div class="col-sm-6 col-md-8">
                                        <h3><span class="profile-text">User Name</span></h3>
                                        <p>
                                            <span class="profile-text">email@example.com</span>
                                        </p>
                                        <a href="profile-settings.jsp">
                                            <button class="btn btn-inverse btn-small">Edit Profile Picture</button>
                                        </a>
                                    </div>
                                </div>
                            </div>

                            <a href="#" class="btn btn-default btn-lg">Upload A Photo To Your ScrapBook</a>
                        </div>
                    </div>
                    <div class="col-md-6">
                        <h3>Photos Go Here</h3>
                        <!-- THIS DIV HOLDS SPACE FOR PHOTO TABLE -->
                    </div>
                </div>


            </div>
        </div>



</body>

</html>
