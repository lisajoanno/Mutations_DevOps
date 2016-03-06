#! /bin/sh

rm index.html
touch index.html
echecs=0
succes=0
ncompile=0

# Entête HTML


# Dossier courant
REPO=$(pwd) 
# Dossier où sont stockés les rapports
REPO_RAPPORTS=$REPO/rapports
# Donner les droits en lecture aux rapports
chmod 777 $REPO_RAPPORTS/*

find $REPO_RAPPORTS -type f | while read rapport
do
    NOM_PROC=$(basename $rapport "-TEST-devops4.testsMutations.BasicProgramTest.xml");

    if grep 'errors="[1-9]"' $rapport
    then 
        ncompile=$(($ncompile+1))
        echo $NOM_PROC >> ncompileName.txt
    elif grep 'failures="[1-9]"' $rapport
    then 
        echecs=$(($echecs+1))
        echo $NOM_PROC >> echecsName.txt
    elif grep 'failure' $rapport
    then
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
    <div id=\"piechart\" style=\"width: 900px; height: 500px;\"></div>
  </body>
</html>
" >> index.html

# Cleaning temporary files...
rm echecs.txt
rm succes.txt
rm ncompile.txt
rm successName.txt
rm echecsName.txt
rm ncompileName.txt
