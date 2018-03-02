<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import = "java.io.*" %>


<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">

        <link rel="stylesheet" type="text/css" href="home_stylesheet.css">
        
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>

        <script>
            function handleClick() {
                document.getElementById("attributes_form").submit();
            }
        </script>

        <script>

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
        </script>

        <script>
            $(document).ready(function() {
                $(window).resize(function() {
                    $("#workspace").height($(window).height() - $("#header").height() - $("#footer").height()); 
                    $("#result").outerWidth(window.innerWidth - $("#attributes_panel").outerWidth()); 
                }).resize();
            });
        </script>

    </head>

    <body>



        <div id="header">
            <h1>ÇaDéménage!</h1>
        </div>

        <div id="workspace">

            <div id="map">
                <script src="https://maps.googleapis.com/maps/api/js?key=AIzaSyAn2v4PPOSg1vx7fb_bvB-LjuOLTAGTEb0&callback=initMap"
                        async defer>
                </script>
            </div>


            <div id="overlapping_stuff">
                
                <div id="attributes_panel">
                    <form id="attributes_form" 
                          action="/html.jsp" 
                          onchange="handleClick">
                        <h4>Title</h4>
                        <input type="checkbox" name="vehicle1" value="Bike">I have a bike
                        <br>
                        <input type="checkbox" name="vehicle2" value="Car">I have a car 
                        <br>
                        <input type="checkbox" name="vehicle1" value="Bike">I have a bike
                        <br>
                        <h4>Title</h4>
                        <input type="checkbox" name="vehicle1" value="Bike">I have a bike
                        <br>
                        <input type="checkbox" name="vehicle1" value="Bike">I have a bike
                        <br>
                        <input type="checkbox" name="vehicle1" value="Bike">I have a bike
                        <br>
                        <h4>Title</h4>
                        <input type="checkbox" name="vehicle1" value="Bike">I have a bike
                        <br>
                        <input type="checkbox" name="vehicle1" value="Bike">I have a bike
                        <br>
                        <br>
                    </form> 
                </div>
                
                <div id="result">
                
                <h4>City Name</h4>
                </div>

            </div>


        </div>

        <div id="footer">
            Application de merde par des élèves de merde. Donne les poiinnnts allez là !
        </div>

    </body>
</html>

