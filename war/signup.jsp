<!DOCTYPE html>
<html>

<head>
<meta charset="UTF-8">
<title>Sign Up</title>

<%@ include file="/include/cssimports.jsp"%>

<link rel="stylesheet" type="text/css" href="/css/upload-image-style.css" />
<link rel="stylesheet" type="text/css" href="/css/main.css" />

<script src="/js/signup.js" type="text/javascript"></script>

</head>

<body>

	<%@ include file="/include/header.jsp" %>

	<h1 style="padding-top: 50px">Sign Up</h1>

	<div class="container" style="padding-top: 100px">
		<div class="row">

			<div class="col-md-12">
				
				<form id="signup-form">
					<div class="col-md-12">
						<div class="button-move">
							<div class="center-input">
								<input type="text" id="firstName" name="firstName" class="form-control input-group-lg" placeholder="First name" />
							</div>
						</div>
					</div>
	
					<div class="col-md-6">
						<div class="button-move">
							<input type="text" id="lastName" name="lastName" class="form-control input-group-lg" placeholder="Last name" />
						</div>
					</div>
	
					<div class="col-md-6">
						<div class="button-move">
							<input type="submit" class="btn btn-default" value="Sign Up" />
						</div>
					</div>
				</form>
			</div>
		</div>
	</div>
</body>

</html>
