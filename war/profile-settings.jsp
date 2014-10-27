<!DOCTYPE html>
<html>

<head>
    <meta charset="UTF-8">
    <title>profilePage</title>

    <%@ include file="/include/cssimports.jsp" %>

        <link rel="stylesheet" type="text/css" href="/css/profile-settings-style.css" />
        <link rel="stylesheet" type="text/css" href="/css/main.css" />

</head>

<body>

    <%@ include file="/include/header.jsp" %>

        <h2 style="padding-top:50px">Update or Add Profile Picture</h2>

        <div class="container" style="padding-top: 100px">
            <div class="row">


                <div class="col-md-12">
                    <div class="col-md-6">
                        <h2><span class = "test">Upload New Profile Photo</span></h2> 

                        <div class="button-move">
                            <a href="#" class="btn btn-default">Select A Profile Image To Upload</a>
                        </div>

                        <div class="button-move">
                            <a href="#" class="btn btn-default">Save Profile Image</a>
                        </div>

                    </div>
                    <div class="col-md-6">
                        <div class="shiftpicture">
                            <img src="http://placehold.it/380x500" alt="" class="img-rounded img-responsive" />
                        </div>
                    </div>


                </div>
            </div>

</body>

</html>
