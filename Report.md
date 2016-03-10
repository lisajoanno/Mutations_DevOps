#Analyse du travail réalisé

##Analyse critique
Lors de la mise en oeuvre du framework, nous nous sommes heurtés à quelques difficultés. 
En effet, nous étions partis dans un premier temps sur l'idée de développer la chaîne de build avec l'outil Maven exclusivement.
Ce choix ne fut pas très judicieux de notre part : le manque de maîtrise ainsi que la complexité de l'outil que nous avions à manipuler nous ont beaucoup ralentis. C'est pourquoi nous avons finalement pris la décision de passer par des scripts shell, afin de réaliser la construction du framework.


##Architecture du framework
Notre framework se constitue de deux projets Maven : un projet <b>processor</b> contenant les processeurs Spoon, ainsi qu'un projet <b>testsMutations</b> contenant le code source sur lequel on appliquera les mutations et effectuerons les tests.
Le framework se lance à l'aide de scripts shell, qui permettent d'automatiser l'enchaînement des commandes à réaliser pour construire le rapport final (au format html).
Ci-dessous, la chaîne de build obtenue à l'issu du projet :
<img src="img/chaine_finale.png" alt="Chaîne de build finale"/>

##Forces & faiblesses

###Forces
<ul>
<li>Notre framework est modulaire : en effet, nous pouvons utiliser ce framework sur les plateformes Windows et Ubuntu, ainsi que n'importe quel code source en entrée (deux projets distincts).</li>
<li>Les scripts shell sont indépendants du code source.</li>
<li>Les deux étapes du framework sont séparées en deux étapes bien distinctes : la partie "génération des processeurs et des rapports des tests" et la partie "analyse et génération du rapport".</li>
<li>On peut donc librement travailler sur une partie ou l'autre : si on écrit de nouveaux processeurs ou sélecteurs, le reste de la chaîne de build suit et le rapport se complète.</li>
<li>Le rapport des tests est plutôt complet : un taux de succes, le détail par mutation ainsi qu'un histogramme qui présente le nombre de fois où chaque test a échoué.</li>
</ul>

###Faiblesses
<ul>
<li>La génération de la page html du rapport final ne passe pas par Bootstrap : on génère la page à l'aide d'un script shell.</li>
<li>Les sélecteurs doivent être écrits en dur dans les processeurs : on ne passe pas par un fichier de configuration.</li>
<li>Le rapport pourrait être plus précis et plus informatif sur les tests qui sont passés ou non. On pourrait voir, par exemple, par mutation, les parties de code qui ont entrainé l'échec des tests.</li>
<li>Le rapport n'est pas destiné à être visuellement attractif.</li>
<li>Dans la génération des deux pages HTML, les "bouts d'HTML" sont insérés graduellement. Si on souhaite exploiter d'une autre manière les rapports de tests, il faut générer un nouveau fichier HTML.
</ul>


