#! /bin/sh

# Supprime un peu tout
# A remplir surement

cd processor
mvn -q clean
cd ../testsMutations
mvn -q clean 
cd ..
rm -Rf rapports # -f : sans confirmation
rm -Rf programme_original

# Rendre propre le pom.xml de base (enlever le processeur de base)
# bon pour l'instant faisons ça 
cat pom_original.xml > testsMutations/pom.xml

echo 'Cleaned.'
