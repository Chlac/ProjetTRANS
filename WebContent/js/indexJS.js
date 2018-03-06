/**
 * 
 */

$(document).ready(function(){

	$("#attributes_form").change(function() {
		doPOST('${pageContext.request.contextPath}/UpdateResultsServlet', updateResults, $(this).serialize());
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

function initMap() {
	// Styles a map in night mode.
	var map = new google.maps.Map(document.getElementById('map'), {
		center: {lat: 47.589391, lng: 1.335350},
		zoom: 6,
		styles: [
			{
				"elementType": "labels.text",
				"stylers": [
					{
						"visibility": "off"
					}
					]
			},
			{
				"featureType": "landscape.natural",
				"elementType": "geometry.fill",
				"stylers": [
					{
						"color": "#f5f5f2"
					},
					{
						"visibility": "on"
					}
					]
			},
			{
				"featureType": "administrative",
				"stylers": [
					{
						"visibility": "off"
					}
					]
			},
			{
				"featureType": "transit",
				"stylers": [
					{
						"visibility": "off"
					}
					]
			},
			{
				"featureType": "poi.attraction",
				"stylers": [
					{
						"visibility": "off"
					}
					]
			},
			{
				"featureType": "landscape.man_made",
				"elementType": "geometry.fill",
				"stylers": [
					{
						"color": "#ffffff"
					},
					{
						"visibility": "on"
					}
					]
			},
			{
				"featureType": "poi.business",
				"stylers": [
					{
						"visibility": "off"
					}
					]
			},
			{
				"featureType": "poi.medical",
				"stylers": [
					{
						"visibility": "off"
					}
					]
			},
			{
				"featureType": "poi.place_of_worship",
				"stylers": [
					{
						"visibility": "off"
					}
					]
			},
			{
				"featureType": "poi.school",
				"stylers": [
					{
						"visibility": "off"
					}
					]
			},
			{
				"featureType": "poi.sports_complex",
				"stylers": [
					{
						"visibility": "off"
					}
					]
			},
			{
				"featureType": "road.highway",
				"elementType": "geometry",
				"stylers": [
					{
						"color": "#ffffff"
					},
					{
						"visibility": "simplified"
					}
					]
			},
			{
				"featureType": "road.arterial",
				"stylers": [
					{
						"visibility": "simplified"
					},
					{
						"color": "#ffffff"
					}
					]
			},
			{
				"featureType": "road.highway",
				"elementType": "labels.icon",
				"stylers": [
					{
						"color": "#ffffff"
					},
					{
						"visibility": "off"
					}
					]
			},
			{
				"featureType": "road.highway",
				"elementType": "labels.icon",
				"stylers": [
					{
						"visibility": "off"
					}
					]
			},
			{
				"featureType": "road.arterial",
				"stylers": [
					{
						"color": "#ffffff"
					}
					]
			},
			{
				"featureType": "road.local",
				"stylers": [
					{
						"color": "#ffffff"
					}
					]
			},
			{
				"featureType": "poi.park",
				"elementType": "labels.icon",
				"stylers": [
					{
						"visibility": "off"
					}
					]
			},
			{
				"featureType": "poi",
				"elementType": "labels.icon",
				"stylers": [
					{
						"visibility": "off"
					}
					]
			},
			{
				"featureType": "water",
				"stylers": [
					{
						"color": "#71c8d4"
					}
					]
			},
			{
				"featureType": "landscape",
				"stylers": [
					{
						"color": "#e5e8e7"
					}
					]
			},
			{
				"featureType": "poi.park",
				"stylers": [
					{
						"color": "#8ba129"
					}
					]
			},
			{
				"featureType": "road",
				"stylers": [
					{
						"color": "#ffffff"
					}
					]
			},
			{
				"featureType": "poi.sports_complex",
				"elementType": "geometry",
				"stylers": [
					{
						"color": "#c7c7c7"
					},
					{
						"visibility": "off"
					}
					]
			},
			{
				"featureType": "water",
				"stylers": [
					{
						"color": "#a0d3d3"
					}
					]
			},
			{
				"featureType": "poi.park",
				"stylers": [
					{
						"color": "#91b65d"
					}
					]
			},
			{
				"featureType": "poi.park",
				"stylers": [
					{
						"gamma": 1.51
					}
					]
			},
			{
				"featureType": "road.local",
				"stylers": [
					{
						"visibility": "off"
					}
					]
			},
			{
				"featureType": "road.local",
				"elementType": "geometry",
				"stylers": [
					{
						"visibility": "on"
					}
					]
			},
			{
				"featureType": "poi.government",
				"elementType": "geometry",
				"stylers": [
					{
						"visibility": "off"
					}
					]
			},
			{
				"featureType": "landscape",
				"stylers": [
					{
						"visibility": "off"
					}
					]
			},
			{
				"featureType": "road",
				"elementType": "labels",
				"stylers": [
					{
						"visibility": "off"
					}
					]
			},
			{
				"featureType": "road.arterial",
				"elementType": "geometry",
				"stylers": [
					{
						"visibility": "simplified"
					}
					]
			},
			{
				"featureType": "road.local",
				"stylers": [
					{
						"visibility": "simplified"
					}
					]
			},
			{
				"featureType": "road"
			},
			{
				"featureType": "road"
			},
			{},
			{
				"featureType": "road.highway"
			}
			]
	});
}


function doPOST(url, cFunction, data) {

	$.post({
		url: url,
		data: data,
		success: cFunction //, dataType: dataType
	});

}

function updateResults(data) {
	//update results...
	alert("Updating !");
}
