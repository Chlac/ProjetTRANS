/**
 * 
 */

$(document).ready(function () {

    var animationEnd = 'webkitAnimationEnd mozAnimationEnd MSAnimationEnd oanimationend animationend';


    if ($(window).width() < 580) {
        $("#attributes_panel").css("height", $("#content").outerHeight(true) - $("#result").outerHeight(true));
        $("#cat2").children("span").attr("class", "after");
        $("#cat4").children("span").attr("class", "after");
    } else {
        $("#cat2").children("span").attr("class", "before");
        $("#cat4").children("span").attr("class", "before");
    }

    $("#signinForm").submit(function () {

        var pseudo = $("#siPseudo").val();
        var mdp = $("#sPassword").val();

        var key = "dbrCUoc4z9EFJTLBSsZtQw==";

        var encryptedPseudo = CryptoJS.AES.encrypt(pseudo, key);
        var encryptedMDP = CryptoJS.AES.encrypt(mdp, key);

        $("#suPseudo").val(encryptedPseudo);
        $("#suPassword").val(encryptedMDP);

    });

    $("#signupForm").submit(function () {


        var mail = $("#suMail").val();
        var pseudo = $("#suPseudo").val();
        var mdp = $("#suPassword").val();
        var verifMdp = $("#suVPassword").val();


        var date = new Date();

        date = date.toString();



        var key = "dbrCUoc4z9EFJTLBSsZtQw==";


        // PROCESS
        var encryptedPseudo = CryptoJS.AES.encrypt(pseudo, key);
        var encryptedMail = CryptoJS.AES.encrypt(mail, key);
        var encryptedMDP = CryptoJS.AES.encrypt(mdp, key);
        var encryptedVerifMDP = CryptoJS.AES.encrypt(mdp, key);
        var encryptedDate = CryptoJS.AES.encrypt(date,key);

        var decrypted = CryptoJS.AES.decrypt(encryptedPseudo, key);

        encryptedPseudo = encryptedPseudo.toString();
        console.log(pseudo);
        console.log(encryptedPseudo);
        console.log(decrypted);
        console.log(decrypted.toString(CryptoJS.enc.Utf8));



        $("#suMail").val(encryptedMail);
        $("#suPseudo").val(encryptedPseudo);
        $("#suPassword").val(encryptedMDP);
        $("#suDate").val(encryptedDate);
        $("#suVPassword").val(encryptedVerifMDP); // Ou "" si on check juste le password ici et qu'on met cette valeur à nulle


    });










    $("#attributes_form").change(function() {
        doPOST('UpdateResultsServlet', updateResults, $(this).serialize());
    });

    $("#cityName").change(function(){

        var city = $("#cityName").val();

        doPOST('CompletionServlet', displayResults , city);


    });


    $("#signin").click(function () {

        if($("#connection").hasClass("formPanelVisible")) {
            $("#connection").animate({
                top : "-210px"
            }, 100).removeClass("formPanelVisible");
        } else {
            $("#connection").addClass("formPanelVisible");
            $("#inscription").removeClass("formPanelVisible");
        }

    });

    $("#signup").click(function () {

        if($("#inscription").hasClass("formPanelVisible")) {
            $("#inscription").animate({
                top : "-210px"
            }, 100).removeClass("formPanelVisible");
        } else {
            $("#inscription").addClass("formPanelVisible");
            $("#connection").removeClass("formPanelVisible");
        }

    });

    $(".close").click(function () {

        $(this).parent().animate({
            top : "-210px"
        }, 100).removeClass("formPanelVisible");

    });


    $("#moreInfos").click(function () {

        $("#score").attr("class", "scoreDetailed");
        $(this).addClass("activeButton").siblings(".activeButton").addClass("ex").removeClass("activeButton");

        $(".cityPromoPictureSum").fadeOut(300, function() {
            $(this).attr("class", "cityPromoPictureDetailed");
        }).fadeIn();

        $(".cityPanelsSlideshowSum").fadeOut(300, function() {
            $(this).attr("class", "cityPanelsSlideshowDetailed");

            $(".cityInfSum").each(function() {
                $(this).removeClass("cityInfSum").addClass("cityInfDetailed");

            });

            $("#arrows").css("width", "100%");
        }).fadeIn();



        $("#resultSection").removeClass("summedResult").addClass("detailedResult").one(animationEnd, function() {

            $( this ).off( animationEnd );
            $("#lessInfos").css("display", "block");
            $("#lessInfos").animate({
                top : "35px"
            });
            $("#pdf").fadeIn();
        });


    });

    $("#lessInfos").click(function () {

        $("button[class~='ex']").removeClass("ex").addClass("activeButton").siblings().removeClass("activeButton");

        $(".cityPromoPictureDetailed").fadeOut(300);

        $(".cityPanelsSlideshowDetailed").fadeOut(300);

        $("#score").fadeOut();
        
        $("#pdf").fadeOut();



        $(this).animate({
            top : "0"
        }, {
            complete: function() {
                $(this).hide();
                $("#resultSection").addClass("summedResult").removeClass("detailedResult").one(animationEnd, function() {

                    $(".cityPromoPictureDetailed").attr("class", "cityPromoPictureSum").fadeIn();

                    $(".cityInfDetailed").each(function() {
                        $(this).removeClass("cityInfDetailed").addClass("cityInfSum");
                    });

                    $("#arrows").css("width", "68%");

                    $(".cityPanelsSlideshowDetailed").attr("class", "cityPanelsSlideshowSum").fadeIn();
                    
                    $("#score").attr("class", "scoreSum").fadeIn();

                });
            }
        });


    });


    $("#showfilters").click(function () {

        $(this).addClass("activeButton").siblings().removeClass("activeButton");

        $("#attributes_panel, #attrPanelBackground").removeClass('animated bounceOutLeft').addClass('animated bounceInLeft');

        setTimeout(function () {

            $(".before, .after").animate(
                {
                    width : "60px"
                }, 300);

        }, 700);

    });

    $("#showmap").click(function () {

        $(this).addClass("activeButton").siblings().removeClass("activeButton");

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
    var currentCityPanel = $("#1");
    $("#arrowright").click(function () {
        if(leftVal > -900) {
            leftVal -= 100;

            $("#scoreContent").fadeOut(100).fadeIn(100, function() {
                $('#cityPanels').css("left", parseInt(leftVal) + '%');
                currentCityPanel = currentCityPanel.next();
                $("#scoreNum").text(currentCityPanel.attr('id'));
            }); 



        }
    });

    $("#arrowleft").click(function () {
        if(leftVal < 0) {
            leftVal += 100;

            $("#scoreContent").fadeOut(100).fadeIn(100, function() {
                $('#cityPanels').css("left", parseInt(leftVal) + '%');
                currentCityPanel = currentCityPanel.prev();
                $("#scoreNum").text(currentCityPanel.attr('id'));
            });
        }
    });


});

$(window).on('resize', function() {

    if($(window).width() < 580) {

        if($("#resultSection").outerHeight(true) < $("#content").outerHeight(true)) {
            $("#attributes_panel").css("height", $("#content").outerHeight(true) - $("#result").outerHeight(true));
            $("#resultSection").css("height", "35%");
            $("#map").css('height', $("#content").outerHeight(true) - $("#result").outerHeight(true));
        }

        $("#cat2").children("span").attr("class", "after");
        $("#cat4").children("span").attr("class", "after");

    }
    else {
        if($("#resultSection").height() != $("#content").outerHeight(true)) {
            $("#resultSection").css("height", "190px");
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


function chooseResult(result) {

    searchElement.value = previousValue = result.innerHTML;
    results.style.display = 'none'; 
    result.className = ''; 
    selectedResult = -1;
    searchElement.focus();

}

function displayResults(response) {

    results.style.display = response.length ? 'block' : 'none';

    if (response.length) {
        for(var i ; response.lenght; i++ ) {
            var responseLen = response.length;

            results.innerHTML = '';

            for (var i = 0, div ; i < responseLen ; i++) {

                div = results.appendChild(document.createElement('div'));
                div.innerHTML = response[i];

                div.onclick = function() {
                    chooseResult(this);
                };
            }

        }

    }

}


function updateResults(data) {
    //update results... 

    $.each(data, function (index, city) {


        $("#" + index + " > .cityInf").children(".cityName").text(city.name);
        $("#" + index + " > .cityInf").children(".cityWhereInfos").text(city.region + " - " + city.departement + ($("#attributes_form > [name='distance']").prop("checked") ? " - " + "25km de Paris" : ""));

        var details = $("#" + index + " > .details");

        if(city.culture != null) {

            details.append("<div class='Culture cat'>" +
                           "<h4>Culture</h4>" +
                           "<div class='scoreSlider'>" +
                           "<div class='scoreSliderColored' style='width : " + city.culture.score * 100 + "%;'></div><span class='scoreSlidercoloredCircle'></span><div class='scoreSliderGray'></div>");


            if(city.culture.details.animation != null) {



                details.append("<div id='Animation' class='crit'>" +
                               "<h5>Animation / Évènementiel</h5>" +
                               "<div class='scoreSlider'>" +
                               "<div class='scoreSliderColored' style='width:" + city.culture.details.animation.score * 100 + "%;'></div><span class='scoreSlidercoloredCircle'></span>" +
                               "</div>" +
                               "</div>");


                details.append("<div id='events'>" +
                               "<ul>" +
                               "<li>" + city.culture.details.animation.evenements[0].date + "|" + city.culture.details.animation.evenements[0].theme + "|" + city.culture.details.animation.evenements[0].nom_organisation + "</li>" +
                               "<li>" + city.culture.details.animation.evenements[1].date + "|" + city.culture.details.animation.evenements[1].theme + "|" + city.culture.details.animation.evenements[1].nom_organisation + "</li>" +
                               "<li>" + city.culture.details.animation.evenements[2].date + "|" + city.culture.details.animation.evenements[2].theme + "|" + city.culture.details.animation.evenements[2].nom_organisation + "</li>" +
                               "<li>" + city.culture.details.animation.evenements[3].date + "|" + city.culture.details.animation.evenements[3].theme + "|" + city.culture.details.animation.evenements[3].nom_organisation + "</li>" +
                               "<li>" + city.culture.details.animation.evenements[4].date + "|" + city.culture.details.animation.evenements[4].theme + "|" + city.culture.details.animation.evenements[4].nom_organisation + "</li>" +
                               "</ul>" +
                               "</div>");


            }


            details.append("</div>");




        }

        if(city.economie != null) {

            details.append("<div id='Economie' class='cat'>" +
                           "<h4>Économie</h4>" +
                           "<div class='scoreSlider'>" +
                           "<div class='scoreSliderColored' style='width:" + city.economie.score * 100 + "%;'></div><span class='scoreSlidercoloredCircle'></span><div class='scoreSliderGray'></div>" +
                           "</div>");

            if(city.economie.details.chomage != null) {

                details.append("<div id='Chomage' class='crit'>" +
                               "<h5>Chomâge faible</h5>" +
                               "<div class='scoreSlider'>" +
                               "<div class='scoreSliderColored' style='width:" + city.economie.details.chomage.score * 100 + "%;'></div><span class='scoreSlidercoloredCircle'></span>" +
                               "</div>" +
                               "</div>");


            }


            if(city.economie.details.tourisme != null) {

                details.append("<div id='Tourisme' class='crit'>" +
                               "<h5>Tourisme important</h5>" +
                               "<div class='scoreSlider'>" +
                               "<div class='scoreSliderColored' style='width:" + city.economie.details.tourisme.score * 100 + "%;'></div><span class='scoreSlidercoloredCircle'></span>" +
                               "</div>" +
                               "</div>");

            }

            if(city.economie.details.industrie != null) {

                details.append("<div id='Industrie' class='crit'>" +
                               "<h5>Industrie importante</h5>" +
                               "<div class='scoreSlider'>" +
                               "<div class='scoreSliderColored' style='width:" + city.economie.details.industrie.score * 100 + "%;'></div><span class='scoreSlidercoloredCircle'></span>" +
                               "</div>" +
                               "</div>");

            }

            if(city.economie.details.agriculture != null) {

                details.append("<div id='Agriculture' class='crit'>" +
                               "<h5>Agriculture importante</h5>" +
                               "<div class='scoreSlider'>" +
                               "<div class='scoreSliderColored' style='width:" + city.economie.details.agriculture.score * 100 + "%;'></div><span class='scoreSlidercoloredCircle'></span>" +
                               "</div>" +
                               "</div>");

            }


            if(city.economie.details.commerces != null) {

                details.append("<div id='Commerces' class='crit'>" +
                               "<h5>Variété de commerces</h5>" +
                               "<div class='scoreSlider'>" +
                               "<div class='scoreSliderColored' style='width:" + city.economie.details.commerces.score * 100 + "%;'></div><span class='scoreSlidercoloredCircle'></span>" +
                               "</div>" +
                               "</div>");

            }


            details.append("</div>");


        }

        if(city.population != null) {

            details.append("<div id='Population' class='cat'>" +
                           "<h4>Population</h4>" +
                           "<div class='scoreSlider'>" +
                           "<div class='scoreSliderColored' style='width:" + city.population.score * 100 + "%;'></div><span class='scoreSlidercoloredCircle'></span><div class='scoreSliderGray'></div>" +
                           "</div>");

            if(city.population.details.senior != null) {

                details.append("<div id='Senior' class='crit'>" +
                               "<h5>Senior</h5>" +
                               "<div class='scoreSlider'>" +
                               "<div class='scoreSliderColored' style='width:" + city.population.details.senior.score * 100 + "%;'></div><span class='scoreSlidercoloredCircle'></span>" +
                               "</div>" +
                               "</div>");

            }

            if(city.population.details.jeune != null) {

                details.append("<div id='Jeune' class='crit'>" +
                               "<h5>Jeune</h5>" +
                               "<div class='scoreSlider'>" +
                               "<div class='scoreSliderColored' style='width:" + city.population.details.jeune.score * 100 + "%;'></div><span class='scoreSlidercoloredCircle'></span>" +
                               " </div>" +
                               "</div>");

            }

            details.append("</div>");


        }

        if(city.services_publics != null) {

            details.append("<div id='ServicesPublics' class='cat'>" +
                           "<h4>Services Publics</h4>" +
                           "<div class='scoreSlider'>" +
                           "<div class='scoreSliderColored' style='width:" + city.services_publics.score * 100 + "%;'></div><span class='scoreSlidercoloredCircle'></span><div class='scoreSliderGray'></div>" +
                           "</div>");

            if(city.services_publics.details.sante != null) {

                details.append("<div id='Sante' class='crit'>" +
                               "<h5>Hôpitaux / médecins</h5>" +
                               "<div class='scoreSlider'>" +
                               "<div class='scoreSliderColored' style='width:" + city.services_publics.details.sante.score * 100 + "%;'></div><span class='scoreSlidercoloredCircle'></span>" +
                               "</div>" +
                               "</div>");

            }

            details.append("</div>");

        }







    });

}


