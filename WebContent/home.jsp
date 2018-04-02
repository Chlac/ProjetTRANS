<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
    <%@ page import = "java.io.*" %>
        
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">

        <link rel="stylesheet" type="text/css" href="css/home_stylesheet.css">

        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/animate.css/3.5.2/animate.min.css">

        <link rel="stylesheet" type="text/css" media="screen" href="css/clear-sans.css">

        <script defer src="https://use.fontawesome.com/releases/v5.0.9/js/solid.js" integrity="sha384-P4tSluxIpPk9wNy8WSD8wJDvA8YZIkC6AQ+BfAFLXcUZIPQGu4Ifv4Kqq+i2XzrM" crossorigin="anonymous"></script>
        <script defer src="https://use.fontawesome.com/releases/v5.0.9/js/fontawesome.js" integrity="sha384-2IUdwouOFWauLdwTuAyHeMMRFfeyy4vqYNjodih+28v2ReC+8j+sLF9cK339k5hY" crossorigin="anonymous"></script>
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>

    </head>

    <body>

        <div id="header">
            <h2 id="logo" class="headerContent">ÇaDéménage!</h2>
            <div id="connectionButtons">
                <button id="signin" class="headerContent">Se connecter</button>
                <button id="signup" class="headerContent">S'inscrire</button>
            </div>
        </div>


        <form id="connection" class="signInSignUpForm">
            <button class="close"></button>
            <input type="text" placeholder="Pseudo" class="textInput">
            <input type="password" placeholder="Password" class="textInput">
            <input type="submit" value="" class="submitCo">
        </form>

        <form id="inscription" action="inscrire.jsp" class="signInSignUpForm">
            <input type="email" placeholder="E-mail" class="textInput">
            <input type="text" placeholder="Pseudo" class="textInput">
            <input type="password" placeholder="Mot de passe" class="textInput">
            <input type="verifPassword" placeholder="Confirmer mot de passe" class="textInput">
            <input type="submit" value="" class="submitCo">
        </form>

        <div id="content">

            <div id="attributes_panel">
                <form id="attributes_form">
                    <h4 id="cat1"><span class="before"></span>Culture</h4>
                    <input type="checkbox" name="culture1" value="animation"> Beaucoup d’animation
                    <br>
                    <h4 id="cat2"><span class="before"></span>Économie</h4>
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
                    <h4 id="cat3"><span class="before"></span>Population</h4>
                    <input type="checkbox" name="vehicle1" value="Bike"> Aisée
                    <br>
                    <input type="checkbox" name="vehicle1" value="Bike"> Classe moyenne
                    <br>
                    <input type="checkbox" name="vehicle1" value="Bike"> Retraitée
                    <br>
                    <input type="checkbox" name="vehicle1" value="Bike"> Étudiante
                    <br>
                    <h4 id="cat4"><span class="before"></span>Services publics</h4>
                    <input type="checkbox" name="vehicle1" value="Bike"> Écoles
                    <br>
                    <input type="checkbox" name="vehicle1" value="Bike"> Universités
                    <br>
                    <input type="checkbox" name="vehicle1" value="Bike"> Hôpitaux / médecins
                    <br>
                    <h4 id="cat5"><span class="before"></span>Taille et localisation</h4>
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

            <div id="attrPanelBackground"></div>


            <script src="js/map.js"></script>
            <div id="map">
                <script src="https://maps.googleapis.com/maps/api/js?key=AIzaSyAn2v4PPOSg1vx7fb_bvB-LjuOLTAGTEb0&callback=initMap"
                        async defer>
                </script>
            </div>

            <div id="result" class="summarizedResult">

                <button id="lessInfos">- d'infos <i class="fa fa-caret-down" aria-hidden="true"></i></button>

                <div id="buttonsSection">
                    <button id="showfilters"><i class="fa fa-filter" aria-hidden="true"></i></button>
                    <button id="showmap"><i class="fa fa-map" aria-hidden="true"></i></button>
                    <button id="moreInfos">+ d'infos <i class="fa fa-caret-up" aria-hidden="true"></i></button>

                </div>

                <div id="score">1<sup id="exposant">#</sup></div>

                <div id="cityPanelStaticStuff">

                    <div id="cityPromoPicture">
                        <img src="truc.jpg" alt="truc" />
                    </div>

                    <div id="arrows">
                        <button id="arrowleft" class="arrow"><i class="fas fa-angle-left"></i></button>
                        <button id="arrowright" class="arrow"><i class="fas fa-angle-right"></i></button>
                    </div>


                </div>

                <div id="cityPanelsSlideshow">

                    <div id="1#" class="citySumPanel">
                        <h4>C1</h4>
                        <h5>Dep - More</h5>
                    </div>
                    <div id="2#" class="citySumPanel">
                        <h4>C2</h4>
                        <h5>Dep - More</h5>
                    </div>
                    <div id="3#" class="citySumPanel">
                        <h4>C3</h4>
                        <h5>Dep - More</h5>
                    </div>
                    <div id="4#" class="citySumPanel">
                        <h4>C4</h4>
                        <h5>Dep - More</h5>
                    </div>
                    <div id="5#" class="citySumPanel">
                        <h4>C5</h4>
                        <h5>Dep - More</h5>
                    </div>
                    <div id="6#" class="citySumPanel">
                        <h4>C6</h4>
                        <h5>Dep - More</h5>
                    </div>
                    <div id="7#" class="citySumPanel">
                        <h4>C7</h4>
                        <h5>Dep - More</h5>
                    </div>
                    <div id="8#" class="citySumPanel">
                        <h4>C8</h4>
                        <h5>Dep - More</h5>
                    </div>
                    <div id="9#" class="citySumPanel">
                        <h4>C9</h4>
                        <h5>Dep - More</h5>
                    </div>
                    <div id="10#" class="citySumPanel">
                        <h4>C10</h4>
                        <h5>Dep - More</h5>
                    </div>

                </div>

            </div>

        </div>

        <div id="footer">
            Application de merde par des élèves de merde. Donne les poiinnnts allez là !
        </div>



        <script src="js/indexJS.js"></script>
    </body>
</html>