#Analyse du travail réalisé

##Architecture du framework
Notre framework se constitue de deux projets Maven : un projet <b>processor</b> contenant les processeurs Spoon, ainsi qu'un projet <b>testsMutations</b> contenant le code source sur lequel on appliquera les mutations et effecturons les tests.
Le framework se lance à l'aide de scripts shell, qui permettent d'automatiser l'enchaînement des commandes à réaliser pour construire le rapport final (au format html).

##Forces & faiblesses

###Forces
<ul>
<li>Notre framework est modulaire : en effet, nous pouvons utiliser ce framework sur les plateformes Windows et Ubuntu.</li>
<li>Les processeurs sont parfaitement indépendants du code source, tout comme nos scripts shell.</li>
</ul>

###Faiblesses
<ul>
<li>La génération de la page html du rapport final ne passe pas par Bootstrap : on génère la page à l'aide d'un script shell.</li>
</ul>
