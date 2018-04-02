<%@page import="java.util.Date"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>S'inscrire</title>
</head>
<body>
	


		Pseudo:<br> <input type="text" id="pseudo" name="pseudo"><br>
		Mail:<br> <input type="text" id="mail" name="mail"><br>
		Mot de Passe:<br> <input type="text" id="motdepasse" name="motdepasse"><br> 
		Confirmer Mot de Passe:<br> <input type="text" id="motdepasse2" name="motdepasse2"><br>


		<input type="submit" id="confirmer" value="Confirmer" onclick="truc">

		<script>
		
		function truc () {
			alert("test");
			
			var pseudo = $("#pseudo").val();
			var mail = $("#mail").val();
			var mdp = $("#motdepasse").val();
			
			var encryptedPseudo = Crypto.JS.AES.encrypt(
					pseudo,
					key,
					{iv: CryptoJS.enc.Hex.parse(iv)}
			
			);
			
			var encryptedMail = Crypto.JS.AES.encrypt(
					mail,
					key,
					{iv: CryptoJS.enc.Hex.parse(iv)}
			
			);
			
			var encryptedMDP = Crypto.JS.AES.encrypt(
					mdp,
					key,
					{iv: CryptoJS.enc.Hex.parse(iv)}
			
			);
			
			var ciphertext = encryptedPseudo.ciphertext.toString(CryptoJS.enc.Base64);
			
			
		}
		
		</script>




</body>
</html>