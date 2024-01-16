[![Review Assignment Due Date](https://classroom.github.com/assets/deadline-readme-button-24ddc0f5d75046c5622901739e7c5dd533143b0c8e959d652212380cedb1ea36.svg)](https://classroom.github.com/a/VgXyX-GI)
# ATM-Project
Projecte Spring per simular un caixer autommàtic (ATM)

# ENUNCIAT 


Desenvolupar una aplicació que simuli un caixer automàtic (ATM) d’un banc.


# REQUISITS FUNCIONALS

## Part guiada

- L’ATM opera per a un banc determinat. 
- Els clients del banc en el caixer podran iniciar sessió amb una de les seves targetes. En iniciar l'aplicació demanarà el número de targeta i el seu PIN, si és correcta contínua l'aplicació i mostrarà el menú d'operacions disponibles; en cas contrari donarà un missatge d'error i no es podrà operar. 
- Si l'usuari no encerta el PIN un nombre determinat d'intents es bloqueja la targeta

- Tota targeta estarà associada a un compte bancari. Els clients del banc disposaran d’un o diversos comptes. Els comptes podran ser de dos tipus: comptes corrents o comptes d’estalvis.  Els comptes d’estalvis tenen un tipus d’interès que s’aplica de forma anual. Els comptes corrents seran els únics que poden tenir targetes associades.

- El caixer permetrà com a mínim fer les següents operacions:
    - Consultar el saldo del client (per compte i el total dels seus comptes)
    - Retirar diners del compte del client associat a la targeta. 
    - Ingressar diners a un dels comptes del client. 
    - Fer transferència de diners entre comptes 
    - canviar el PIN d’accés al caixer, 
    - fer logout,
    - ...

- Els diferents moviments que ha fet el client en un dels seus comptes podran ser consultats. De cada moviment n’haurem de saber: el tipus (ingrés, transferència…,), la data, quantitat diners implicats, …

## Part no guiada
 - El caixer opera únicament amb bitllets, i en disposa d’una certa quantitat de cada un d’ells. Les operacions d’extracció i d'ingrés afecten a la quantitat de diners emmagatzemada en el caixer. Quan es fan operacions d’extracció s’ha de comprovar que l’operació sigui possible segons els bitllets disponibles. S’ha d’informar al client de les quantitats de bitllets lliurades en l’operació. Quan es fa un ingrès podem utilitzar un teclat amb botons amb les diferents quantitats per indicar la quantitat dipositada.

- S’haurà d’implementar com a mínim una altra funcionalitat al caixer, diferent a les que s’han descrit anteriorment i que considereu que pot ser d’utilitat.



# REQUERIMENTS TÈCNICS
	 	 	 	
- Llenguatge de programació JAVA
- L’operativa del caixer s’haurà d’implementar a través d’una interfície gràfica de tipus web amb SPRING
- Interfície gràfica en Thyme Leaf d’SPRING 
- Estructura del programa en arquitectura MVC (Model-Vista-Controlador)
- Fer ús del Diagrama UML de classes adjunt del [Model](https://github.com/rcervera/ATM-Spring-template/blob/main/ATM-UML-Class%20diagram.png).
- Gestió d’errors i excepcions
- Codi documentat amb notació Javadoc
- Ús de col·leccions d’objectes (ArrayList o equivalents) per a la gestió de les llistes d’objectes en memòria
