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

        <h1 style="padding-top:50px">Update or Add Profile Picture</h1>

        <div class="container" style="padding-top: 100px">
            <div class="row">


                <div class="col-md-12">
                        <h2>Upload New Profile Photo</h2> 
                    
                    
                    <form action="{%=uploadUrl}" method="get">
                        
                        <input value="true" type="hidden" name="isProfileImage" />
                        
                        <div class="button-move">
                            <div class="center-input"> 
                                <input type="file"/>
                            </div>
                        </div>
                        <div class="button-move">
                            <button type="submit" class="btn btn-default">Save Profile Image</button>
                        </div>
                    </form>

                </div>
            </div>

</body>

</html>
