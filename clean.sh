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

rm index.html

echo 'Cleaned.'
