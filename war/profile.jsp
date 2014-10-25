<!DOCTYPE html>
<html>

<head>
<meta charset="UTF-8">
<title>profilePage</title>
    
<link rel="stylesheet" type="text/css" href="/css/lib/bootstrap.css" />
<link rel="stylesheet" type="text/css"
	href="/css/lib/bootstrap-theme.css" />

<!-- Custom styles for this template -->
<link href="http://getbootstrap.com/dist/css/bootstrap.min.css"
	rel="stylesheet">
<link href="http://getbootstrap.com/examples/cover/cover.css"
	rel="stylesheet">
    

<script src="/js/lib/jquery-2.1.1.js" type="text/javascript"></script>
<script src="/js/lib/bootstrap.js" type="text/javascript"></script>
    <link rel="stylesheet" type="text/css" href="/css/profile-style.css" />
        <link rel="stylesheet" type="text/css" href="/css/main.css" />

    

</head>

<body>
        
    <%@ include file="/include/header.jsp" %> 

<div class="container" style="padding-top: 200px">
    <div class="row">
    <div class = "col-md-12">
        <div class="col-xs-12 col-sm-6 col-md-6">
            <div class="well well-sm">
                <div class="row">
                    <div class="col-sm-6 col-md-4">
                        <img src="http://placehold.it/380x500" alt="" class="img-rounded img-responsive" />
                    </div>
                    <div class="col-sm-6 col-md-8">
                        <h3><span class="profile-text">User Name</span></h3>
                        <p>
                    <i class="glyphicon glyphicon-envelope"></i> <span class="profile-text"> email@example.com</span>
                        </p>
                        
                        <button class="btn btn-inverse btn-small">Edit Profile Picture</button>
                    </div>
                </div>
            </div>
        </div>
        </div>
    </div>
</div>
    
</body>
</html>
