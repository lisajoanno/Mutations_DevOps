#! /bin/sh

cd processor
mvn -q clean
cd ../testsMutations
mvn -q clean 
cd ..
rm -Rf rapports
rm -Rf programme_original
rm -f index.html histogrammeTest.html

echo 'Cleaned.'
