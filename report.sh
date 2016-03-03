#! /bin/sh

rm index.html
touch index.html

# Entête HTML
echo "<!DOCTYPE html>
<html>
<head>
<title>Rapport des tests par mutation</title>
</head>
<body>

<h1>Rapport des tests par mutation</h1><p>" >> index.html

# Dossier courant
REPO=$(pwd) 
# Dossier où sont stockés les rapports
REPO_RAPPORTS=$REPO/rapports
# Donner les droits en lecture aux rapports
chmod 777 $REPO_RAPPORTS/*

find $REPO_RAPPORTS -type f | while read rapport
do
    #echo $rapport
    NOM_PROC=$(basename $rapport);

    #~ if grep ".txt" $NOM_PROC
    #~ then



    echo $NOM_PROC >> index.html


    if grep 'errors="[1-9]"' $rapport
    then 
        echo '<pre style="background-color:red">Erreur</pre>' >> index.html

    elif grep 'failures="[1-9]"' $rapport
    then 
        echo '<pre style="background-color:orange">Failure</pre>' >> index.html

    elif grep 'failure' $rapport
    then
        echo '<pre style="background-color:green">ok</pre>' >> index.html

    
    fi
    
    echo "<br /><br />" >> index.html
    
    #~ fi   
    
done

# Fin HTML
echo "</p></body>
</html>" >> index.html

# Ouvre le rapport sous firefox
firefox index.html


