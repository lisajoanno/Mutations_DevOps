# Projet SI4 - Tests par mutations

## Présentation de l’équipe

* Arnaud GARNIER
* Lisa JOANNO
* Thibaut SORIANO

## Présentation du projet

Lors de ce projet, nous allons développer un framework de tests par mutation à l’aide de plusieurs outils comme spoon, maven, junit.
Nous allons d’abord établir une liste de mutations possibles sur un code java, puis nous allons établir une liste de sélecteurs, c’est-à-dire la partie de code sur laquelle on applique chaque mutation.
Ensuite, grâce à notre framework, nous présenterons les résultats des tests sur une page html sous forme de graphiques, et avec un détail des tests ayant fonctionné ou non.

## Lancement du projet

Le projet se lance avec la commande :

		$ ./build_all.sh

Ce script lance en fait 3 commandes qui représentent les 3 étapes de création du projet de tests par mutation. Ces 3 étapes peuvent également être lancées à la main à l'aide des commandes suivantes :

		$ ./clean.sh

Cette commande nettoie entièrement le répertoire du projet, en lançant des <i>mvn clean</i> dans les 2 projets Maven et en supprimant notamment les rapports de tests du dernier lancement du framework. 

		$ ./process.sh

Cette commande se décompose en 3 parties :
* Création des processeurs spoon dans le répertoire processor/ avec <i>mvn package</i>. Ceci aura pour effet de compiler les processeurs et de les rendre disponibles pour la suite.
* Compilation et test du programme original dans le répertoire testsMutations/ avec <i>mvn test</i>. 
* Pour chaque processeur présent dans processor/ :

  * Modification du <i>pom.xml</i> de testsMutations/ pour faire muter le programme original selon le processeur courant .
  
  * Lancement de <i>mvn test</i> pour tester le programme muté.
  
  * Copie du rapport <i>XML</i> de test dans un dossier rapports/.


		$ ./report.sh

Cette commande va analyser les rapports de tests présents dans rapports/ pour générer une page <i>index.html</i> rendant compte des différents effets des mutations sur les tests. 

## Chaîne de build
