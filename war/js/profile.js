$(function () {
	$.ajax({
		url: "/api/user",
		type: "GET",
		dataType: "json",
		success: function (data, status, jqxhr) {
			ko.applyBindings(data);
		}
	});
});