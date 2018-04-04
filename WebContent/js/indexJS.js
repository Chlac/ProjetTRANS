/**
 * 
 */

$(document).ready(function () {

    var animationEnd = 'webkitAnimationEnd mozAnimationEnd MSAnimationEnd oanimationend animationend';

    if ($(window).width() < 580) {
        $("#cat2").children("span").attr("class", "after");
        $("#cat4").children("span").attr("class", "after");
    } else {
        $("#cat2").children("span").attr("class", "before");
        $("#cat4").children("span").attr("class", "before");
    }
   
    $("#signinForm").submit(function () {
        alert("SignIn");
        
        $("#siPseudo").val("Caca");
        $("#sPassword").val("Caca");
        
    });
    
    $("#signupForm").submit(function () {
        
        alert("SignUp");
        
        var mail = $("#suMail").val();
        var pseudo = $("#suPseudo").val();
        var mdp = $("#suPassword").val();
        var verifMdp = $("#suVPassword").val();
        
        $("#suMail").val("Caca");
        $("#suPseudo").val("Caca");
        $("#suPassword").val("Caca");
        $("#suVPassword").val("Caca");

        /*
        
        var encryptedPseudo = Crypto.JS.AES.encrypt(pseudo, key, {
            iv : CryptoJS.enc.Hex.parse(iv)
        });

        var encryptedMail = Crypto.JS.AES.encrypt(mail, key, {
            iv : CryptoJS.enc.Hex.parse(iv)
        });

        var encryptedMDP = Crypto.JS.AES.encrypt(mdp, key, {
            iv : CryptoJS.enc.Hex.parse(iv)
        });

        var ciphertext = encryptedPseudo.ciphertext
        .toString(CryptoJS.enc.Base64);

        var secret = "coucou";

        var key = "dbrCUoc4z9EFJTLBSsZtQw==";

        // Entré : String Utf8
        var test = CryptoJS.AES.encrypt(secret, key, { iv: key, mode: CryptoJS.mode.CBC, padding: CryptoJS.pad.Pkcs7 });

        // Entré : String Base 64
        var pass = CryptoJS.AES.decrypt(test, key, { iv: key, mode: CryptoJS.mode.CBC, padding: CryptoJS.pad.Pkcs7 });

        console.log(pass.toString(CryptoJS.enc.Utf8) + "#");*//*

        
        */
    });
    
    $("#attributes_form").change(function() {
        doPOST('UpdateResultsServlet', updateResults, $(this).serialize());
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
/*
    $("#signinSubmit").click(function () {
        
        alert("sdqsd");

        var pseudo = $("#suPseudo").val();
        var mdp = $("#suPassword").val();





        var url = 'inscrire.jsp';
        var form = $('<form action="' + url + '" method="post">' +
                     '<input type="text" name="pseudo" value="' + encodeURIComponent(pseudo) + '" />' +
                     '<input type="text" name="mdp" value="' + encodeURIComponent(mdp) + '" />' +
                     '</form>');
        $('body').append(form);
        form.submit();
        
        return false;


    });

/*
    $("#signupSubmit").click(function () {
        
        alert("sdqsd");

        var mail = $("#siMail").val();
        var pseudo = $("#siPseudo").val();
        var mdp = $("#siPassword").val();
        var verifMdp = $("#siVPassword").val();

        /*
        var encryptedPseudo = Crypto.JS.AES.encrypt(pseudo, key, {
            iv : CryptoJS.enc.Hex.parse(iv)
        });

        var encryptedMail = Crypto.JS.AES.encrypt(mail, key, {
            iv : CryptoJS.enc.Hex.parse(iv)
        });

        var encryptedMDP = Crypto.JS.AES.encrypt(mdp, key, {
            iv : CryptoJS.enc.Hex.parse(iv)
        });

        var ciphertext = encryptedPseudo.ciphertext
        .toString(CryptoJS.enc.Base64);

        var secret = "coucou";

        var key = "dbrCUoc4z9EFJTLBSsZtQw==";

        // Entré : String Utf8
        var test = CryptoJS.AES.encrypt(secret, key, { iv: key, mode: CryptoJS.mode.CBC, padding: CryptoJS.pad.Pkcs7 });

        // Entré : String Base 64
        var pass = CryptoJS.AES.decrypt(test, key, { iv: key, mode: CryptoJS.mode.CBC, padding: CryptoJS.pad.Pkcs7 });

        console.log(pass.toString(CryptoJS.enc.Utf8) + "#");*//*

        var data = 
            'mail=' + encodeURIComponent(mail) +'&'+ 
            'pseudo=' + encodeURIComponent(pseudo) +'&'+ 
            'mdp=' + encodeURIComponent(mdp) +'&'+ 
            'verifMdp=' + encodeURIComponent(verifMdp);

        //window.location.replace('home.jsp?' + data);

        var url = 'home.jsp';
        var form = $('<form action="' + url + '" method="post">' +
                     '<input type="text" name="mail" value="' + encodeURIComponent(mail) + '" />' +
                     '<input type="text" name="pseudo" value="' + encodeURIComponent(pseudo) + '" />' +
                     '<input type="text" name="mdp" value="' + encodeURIComponent(mdp) + '" />' +
                     '<input type="text" name="verifMdp" value="' + encodeURIComponent(verifMdp) + '" />' +
                     '</form>');
        $('body').append(form);
        form.submit();
        

    });

*/
    $(".close").click(function () {

        $(this).parent().animate({
            top : "-210px"
        }, 100).removeClass("formPanelVisible");

    });


    $("#moreInfos").click(function () {


        $("#result").removeClass("summedResult").addClass("detailedResult").one(animationEnd, function() {

            $( this ).off( animationEnd );
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
                $(this).hide();
                $("#result").addClass("summedResult").removeClass("detailedResult");
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
        $('#cityPanels').css("left", parseInt(leftVal) + '%');
    });

    $("#arrowleft").click(function () {
        if(leftVal < 0) leftVal += 100;
        $('#cityPanels').css("left", parseInt(leftVal) + '%');
    });


});

$(window).on('resize', function() {

    if($(window).width() < 580) {
        if($("#result").height() != $("#content").outerHeight(true)) {
            $("#result").css("height", "35%");
            $("#map").css('height', $("#content").outerHeight(true) - $("#result").outerHeight(true));
        }

        $("#cat2").children("span").attr("class", "after");
        $("#cat4").children("span").attr("class", "after");

    }
    else {
        if($("#result").height() != $("#content").outerHeight(true)) {
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
