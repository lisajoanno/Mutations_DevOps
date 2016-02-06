<html>
<head>
<style type="text/css">
body {
  background-color : blue;
}
</style>
</head>
<body>

<h1>Tests par mutation</h1>

<h2>Description du framework :</h2>

L’entrée de notre framework est constituée d’un programme java et de ses tests. Notre framework vérifiera la pertinence et l’efficacité de ces tests en introduisant des mutations dans le code testé, et en lançant les tests. En effet, tester un code java permet de détecter des bugs spécifiques prévus à l’avance, mais tester les tests permet d’éviter la plupart des bugs potentiels, même les plus imprévisibles. Pour cela, on crée des mutations, on les applique sur le code source, en fonction des sélecteurs choisis.

<h2>Chaîne de build</h2>

<p>
D'abord, on compile le programme source pour obtenir des fichiers binaires. On applique n mutations pour obtenir n programmes mutants. On applique la suite de test à tous ces mutants, et on compare la sortie de ces tests avec la sortie des tests appliqués au programme original. 
On considère qu'un mutant est tué si la sortie des tests appliqués au programme mutant est différente que la sortie des tests appliqués au programme original.
On mesure ensuite le quotient entre les mutants tués et les mutants créés. Plus ce quotient est proche de 1, plus les tests sont fiables.
</p>

<figure>
<img src="img/chaine_build.png" alt="Chaîne de build"><br />
<figcaption>Figure 1 : <u>Chaîne de build</u></figcaption>
</figure>

<p>
On est en Java donc on utilise <i>javac</i> pour compiler les fichiers sources.
On génère ensuite des programmes mutants à l'aide de <i>spoon</i> en couplant des mutations et des sélecteurs <i>(cf. plus bas)</i>. On utilise <i>JUnit</i> pour tester l'ensemble des programmes (original et mutants), on obtient des <i>.xml</i> de résultats des tests. On extrait les données de ces résultats, puis on les met en forme à l'aide de <i>Bootstrap</i> et on génère une page <i>html</i> pour les afficher.
</p>

<h2>Liste des mutations à appliquer</h2>
<ul>
<li>
Enlever ou rajouter les mots clés "static" et "final" "@Override"
</li>
<li>
Enlever une méthode qui est "@Override"
</li>
<li>
Externaliser les classes internes
</li>
<li>
Changer les opérateurs de comparaisons : <, >, <=, >=, ==, !=
</li>
<li>
Permuter 2 lignes de code
</li>
<li>
Remplacer une incrémentation par une décrémentation
</li>
<li>
Enlever les cast
</li>
<li>
Remplacer les boucles "while" par "do while"
</li>
<li>
Inverser les booléens
</li>
<li>
Enlever le "this." avant l'utilisation d'une méthode ou d'un attribut
</li>
<li>
Enlever les "try - catch" pour ne laisser que le contenu du "try"
</li>
<li>
Supprimer ou altérer les déclarations de variables
</li>
<li>
Changer l'accessibilité des classes, méthodes, variables
</li>
<li>
Changer les opérateurs : +, *, -, /
</li>
<li>
Incrémenter ou décrémenter un entier
</li>
<li>
Remplacer les opérateurs logiques dans les conditions : &&, ||
</li>
<li>
Placer des "break" ou "return" au milieu du code
</li>
<li>
Dans une structure "if - else" et "switch - case", changer l'ordre des conditions
</li>
<li>
Enlever les "extend" "implements" et "import"
</li>
<li>
Faire correspondre les typages dynamique et statique
</li>
<li>
Enlever les constructeurs
</li>
<li>
Changer l'ordre des arguments dans l'appel / déclaration / implémentation des méthodes
</li>
<li>
Changer la valeur d'une constante
</li>
</ul>

<h2>Liste des sélecteurs</h2>
<ul>
<li>
Entête / corps d'une classe, méthode
</li>
<li>
A l'intérieur d'une condition
</li>
<li>

</li>
</ul>

</body>
</html>
