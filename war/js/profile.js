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
	var self = this;
	
	self.username = "";
	
	self.settings = {};

	self.modalSrc = ko.observable();
	self.modalTitle = ko.observable();
	self.modalId = ko.observable();
	self.editUrl = ko.computed(function () {
		return "/edit-image.jsp?id=" + self.modalId();
	}, self);
	
	self.images = [];
	
	self.setDefaultProfileImage = function () {
		self.settings.profileImage = {};
		self.settings.profileImage.datastoreLink = "https://gp5.googleusercontent.com/-ccHrCOypIOk/AAAAAAAAAAI/AAAAAAAAAAA/W4izi6XQshc/s48-c-k-no/photo.jpg";
		self.settings.profileImage.title = "No profile image";
	};
	
	self.popup = function (imageObj) {
		self.modalSrc(imageObj.datastoreLink);
		self.modalTitle(imageObj.title);
		self.modalId(imageObj.id);
	};
}