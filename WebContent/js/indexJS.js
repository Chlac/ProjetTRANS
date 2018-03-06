/**
 * 
 */

$(document).ready(function(){

	$("#attributes_form").change(function() {
		doPOST('UpdateResultsServlet', updateResults, $(this).serialize());
	});

	$("#moreInfos").click(function () {

		var $results_panel = $("#result");

		$('#content').hide();
		var top = $results_panel.css('top');
		$('#content').show();

		if (top == '8%') {
			
			var newv = parseInt($('#content').css('height'), 10) - (90 + 60);
			$results_panel.animate({
				top : newv,
				height : "150px"
			});

		} else {
			
			$results_panel.animate({
				top : "8%",
				height : "92%"
			});
		}
	});

	$("#showfilters").click(function () {
		
		$("#attributes_panel").animate({
			left : "0"
		});
	});

	$("#showmap").click(function () {
		
		var $panel = $("#attributes_panel");
		$panel.animate({
			left : -$panel.outerWidth()
		});
	});

});


function doPOST(url, cFunction, data) {

	alert("POSTING");
	$.post({
		url: url,
		data: data,
		dataType: "json",
		success: cFunction,
		error: function(jqXHR, textStatus, errorThrown){
            alert("PROUT");
		}
	});

}

function updateResults(data) {
	//update results...
	alert("Updating ! : " + data);
}
