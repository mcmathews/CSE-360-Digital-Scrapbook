<!DOCTYPE html>
<html>

<head>
    <meta charset="UTF-8">
    <title>profilePage</title>

    <%@ include file="/include/cssimports.jsp" %>

        <link rel="stylesheet" type="text/css" href="/css/upload-image-style.css" />
        <link rel="stylesheet" type="text/css" href="/css/main.css" />

</head>

<body>

    <%@ include file="/include/header.jsp" %>

        <h1 style="padding-top:50px">Add An Image To Your ScrapBook</h1>

        <div class="container" style="padding-top: 100px">
            <div class="row">


                <div class="col-md-12">
                    <h2><span class = "test">Upload New Profile Photo</span></h2> 

                    <div class="col-md-12">
                        <div class="button-move">
                            <div class="center-input">
                                <input type="file" />
                            </div>
                        </div>
                    </div>

                    <div class="col-md-6">
                        <div class="button-move">
                            <input class="form-control input-group-lg" type="text" title="PhotoTitle" placeholder="Enter A Title For Your Photo" />
                        </div>
                    </div>

                    <div class="col-md-6">
                        <div class="button-move">
                            <a href="#" class="btn btn-default">Save Image To Your Scrapbook</a>
                        </div>
                    </div>
                </div>
            </div>

</body>

</html>
