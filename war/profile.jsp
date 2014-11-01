<!DOCTYPE html>
<html>

<head>
    <meta charset="UTF-8">
    <title>Profile Page</title>

    <%@ include file="/include/cssimports.jsp" %>

        <link rel="stylesheet" type="text/css" href="/css/profile-style.css" />
        <link rel="stylesheet" type="text/css" href="/css/main.css" />

        <script src="/js/profile.js" type="text/javascript"></script>

</head>

<body>

    <%@ include file="/include/header.jsp" %>

        <h2 style="padding-top: 50px">My Profile</h2>

        <div class="container" style="padding-top: 100px">
            <div class="row">


                <div class="col-md-12">
                    <div class="col-md-6">
                        <div class="col-xs-12 col-sm-6 col-md-6">
                            <div class="well well-sm">
                                <div class="row">
                                    <div class="col-sm-6 col-md-4">
                                        <img data-bind="attr: { src: settings.profileImage.datastoreLink }" alt="" class="img-rounded img-responsive" />
                                    </div>
                                    <div class="col-sm-6 col-md-8">
                                        <h3>
										<span class="profile-text" data-bind="text: settings.firstName"></span> 
										<span class="profile-text" data-bind="text: settings.lastName"></span>
									</h3>
                                        <p>
                                            <span class="profile-text" data-bind="text: username"></span>
                                        </p>
                                        <a href="profile-settings.jsp">
                                            <button class="btn btn-inverse btn-small">Edit Profile Picture</button>
                                        </a>
                                    </div>
                                </div>
                            </div>

                            <a href="/book/upload" class="btn btn-default btn-lg">Upload A
							Photo To Your ScrapBook</a>
                        </div>
                    </div>
                    <div class="col-md-6">

                                <!-- Thumbnail link for lion image -->
                                <a href="#" data-toggle="modal" data-target=".pop-up-2">
                                    <img src="http://i.imgur.com/dtaHtds.jpg" width="150" class="img-responsive img-rounded center-block" alt="">
                                </a>

                                <!--  Modal content for the lion image example -->
                                <div class="modal fade pop-up-2" tabindex="-1" role="dialog" aria-labelledby="myLargeModalLabel-2" aria-hidden="true">
                                    <div class="modal-dialog modal-lg">
                                        <div class="modal-content">

                                            <div class="modal-header">
                                                <button type="button" class="close" data-dismiss="modal" aria-hidden="true">×</button>
                                                <h4 class="modal-title" id="myLargeModalLabel-2">Lion</h4>
                                            </div>
                                            <div class="modal-body">
                                                <img src="http://i.imgur.com/kzGVqbd.jpg" class="img-responsive img-rounded center-block" alt="">
                                            </div>
                                        </div>
                                        <!-- /.modal-content -->
                                    </div>
                                    <!-- /.modal-dialog -->
                                </div>
                                <!-- /.modal mixer image -->
                    </div>
                </div>
            </div>
        </div>
</body>

</html>
