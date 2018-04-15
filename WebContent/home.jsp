<%@page import="javax.annotation.Generated"%>
<%@page import="sun.security.krb5.EncryptedData"%>
<%@page import="javax.crypto.Cipher"%>
<%@page import="javax.crypto.spec.IvParameterSpec"%>
<%@page import="javax.crypto.spec.SecretKeySpec"%>
<%@page import="javax.crypto.SecretKeyFactory"%>
<%@page import="java.nio.charset.StandardCharsets"%>
<%@page import="sun.nio.ch.Secrets"%>
<%@page import="java.security.MessageDigest"%>
<%@page import="java.util.Arrays"%>
<%@page import="java.util.Base64"%>
<%@page import="crypto.AES"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="java.io.*"%>

<!DOCTYPE html>
<html>

    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">

        <link rel="stylesheet" type="text/css" href="css/home_stylesheet.css">

        <link rel="stylesheet"
              href="https://cdnjs.cloudflare.com/ajax/libs/animate.css/3.5.2/animate.min.css">

        <link rel="stylesheet" type="text/css" media="screen"
              href="css/clear-sans.css">

        <script defer src="https://use.fontawesome.com/releases/v5.0.10/js/all.js" integrity="sha384-slN8GvtUJGnv6ca26v8EzVaR9DC58QEwsIk9q1QXdCU8Yu8ck/tL/5szYlBbqmS+" crossorigin="anonymous"></script>
        
        <script
                src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
        <script
                src="https://cdnjs.cloudflare.com/ajax/libs/crypto-js/3.1.2/rollups/aes.js"></script>

    </head>

    <body>

        <div id="header">

            <h2 id="logo" class="headerContent">ÇaDéménage!</h2>


<%

	String pseudo;

	pseudo = request.getParameter("siPseudo");
	

	

	if(pseudo == null) {
	

%>
            <div id="connectionButtons">
                <button id="signin" class="headerContent">Se connecter</button>
                <button id="signup" class="headerContent">S'inscrire</button>
            </div>
            
        

        </div>
        


        <div id="content">

            <div id="connection" class="formPanel">

                <button class="close"><i class="fas fa-times"></i></button>

                <form id="signinForm" action="ConnectionUserServlet" class="signInSignUpForm">

                    <input id="siPseudo" name="siPseudo" type="text" placeholder="Pseudo" class="textInput">
                    <input id="siPassword" name="siPassword" type="password" placeholder="Mot de passe" class="textInput">
                    <button id="signinSubmit" type="submit" value="" class="submitCo"><i class="fas fa-arrow-right"></i></button>

                </form>

            </div>

            <div id="inscription" class="formPanel">

                <button class="close"><i class="fas fa-times"></i></button>


                <form id="signupForm" action="CreatUserServlet" class="signInSignUpForm">

                    <input id="suMail" name="suMail" type="email" placeholder="E-mail" class="textInput">
                    <input id="suPseudo" name="suPseudo" type="text" placeholder="Pseudo" class="textInput">
                    <input id="suPassword" name="suPassword" type="password" placeholder="Mot de passe" class="textInput">
                    <input id="suVPassword" name="suVpassword" type="password" placeholder="Confirmer mot de passe" class="textInput">
                    <button id="signupSubmit" type="submit" value="" class="submitCo"><i class="fas fa-arrow-right"></i></button>
                </form>
                
            </div>
                
                 <%
            
            }
            
	else {
			AES aes = new AES();
			
			pseudo = aes.decrypt(pseudo);
			
		
		out.println(pseudo);
		
		%>
			<form id="deconnexion" action="home.jsp">
				<div id= "connectionButtons">
				<button id="deconnexion" class="headerContent">Déconnexion</button>
				</div>
			</form>
                     
        </div>
        
         <div id="content">
         
		<%

	}
	
 %>


            <div id="attributes_panel">

                <form id="attributes_form">

                    <h4 id="cat1"><span class="before"></span>Culture</h4>

                    <label><input type="checkbox" name="animation" > Animation / Évènementiel</label>
                    <br>
                    <label class="unavailable"><input type="checkbox" name="musee"> Musées / Salles d'expo</label>
                    <br>
                    <label class="unavailable"><input type="checkbox" name="bibliotheque"> Bibliothèques / Mediathèques</label>
                    <br>
                    <label class="unavailable"><input type="checkbox" name="patrimoine"> Patrimoine historique</label>

                    <h4 id="cat2"><span class="before"></span>Économie</h4>

                    <label><input type="checkbox" name="chomage"> Chômage faible</label>
                    <br>
                    <label class="unavailable"><input type="checkbox" name="vehicle1"> Dynamisme économique</label>
                    <br>
                    <label><input type="checkbox" name="tourisme"> Tourisme important</label>
                    <br>
                    <label><input type="checkbox" name="industrie"> Industrie importante</label>
                    <br>
                    <label><input type="checkbox" name="agriculture"> Agriculture importante</label>
                    <br>
                    <label><input type="checkbox" name="commerce"> Variété de commerces / magasins</label>
                    <br>
                    <label><input type="checkbox" name="impot"> Faible imposition des entreprises</label>
                    <br>

                    <h4 id="cat3"><span class="before"></span>Population</h4>

                    <label><input type="checkbox" name="jeunes"> Jeune</label>
                    <br>
                    <label><input type="checkbox" name="senior"> Senior</label>
                    <br>
                    <label><input type="checkbox" name="ville2000"> Village</label>
                    <br>
                    <label class="unavailable"><input type="checkbox" name="ville2000_50000"> Petite ville</label>
                    <br>
                    <label><input type="checkbox" name="ville50000_200000"> Moyenne ville</label>
                    <br>
                    <label><input type="checkbox" name="ville200000"> Grande ville</label>
                    <br>

                    <h4 id="cat4"><span class="before"></span>Coût de la vie</h4>

                    <label class="unavailable"><input type="checkbox" name="cout_faible"> Faible</label>
                    <br>
                    <label class="unavailable"><input type="checkbox" name="cout_moyen"> Moyen</label>
                    <br>
                    <label class="unavailable"><input type="checkbox" name="cout_cher"> Cher</label>
                    <br>
                    <label class="unavailable"><input type="checkbox" name="cout_tres_cher"> Très cher</label>
                    <br>

                    <h4 id="cat4"><span class="before"></span>Services publics</h4>

                    <label><input type="checkbox" name="creches"> Crèches</label>
                    <br>
                    <label><input type="checkbox" name="ecoles_prim"> Écoles primaires</label>
                    <br>
                    <label><input type="checkbox" name="ecoles_sec"> Écoles du secondaire</label>
                    <br>
                    <label><input type="checkbox" name="ecoles_sup"> Écoles du supérieur / Universités</label>
                    <br>
                    <label><input type="checkbox" name="hopitaux"> Hôpitaux / médecins</label>
                    <br>
                    <label class="unavailable"><input type="checkbox" name="transports_en_commun"> Transports en commun locaux</label>
                    <br>
                    <label class="unavailable"><input type="checkbox" name="gare"> Gare</label>
                    <br>
                    <label class="unavailable"><input type="checkbox" name="aeroport"> Aéroport</label>
                    <br>
                    <label class="unavailable"><input type="checkbox" name="réseau"> Qualité du réseau internet</label>
                    <br>

                    <h4 id="cat5"><span class="before"></span>Environnement</h4>

                    <label class="unavailable"><input type="checkbox" name="ensoleille"> Ensoleillé</label>
                    <br>
                    <label class="unavailable"><input type="checkbox" name="calme"> Calme</label>
                    <br>
                    <label class="unavailable"><input type="checkbox" name="espaces_verts"> Espaces verts </label>
                    <br>
                    <label class="unavailable"><input type="checkbox" name="pollution"> Pollution faible</label>
                    <br>
                    <label class="unavailable"><input type="checkbox" name="bords_de_mer"> Bords de mer</label>
                    <br>
                    <label class="unavailable"><input type="checkbox" name="montagne"> Montagne</label>
                    <br>
                    <label><input type="checkbox" name="distance"> À moins de <input type="text" name="km">km de <input type="text" name="dist_city"></label>

                </form> 


            </div>

            <div id="attrPanelBackground"></div>


            <script src="js/map.js"></script>
            <div id="map">
                <script src="https://maps.googleapis.com/maps/api/js?key=AIzaSyAn2v4PPOSg1vx7fb_bvB-LjuOLTAGTEb0&callback=initMap"
                        async defer>
                </script>
            </div>


            <div id="resultSection">

                <div id="buttonsSection">

                    <div id="buttons">
                        <button id="showfilters" class="modeButton activeButton"><i class="fa fa-filter" aria-hidden="true"></i></button>
                        <button id="showmap" class="modeButton"><i class="fa fa-map" aria-hidden="true"></i></button>
                        <button id="moreInfos" class="modeButton">+ d'infos <i class="fa fa-caret-up" aria-hidden="true"></i></button>
                    </div>

                </div>

                <div id="result">

                    <button id="lessInfos">- d'infos <i class="fa fa-caret-down" aria-hidden="true"></i></button>

                    <div id="score" class="scoreSum">
                        <div id="scoreContent">
                            <h1 id="scoreNum">1</h1>
                            <sup>#</sup>
                        </div>
                    </div>

                    <div class="cityPromoPictureSum">
                        <div id="diapo">
                        <img src="https://upload.wikimedia.org/wikipedia/commons/thumb/f/f3/Blois_Loire_Panorama_-_July_2011.jpg/1200px-Blois_Loire_Panorama_-_July_2011.jpg" alt="truc" width="20%" height="100%"/>
                            <img src="https://upload.wikimedia.org/wikipedia/commons/thumb/f/f3/Blois_Loire_Panorama_-_July_2011.jpg/1200px-Blois_Loire_Panorama_-_July_2011.jpg" alt="truc"/>
                            <img src="https://upload.wikimedia.org/wikipedia/commons/thumb/f/f3/Blois_Loire_Panorama_-_July_2011.jpg/1200px-Blois_Loire_Panorama_-_July_2011.jpg" alt="truc"/>
                            <img src="https://upload.wikimedia.org/wikipedia/commons/thumb/f/f3/Blois_Loire_Panorama_-_July_2011.jpg/1200px-Blois_Loire_Panorama_-_July_2011.jpg" alt="truc"/>
                            <img src="https://upload.wikimedia.org/wikipedia/commons/thumb/f/f3/Blois_Loire_Panorama_-_July_2011.jpg/1200px-Blois_Loire_Panorama_-_July_2011.jpg" alt="truc"/>
                            </div>
                    </div>
                    
                    <button id="pdf"><i class="far fa-file"></i></button>

                    <div class="cityPanelsSlideshowSum">

                        <div id="arrows">
                            <button id="arrowleft" class="arrow"><i class="fas fa-angle-left"></i></button>
                            <button id="arrowright" class="arrow"><i class="fas fa-angle-right"></i></button>
                        </div>

                        <div id=cityPanels class="cityPanelsSum">

                            <div id="1" class="citySumPanel">

                                <div class="cityInf cityInfSum">
                                    <h4 class="cityName">C1</h4>
                                    <h5 class="cityWhereInfos">Dep - More</h5>
                                </div>

                                <div class="details">

                                </div>

                            </div>

                            <div id="2" class="citySumPanel">
                                <div class="cityInf cityInfSum">
                                    <h4 class="cityName">C2</h4>
                                    <h5 class="cityWhereInfos">Dep - More</h5>
                                </div>

                                <div class="details">

                                </div>

                            </div>

                            <div id="3" class="citySumPanel">
                                <div class="cityInf cityInfSum">
                                    <h4 class="cityName">C3</h4>
                                    <h5 class="cityWhereInfos">Dep - More</h5>
                                </div>

                                <div class="details">

                                </div>

                            </div>

                            <div id="4" class="citySumPanel">
                                <div class="cityInf cityInfSum">
                                    <h4 class="cityName">C4</h4>
                                    <h5 class="cityWhereInfos">Dep - More</h5>
                                </div>

                                <div class="details">

                                </div>

                            </div>

                            <div id="5" class="citySumPanel">
                                <div class="cityInf cityInfSum">
                                    <h4 class="cityName">C5</h4>
                                    <h5 class="cityWhereInfos">Dep - More</h5>
                                </div>

                                <div class="details">

                                </div>
                            </div>

                            <div id="6" class="citySumPanel">
                                <div class="cityInf cityInfSum">
                                    <h4 class="cityName">C6</h4>
                                    <h5 class="cityWhereInfos">Dep - More</h5>
                                </div>

                                <div class="details">

                                </div>

                            </div>

                            <div id="7" class="citySumPanel">
                                <div class="cityInf cityInfSum">
                                    <h4 class="cityName">C7</h4>
                                    <h5 class="cityWhereInfos">Dep - More</h5>
                                </div>

                                <div class="details">

                                </div>
                            </div>

                            <div id="8" class="citySumPanel">
                                <div class="cityInf cityInfSum">
                                    <h4 class="cityName">C8</h4>
                                    <h5 class="cityWhereInfos">Dep - More</h5>
                                </div>

                                <div class="details">

                                </div>

                            </div>
                            <div id="9" class="citySumPanel">
                                <div class="cityInf cityInfSum">
                                    <h4 class="cityName">C9</h4>
                                    <h5 class="cityWhereInfos">Dep - More</h5>
                                </div>

                                <div class="details">

                                </div>

                            </div>
                            <div id="10" class="citySumPanel">
                                <div class="cityInf cityInfSum">
                                    <h4 class="cityName">C10</h4>
                                    <h5 class="cityWhereInfos">Dep - More</h5>
                                </div>

                                <div class="details">

                                </div>

                            </div>





                        </div>

                    </div>

                </div>

            </div>

        </div>



        <script src="js/indexJS.js"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/jspdf/1.3.5/jspdf.min.js"></script>
        
        <script> 
         
    (function () {  
        var  
         div = $('#result'),  
         cache_width = div.width(),  
         a4 = [595.28, 841.89]; 
  
        $('#pdf').on('click', function () {  
            $('#content').scrollTop(0);
            $("#lessInfos").hide();
             $('#pdf').hide();
            createPDF(); 
            $("#lessInfos").show(); 
            $('#pdf').show();
        });  
        //create pdf  
        function createPDF() {  
            getCanvas().then(function (canvas) {  
                var  
                 img = canvas.toDataURL("image/png"),  
                 doc = new jsPDF({  
                     unit: 'px',  
                     format: 'a4'  
                 });  
                 
                doc.addImage(img, 'JPEG', 20, 20);  
                doc.save('CaDemenage.pdf');  
                div.width(cache_width);  
            });  
        }  
  
        // create canvas object  
        function getCanvas() {  
            div.width((a4[0] * 1.33333) - 80).css('max-width', 'none');  
            return html2canvas(div, {  
                imageTimeout: 2000,  
                removeContainer: true  
            });  
        }  
  
    }());  
</script>  
<script>  
    /* 
 * jQuery helper plugin for examples and tests 
 */  
    (function ($) {  
        $.fn.html2canvas = function (options) {  
            var date = new Date(),  
            $message = null,  
            timeoutTimer = false,  
            timer = date.getTime();  
            html2canvas.logging = options && options.logging;  
            html2canvas.Preload(this[0], $.extend({  
                complete: function (images) {  
                    var queue = html2canvas.Parse(this[0], images, options),  
                    $canvas = $(html2canvas.Renderer(queue, options)),  
                    finishTime = new Date();  
  
                    $canvas.css({ position: 'absolute', left: 0, top: 0 }).appendTo(document.body);  
                    $canvas.siblings().toggle();  
  
                    $(window).click(function () {  
                        if (!$canvas.is(':visible')) {  
                            $canvas.toggle().siblings().toggle();  
                            throwMessage("Canvas Render visible");  
                        } else {  
                            $canvas.siblings().toggle();  
                            $canvas.toggle();  
                            throwMessage("Canvas Render hidden");  
                        }  
                    });  
                    throwMessage('Screenshot created in ' + ((finishTime.getTime() - timer) / 1000) + " seconds<br />", 4000);  
                }  
            }, options));  
  
            function throwMessage(msg, duration) {  
                window.clearTimeout(timeoutTimer);  
                timeoutTimer = window.setTimeout(function () {  
                    $message.fadeOut(function () {  
                        $message.remove();  
                    });  
                }, duration || 2000);  
                if ($message)  
                    $message.remove();  
                $message = $('<div ></div>').html(msg).css({  
                    margin: 0,  
                    padding: 10,  
                    background: "#000",  
                    opacity: 0.7,  
                    position: "fixed",  
                    top: 10,  
                    right: 10,  
                    fontFamily: 'Tahoma',  
                    color: '#fff',  
                    fontSize: 12,  
                    borderRadius: 12,  
                    width: 'auto',  
                    height: 'auto',  
                    textAlign: 'center',  
                    textDecoration: 'none'  
                }).hide().fadeIn().appendTo('body');  
            }
        };  
    })(jQuery);  
  
</script> 
        
    </body>

</html>