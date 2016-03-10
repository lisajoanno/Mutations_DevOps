#Build#

##Comment construire le framework ?##

Le projet se lance avec la commande :

    $ ./build_all.sh

On peut aussi construire le framework étape par étape :

    $ ./clean.sh

Nettoie le projet.

    $ ./process.sh

Applique les processeurs au code et génère les rapports de test.

    $ ./report.sh

Construit le rapport dans index.html et histogrammeTest.html.

Il est conseillé de lancer le framework sous ubuntu où xmllint est déjà installé.
Dans process.sh, on mettre la valeur de OPT_MVN à '-q' pour rendre silencieux Maven.
