#! /bin/sh

# Supprime un peu tout
# A remplir surement

cd processor
mvn -q clean
cd ../testsMutations
mvn -q clean 
cd ..
rm -Rf rapports # -f : sans confirmation

# Rendre propre le pom.xml de base (enlever le processeur de base)

echo 'Cleaned !'
