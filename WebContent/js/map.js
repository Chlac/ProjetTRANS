/**
 * 
 */

function initMap() {
	// Styles a map in night mode.
	 var myLatLng = {lat: 48.862725, lng: 2.287592000000018};
	 var myLatLng = {lat: 47.58330, lng: 1.33333};
	
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
	
	/*var marker = new google.maps.Marker({
	    position: myLatLng,
	    map: map,
	    title: 'Hello World!'
	  });*/
	

	setMarkers(map);
	
	
	
}

var locations = [
	['Paris', 48.862725, 2.287592000000018, 3],
	['Blois', 47.58609209999999, 1.3359474999999748, 2],
	['Dreux', 48.736134, 1.3708890000000338, 1]
];


function setMarkers(map) {
	  // Adds markers to the map.

	  // Marker sizes are expressed as a Size of X,Y where the origin of the image
	  // (0,0) is located in the top left of the image.

	  // Origins, anchor positions and coordinates of the marker increase in the X
	  // direction to the right and in the Y direction down.
	  var image = {
	    url: 'https://developers.google.com/maps/documentation/javascript/examples/full/images/beachflag.png',
	    // This marker is 20 pixels wide by 32 pixels high.
	    size: new google.maps.Size(20, 32),
	    // The origin for this image is (0, 0).
	    origin: new google.maps.Point(0, 0),
	    // The anchor for this image is the base of the flagpole at (0, 32).
	    anchor: new google.maps.Point(0, 32)
	  };
	  // Shapes define the clickable region of the icon. The type defines an HTML
	  // <area> element 'poly' which traces out a polygon as a series of X,Y points.
	  // The final coordinate closes the poly by connecting to the first coordinate.
	  var shape = {
	    coords: [1, 1, 1, 20, 18, 20, 18, 1],
	    type: 'poly'
	  };
	  for (var i = 0; i < locations.length; i++) {
	    var location = locations[i];
	    var marker = new google.maps.Marker({
	      position: {lat: location[1], lng: location[2]},
	      map: map,
	      icon: image,
	      shape: shape,
	      title: location[0],
	      zIndex: location[3]
	    });
	  }
	}