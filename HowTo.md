#Présentation du travail#

##0 - Structure du projet##
Notre framework se compose de deux projets Maven : un projet <b>processor</b> contenant les processeurs spoon à appliquer sur le code source, qui est contenu dans notre second projet Maven <b>testsMutations</b>.

##1 - Exécution du framework##

Pour rappel, le projet se lance avec la commande :

    $ ./build_all.sh
Ce script lance en réalité 3 commandes qui représentent les 3 étapes de création du projet de tests par mutation. Ces 3 étapes peuvent également être lancées à la main à l'aide des commandes suivantes :

    $ ./clean.sh
Cette commande nettoie entièrement le répertoire du projet, en lançant des mvn clean dans les 2 projets Maven et en supprimant notamment les rapports de tests du dernier lancement du framework.

    $ ./process.sh
Cette commande va exécuter une série d'actions, listée ci-dessous :
<ul>
  <ul>
    <li>Assemblage du code compilé du projet <b>processor</b> pour obtenir un .jar exécutable.</li>
    <li>Copie du répertoire contenant le code source du projet testsMutations dans un dossier externe aux deux projets.</li>
    <li>Exécution des tests sur le code source d'origine</li>
  </ul>
</ul>

    $ ./report.sh
