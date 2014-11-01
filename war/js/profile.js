$(function () {
	$.ajax({
		url: "/api/user",
		type: "GET",
		dataType: "json",
		success: function (data, status, jqxhr) {
			profileDataReady = true;
			init(data, "profile");
		}
	});

	$.ajax({
		url: "/api/images",
		type: "GET",
		dataType: "json",
		success: function (data, status, jqxhr) {
			imageDataReady = true;
			init(data, "images");
		}
	});
});

var profileDataReady = false;
var imageDataReady = false;
var viewModel = new ViewModel();
function init(data, dataType) {
	if (dataType === "profile") {
		viewModel.username = data.username;
		viewModel.settings = data.settings;
		if (!data.settings.profileImage) {
			viewModel.setDefaultProfileImage();
		}
		
	} else if (dataType === "images") {
		viewModel.images = data;
		
		for (var i = 0; i < viewModel.images.length; i++) {
			viewModel.images[i].datastoreLinkThumbnail = viewModel.images[i].datastoreLink + "=s250";
		}
	}
	
	if (profileDataReady && imageDataReady) {
		ko.applyBindings(viewModel);
	}	
}

function ViewModel() {
	this.username = "";
	
	this.settings = {};

	this.modalSrc = ko.observable();
	this.modalTitle = ko.observable();
	
	this.images = [];
	
	this.setDefaultProfileImage = function () {
		this.settings.profileImage.datastoreLink = "https://gp5.googleusercontent.com/-ccHrCOypIOk/AAAAAAAAAAI/AAAAAAAAAAA/W4izi6XQshc/s48-c-k-no/photo.jpg";
		this.settings.profileImage.title = "No profile image";
	};
	
	this.popup = function (imageObj) {
		this.modalSrc(imageObj.datastoreLink);
		this.modalTitle(imageObj.title);
	};
}