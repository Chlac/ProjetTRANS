<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
    <%@ page import = "java.io.*" %>


        <!DOCTYPE html>
        <html>
            <head>
                <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
                <meta name="viewport" content="width=device-width, initial-scale=1.0">

                <link rel="stylesheet" type="text/css" href="css/home_stylesheet.css">

                <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">

                <link rel="stylesheet" type="text/css" media="screen" href="css/clear-sans.css">

                <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>

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
                    function updateResults() {
                        document.getElementById("attributes_form").submit();
                    }
                </script>

                <script>
                    function showMap() {
                        var $panel = $("#attributes_panel");
                        $panel.animate({ left: -$panel.outerWidth() });
                    }

                    function showFilters() {
                        $("#attributes_panel").animate({ left: "0" });
                    }

                    function moreInfos() {

                        var $results_panel = $("#result");

                        $('#content').hide();
                        var top = $results_panel.css('top');
                        $('#content').show();
						
                        if(top == '8%') {
                            var newv = parseInt($('#content').css('height'), 10) - (90 + 60);
                            $results_panel.animate({ top: newv, height: "150px" });

                        }
                        else {
                            $results_panel.animate({ top: "8%", height: "92%" });
                        }
                    }
                </script>


            </head>

            <body>



                <div id="header">
                    <h1>ÇaDéménage!</h1>
                </div>

                <div id="content">


                    <div id="workspace">

                        <div id="attributes_panel">
                            <form id="attributes_form" 
                                  action="${pageContext.request.contextPath}/index" 
                                  method="post"
                                  onchange="updateResults()">
                                <h4>Culture</h4>
                                <input type="checkbox" name="culture1" value="animation"> Beaucoup d’animation
                                <br>
                                <h4>Économie</h4>
                                <input type="checkbox" name="economie1" value="chomage"> Faible taux de chômage
                                <br>
                                <input type="checkbox" name="vehicle1" value="Bike"> Fort dynamisme économique
                                <br>
                                <input type="checkbox" name="vehicle1" value="Bike"> Tourisme important
                                <br>
                                <input type="checkbox" name="vehicle1" value="Bike"> Industrie importante
                                <br>
                                <input type="checkbox" name="vehicle1" value="Bike"> Agriculture importante
                                <br>
                                <input type="checkbox" name="vehicle1" value="Bike"> Variété de commerces / magasins
                                <br>
                                <h4>Population</h4>
                                <input type="checkbox" name="vehicle1" value="Bike"> Aisée
                                <br>
                                <input type="checkbox" name="vehicle1" value="Bike"> Classe moyenne
                                <br>
                                <input type="checkbox" name="vehicle1" value="Bike"> Retraitée
                                <br>
                                <input type="checkbox" name="vehicle1" value="Bike"> Étudiante
                                <br>
                                <h4>Services publics</h4>
                                <input type="checkbox" name="vehicle1" value="Bike"> Écoles
                                <br>
                                <input type="checkbox" name="vehicle1" value="Bike"> Universités
                                <br>
                                <input type="checkbox" name="vehicle1" value="Bike"> Hôpitaux / médecins
                                <br>
                                <h4>Taille et localisation</h4>
                                <input type="checkbox" name="vehicle1" value="Bike"> Village (-2000 habitants)
                                <br>
                                <input type="checkbox" name="vehicle1" value="Bike"> Petite ville (2000 - 50 000 habitants)
                                <br>
                                <input type="checkbox" name="vehicle1" value="Bike"> Moyenne ville ( 50 000-200 000 habitants)
                                <br>
                                <input type="checkbox" name="vehicle1" value="Bike"> Grande ville (+200 000 habitants)
                                <br>
                                <input type="checkbox" name="vehicle1" value="Bike"> À moins de _____km de _____
                                <br>
                            </form> 
                        </div>

                        <div id="map">
                            <script src="https://maps.googleapis.com/maps/api/js?key=AIzaSyAn2v4PPOSg1vx7fb_bvB-LjuOLTAGTEb0&callback=initMap"
                                    async defer>
                            </script>
                        </div>

                        <div id="buttons_section">
                            <button id="showfilters" class="btn" onclick="showFilters()"><i class="fa fa-filter" aria-hidden="true"></i></button>
                            <button id="showmap" class="btn" onclick="showMap()"><i class="fa fa-map" aria-hidden="true"></i></button>

                        </div>

                    </div>



                    <div id="result">

                        <h4>City Name</h4>

                        <button onclick="moreInfos()">+ d'infos <i class="fa fa-caret-up" aria-hidden="true"></i></button>

                    </div>




                </div>

                <div id="footer">
                    Application de merde par des élèves de merde. Donne les poiinnnts allez là !
                </div>

            </body>
        </html>


