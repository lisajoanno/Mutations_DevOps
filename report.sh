#! /bin/sh

rm -f index.html
touch index.html

# Dossier courant
REPO=$(pwd) 
# Dossier où sont stockés les rapports
REPO_RAPPORTS=$REPO/rapports
# Donner les droits en lecture aux rapports
chmod 777 $REPO_RAPPORTS/*







#-------------------------------          TAUX DE SUCCES

echecs=0
succes=0
ncompile=0

find $REPO_RAPPORTS -type f | while read rapport
do
    NOM_PROC=$(basename $rapport ".xml");

    if grep -q 'errors="[^0]"' $rapport
    then 
        ncompile=$(($ncompile+1))
        echo $NOM_PROC >> ncompileName.txt
    elif grep -q 'failures="[^0]"' $rapport
    then 
        echecs=$(($echecs+1))
        echo $NOM_PROC >> echecsName.txt
    else
        succes=$(($succes+1))
        echo $NOM_PROC >> successName.txt
    fi
    # Fichiers temporaires pour stockers les valeurs
    # des variables
    echo $echecs >> echecs.txt
    echo $succes >> succes.txt
    echo $ncompile >> ncompile.txt
  done

# Récupération des dernières valeurs
fin=$(cat "echecs.txt" | tail -1)
echecs=$fin

find=$(cat "succes.txt" | tail -1)
succes=$find

fint=$(cat "ncompile.txt" | tail -1)
ncompile=$fint

# On supprime les retours chariots par des espaces
s=$(cat successName.txt | tr '\n' ' ')
e=$(cat echecsName.txt | tr '\n' ' ')
ec=$(cat ncompileName.txt | tr '\n' ' ')

echo "<html>
  <head>
    <LINK href=\"style.css\" rel=\"stylesheet\" type=\"text/css\">
    <meta charset=\"UTF-8\">

    <script type=\"text/javascript\" src=\"https://www.gstatic.com/charts/loader.js\"></script>
    <script type=\"text/javascript\">
      google.charts.load('current', {'packages':['corechart']});
      google.charts.setOnLoadCallback(drawChart);
      function drawChart() {
        var data = google.visualization.arrayToDataTable([
          ['Tests par mutations', 'Mutants tués / vivants'],
          ['Succès : $s',              $succes],
          ['Erreur de compilation : $ec',  $ncompile],
          ['Echecs : $e',              $echecs],
        ]);
        var options = {
          title: 'Résultat des tests par mutations'
        };
        var chart = new google.visualization.PieChart(document.getElementById('piechart'));
        chart.draw(data, options);
      }
    </script>
    
  </head>
  <body>
    <h1>Rapport de test après mutations</h1>
    <h2>Taux de succès des tests après les mutations</h2>
    <div id=\"piechart\" style=\"width: 900px; height: 500px;\"></div>" >> index.html

# Cleaning temporary files...
rm echecs.txt
rm succes.txt
rm ncompile.txt
rm successName.txt
rm echecsName.txt
rm ncompileName.txt





#-------------------------------          DETAIL DES TESTS PAR MUTATION


# Génération du détail des tests par mutation
echo "<h2>Détails des tests par mutation</h2>" >> index.html

# Par rapport de test
find $REPO_RAPPORTS -type f | while read rapport
do
    # On récupère le nom
    NOM_PROC=$(basename $rapport ".xml")
    # On l'ajoute au html
    echo "<h4> Processeur : "$NOM_PROC"</h4><p>" >> index.html
    # On ajoute les tests qui sont passés (ils n'ont pas d'enfant "failure")
    echo '<p style="color:green">' >> index.html
    echo $(xmllint --xpath "/testsuite/testcase[not(failure)]/@name" $rapport 2>/dev/null ) >> index.html
    echo '</p>' >> index.html    
    # On ajoute les tests qui ne sont pas passés (ils ont un enfant "failure")
    echo '<p style="color:red">' >> index.html
    echo $(xmllint --xpath "/testsuite/testcase[failure]/@name" $rapport 2>/dev/null) >> index.html
    # On ajoute le "message" ou le "type" de l'échec du test
    echo $(xmllint --xpath "/testsuite/testcase[failure]/failure/@message" $rapport 2>/dev/null ) >> index.html 
    echo $(xmllint --xpath "/testsuite/testcase[failure]/failure/@type" $rapport 2>/dev/null ) >> index.html
    echo '</p>' >> index.html  
    echo "<br/></p>" >> index.html
done





echo "</body>
</html>" >> index.html

















#-------------------------------          DETAIL PAR TEST



# On va créer :
# - un fichier contenant les noms des tests (tempTest.txt)
# - un fichier contenant les noms des tests qui ont failed (testsFail.txt)
# - un fichier contenant les noms des tests qui ont réussi (testsSucces.txt)
# - une page HTML (histogrammeTest.html) qui contiendra l'histogramme résultat 

# Nettoyage
rm -f tempTest.txt testsSucces.txt testsFail.txt histogrammeTest.html
# Compteur pour créer tempTest.txt : au premier rapport de test observé, on écrit dessus les noms des tests
compteur=1
# Par rapport de test
find $REPO_RAPPORTS -type f | while read rapport
do 
    # Récupération des noms des compteurs dans tempTest.txt
    if [ $compteur -eq 1 ] 
    then 
        echo $(xmllint --xpath "/testsuite/testcase/@name" $rapport 2>/dev/null ) >> tempTest.txt
        compteur=`expr $compteur + 1`
    fi
    # Si le test est passé, on le met dans testsSucces.txt
    echo "cat /testsuite/testcase[not(failure)]/@name" | xmllint --shell $rapport | while read line; 
    do  
        echo $line >> testsSucces.txt
    done 
    # S'il a échoué, on le place dans testsSucces
    echo "cat /testsuite/testcase[failure]/@name" | xmllint --shell $rapport | while read line; 
    do  
        echo $line >> testsFail.txt
    done 
done


# Génération du détail des tests par mutation
echo "

<!DOCTYPE html>
<html>
  <head>
    <title>Détail par test</title>
    <LINK href=\"style.css\" rel=\"stylesheet\" type=\"text/css\">
    <meta charset=\"UTF-8\">
  </head>
<h2>Détail par test</h2>
  <body class=\"devsite-layout-docs devsite-framebox\">
<p style=\"display: none; height: 0; width: 0\">This is a snippet from developers.google.com</p>
  <script type=\"text/javascript\" src=\"https://www.gstatic.com/charts/loader.js\"></script>
  <script type=\"text/javascript\">
    google.charts.load(\"current\", {packages:['corechart']});
    google.charts.setOnLoadCallback(drawChart);
    function drawChart() {

      var data = google.visualization.arrayToDataTable([
        ['Nom du test', 'Echecs']," >> histogrammeTest.html

for i in $(cat tempTest.txt)
do
    echo "['$i', " >> histogrammeTest.html
    grep -o $i testsFail.txt | wc -l >> histogrammeTest.html
    echo "]," >> histogrammeTest.html
done

echo "      ]);
      var options = {
        title: \"Nombre d'échecs par test\",
        width: 600,
        height: 400,
        bar: {groupWidth: '95%'},
        legend: { position: 'none' },
      };
      var chart = new google.visualization.ColumnChart(document.getElementById('columnchart_plain'));
      chart.draw(data, options);
  }
  </script>
<div id=\"columnchart_plain\" style=\"width: 900px; height: 300px;\"></div>
</body>
</html>
"  >> histogrammeTest.html

rm -f tempTest.txt testsSucces.txt testsFail.txt



