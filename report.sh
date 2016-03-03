#! /bin/sh

rm index.html
touch index.html
echecs=0
succes=0

# Entête HTML


# Dossier courant
REPO=$(pwd) 
# Dossier où sont stockés les rapports
REPO_RAPPORTS=$REPO/rapports
# Donner les droits en lecture aux rapports
chmod 777 $REPO_RAPPORTS/*

find $REPO_RAPPORTS -type f | while read rapport
do
    NOM_PROC=$(basename $rapport);



    if grep 'failures="[1-9]"' $rapport
    then 
        echecs=$(($echecs+1))
    elif grep 'failure' $rapport
    then
        succes=$(($succes+1))
    fi
    echo $echecs >> echecs.txt
    echo $succes >> succes.txt
done

fin=$(cat "echecs.txt" | tail -1)
echecs=$fin


find=$(cat "succes.txt" | tail -1)
succes=$find

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
          ['Succès',     $succes],
          ['Echecs',      $echecs],
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

rm echecs.txt
rm succes.txt