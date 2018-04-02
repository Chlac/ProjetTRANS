/**
 * 
 */

$(document).ready(function(){
	
	var animationEnd = 'webkitAnimationEnd mozAnimationEnd MSAnimationEnd oanimationend animationend';

	if($(window).width() < 580) {
		$("#cat2").children("span").attr("class", "after");
		$("#cat4").children("span").attr("class", "after");
	}
	else {
		$("#cat2").children("span").attr("class", "before");
		$("#cat4").children("span").attr("class", "before");
	}

	$("#attributes_form").change(function() {
		doPOST('UpdateResultsServlet', updateResults, $(this).serialize());
	});
	
	$("#moreInfos").click(function () {
		
	});

	$("#moreInfos").click(function () {

		$("#result").attr("class", "detailedResult").one(animationEnd, function() {

			$("#lessInfos").css("display", "block");
			$("#lessInfos").animate({
				top : "0%"
			})
		});



	});

	$("#lessInfos").click(function () {

		$(this).animate({
			top : "-40px"
		}, {
			complete: function() {

				$("#result").attr("class", "summedResult").one(animationEnd, function() {

					$("#lessInfos").css("display", "block");
					$("#lessInfos").animate({
						top : "0%"
					})
				});
			}
		});


	});

	
	$("#showfilters").click(function () {

		$("#attributes_panel, #attrPanelBackground").removeClass('animated bounceOutLeft').addClass('animated bounceInLeft');
		
		setTimeout(function () {
			
			$(".before, .after").animate(
					{
						width : "60px"
					}, 300);
            
        }, 700);
		
	});

	$("#showmap").click(function () {
		
		$(".before, .after").animate(
				{
					width : "0px"
				}, 300, 
				function() {
					$("#attributes_panel, #attrPanelBackground").addClass('animated bounceOutLeft');
				}
		);
		


	});

	var leftVal = 0;
	$("#arrowright").click(function () {
		if(leftVal > -900) leftVal -= 100;
		$('#cityPanelsSlideshow').css("left", parseInt(leftVal) + '%');
	});

	$("#arrowleft").click(function () {
		if(leftVal < 0) leftVal += 100;
		$('#cityPanelsSlideshow').css("left", parseInt(leftVal) + '%');
	});


});

$(window).on('resize', function() {

	if($(window).width() < 580) {
		if($("#result").height() !== $("#content").outerHeight(true)) {
			$("#result").css("height", "35%");
			$("#map").css('height', $("#content").outerHeight(true) - $("#result").outerHeight(true));
		}

		$("#cat2").children("span").attr("class", "after");
		$("#cat4").children("span").attr("class", "after");

	}
	else {
		if($("#result").height() !== $("#content").outerHeight(true)) {
			$("#result").css("height", "150px");
			$("#map").css('height', $("#content").outerHeight(true) - $("#result").outerHeight(true));
		}
		
		$("#attributes_panel, #attrPanelBackground").removeAttr('style').removeClass('animated bounceOutLeft');
		$("#attributes_form").children("h4").children("span").removeAttr('style').addClass("before");

	}

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

	$.each(data, function (index, city) {
		alert("Updating ! : " + city.name);
	});

}
