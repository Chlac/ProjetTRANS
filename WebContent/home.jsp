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

            </head>

            <body>


                <div id="header">
                    <h1>ÇaDéménage!</h1>
                </div>

                <div id="content">


                    <div id="workspace">

                        <div id="attributes_panel">
                            <form id="attributes_form">
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

						<script src="js/map.js"></script>
                        <div id="map">
                            <script src="https://maps.googleapis.com/maps/api/js?key=AIzaSyAn2v4PPOSg1vx7fb_bvB-LjuOLTAGTEb0&callback=initMap"
                                    async defer>
                            </script>
                        </div>

                        <div id="buttons_section">
                            <button id="showfilters" class="btn"><i class="fa fa-filter" aria-hidden="true"></i></button>
                            <button id="showmap" class="btn"><i class="fa fa-map" aria-hidden="true"></i></button>

                        </div>

                    </div>



                    <div id="result">

                        <h4>City Name</h4>

                        <button id="moreInfos">+ d'infos <i class="fa fa-caret-up" aria-hidden="true"></i></button>

                    </div>




                </div>

                <div id="footer">
                    Application de merde par des élèves de merde. Donne les poiinnnts allez là !
                </div>
                
                
                
				<script src="js/indexJS.js"></script>
            </body>
        </html>


