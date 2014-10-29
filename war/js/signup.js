$(function () {
	$("#signup-form").submit(function (event) {
		event.preventDefault();
		
		var firstName = $(this).find("#firstName").val();
		if (!firstName) {
			alert("First name is a required field");
			return false;
		}
		lastName = $(this).find("#lastName").val(); 
		if (!lastName) {
			alert("Last name is a required field");
			return false;
		}
		
		var profileSettings = {
				firstName: firstName,
				lastName: lastName
		};
		
		$.ajax({
			url: "/api/user",
			type: "POST",
			dataType: "json",
			contentType: "application/json",
			data: JSON.stringify({
				settings: profileSettings
			}),
			success: function (data, status, jqxhr) {
				window.location.href = "/book";
			}
		});
		
		return false;
	});
});