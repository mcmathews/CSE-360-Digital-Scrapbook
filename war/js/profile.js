$(function () {
	$.ajax({
		url: "/api/user",
		type: "GET",
		dataType: "json",
		success: function (data, status, jqxhr) {
			if (!data.settings.profileImage) {
				data.settings.profileImage = {
						datastoreLink: "https://gp5.googleusercontent.com/-ccHrCOypIOk/AAAAAAAAAAI/AAAAAAAAAAA/W4izi6XQshc/s48-c-k-no/photo.jpg",
						title: "No profile image"
				};
			}
			ko.applyBindings(data);
		}
	});
});