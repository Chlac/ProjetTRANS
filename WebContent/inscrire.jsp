<%@ page import="java.util.Date"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<script src="https://cdnjs.cloudflare.com/ajax/libs/crypto-js/3.1.2/rollups/aes.js"></script>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>S'inscrire</title>
</head>
<body>




	<form>
		Pseudo:<br> <input type="text" id="pseudo" name="pseudo"><br>
		Mail:<br> <input type="text" id="mail" name="mail"><br>
		Mot de Passe:<br> <input type="text" id="motdepasse"name="motdepasse"><br> 
		Confirmer Mot de Passe:<br> <input type="text" id="motdepasse2" name="motdepasse2"><br>
		
		


		<input type="submit" id="confirmer" value="Confirmer" onclick="truc()">
	</form>

	<script>
		function truc() {

			var date = new Date();
			
			var pseudo = document.getElementById('pseudo').value;
			var mail = document.getElementById('mail').value;
			var mdp = document.getElementById('motdepasse').value;
			
			mdp = mdp + date.toString();
			
			alert(mdp);
			
			var key = "dbrCUoc4z9EFJTLBSsZtQw==";


			// PROCESS
			var encrypted = CryptoJS.AES.encrypt(pseudo, key);
			var encrypted = CryptoJS.AES.encrypt(mail, key);
			var encrypted = CryptoJS.AES.encrypt(mdp, key);
			
			
			var decrypted = CryptoJS.AES.decrypt(encrypted, key);
			
			
			console.log(pseudo);
			console.log(encrypted);
			console.log(decrypted);
			console.log(decrypted.toString(CryptoJS.enc.Utf8));
			
			
			

		}
	</script>





</body>
</html>