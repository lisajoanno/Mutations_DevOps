#Présentation du travail#

##Structure du projet##
La description de l'architecture du framework est décrite dans le fichier <i><b>Report.md</b></i>.

<p>
/
├── img (images)
├── poms
│   ├── pom.basique.xml
│   └── pom_processor.xml
├── processor
│   ├── src
│   └── pom.xml
├── testsMutations
│   ├── src
│   └── pom.xml
├── build_all.sh
├── clean.sh
├── process.sh
└── report.sh
</p>

##Exécution du framework##

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
    <li>Compilation et exécution des tests sur le code source d'origine du projet <b>testsMutations</b>.</li>
    <li>Modification du fichier pom.xml, en vue de l'application des processeurs sur le code source.</li>
    <li>Pour chaque processeur, faire :</li>
    <ul>
        <li>Modifier le pom.xml du projet testsMutations (on ajoute le nom du processeur Spoon à appliquer).</li>
        <li>Compiler et exécuter des tests sur le code généré mutant.</li>
        <li>Générer un rapport de ces tests au format xml et les déplacer dans un dossier externe au projet (<i>../rapports</i>).</li>
    </ul>
    <li>Restitution de l'ancien pom.xml dans le projet <b>testsMutations</b>.</li>
  </ul>
</ul>

    $ ./report.sh
Cette commande génère une page <i>index.html</i> qui est un bilan graphique des résultats des tests par mutations.
On génère un camembert afin de voir combien de mutants ont été tués, combien sont encore en vie et combien ont généré des erreurs de compilation.
On peut également consulter le nom des processeurs concernés par ces résultats et le détail, par mutation, des tests qui sont passés ou non.
On trouve dans histogrammeTest.html un histogramme qui indique combien de fois les tests ne sont pas passés, pour se donner une idée des tests les plus pertinents.


##Utiliser notre framework##

On peut vouloir utiliser ce framwork pour plusieurs raisons :
<ul>
<li>Ajouter un processeur : il suffit d'ajouter la classe du processeur dans <i>processor/src/main/java/devops4/processor</i>.</li>
<li>Ajouter (modifier) le programme testé : il faut placer son programme dans <i>testsMutations/src/main/java</i>.</li>
<li>Ajouter des tests : il faut ajouter les tests (ou les classes de test) dans <i>testsMutations/src/test/java/devops4/testsMutations</i>.</li>
<li>Modifier le compte rendu des tests : il faut pour cela modifier <i>report.sh</i>.
</ul>

