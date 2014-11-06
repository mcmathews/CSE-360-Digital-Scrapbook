$(function () {
	var idParamRegex = /[\?&]id=([^&#]*)/;
    var results = idParamRegex.exec(location.search);
    var id;
    if (results) {
    	id = results[1];
    } else {
    	window.location.href = "/book";
    }
    
    $("#image").attr("src", "/api/images/" + id + "/data");
	
	$("#edit-image-submit").click(function () {
		Caman("#image", function () {
			var dataUrl = this.toBase64();
			var base64ImageData = atob(dataUrl.split(',')[1]);
			var imageData = [];
			for(var i = 0; i < base64ImageData.length; i++) {
				imageData.push(base64ImageData.charCodeAt(i));
			}
			var imageBlob = new Blob([new Uint8Array(imageData)], {type: 'image/png'});

			var formData = new FormData();
			formData.append("image", imageBlob);
			formData.append("id", id)
			$.ajax({
			   url: $("#uploadUrl").text(),
			   type: "POST",
			   data: formData,
			   processData: false,
			   contentType: false,
			   success: function (data, status, jqxhr) {
				   window.location.href = "/book";
			   }
			});
		});
	});
});