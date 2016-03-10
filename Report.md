#Analyse du travail réalisé

##Analyse critique
Lors de la mise en oeuvre du framework, nous nous sommes heurtés à quelques difficultés. En effet, nous étions partis dans un premier temps sur l'idée de développer la chaîne de build avec l'outil Maven exclusivement.
Ce choix ne fut pas très judicieux de notre part : le manque de maîtrise ainsi que la complexité de l'outil que nous avions à manipuler nous ont beaucoup ralentit. C'est pourquoi nous avons finalement pris la décision de passer par des scripts shell, afin de réaliser la construction du framework.

##Architecture du framework
Notre framework se constitue de deux projets Maven : un projet <b>processor</b> contenant les processeurs Spoon, ainsi qu'un projet <b>testsMutations</b> contenant le code source sur lequel on appliquera les mutations et effecturons les tests.
Le framework se lance à l'aide de scripts shell, qui permettent d'automatiser l'enchaînement des commandes à réaliser pour construire le rapport final (au format html).

##Forces & faiblesses

###Forces
<ul>
<li>Notre framework est modulaire : en effet, nous pouvons utiliser ce framework sur les plateformes Windows et Ubuntu, ainsi que n'importe quel code source en entrée (deux projets distincts).</li>
<li>Les scripts shell sont parfaitement indépendants du code source.</li>
</ul>

###Faiblesses
<ul>
<li>La génération de la page html du rapport final ne passe pas par Bootstrap : on génère la page à l'aide d'un script shell.</li>
</ul>
