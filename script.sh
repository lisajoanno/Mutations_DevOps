#!/bin/sh

echo "Début de la chaîne de build..."
cd processor/
mvn clean
# Compilation de processor
mvn package

cd ../testsMutations
# Copie du répertoire source en dehors du projet
cp -R src/main/java/devops4/testsMutations/* ../
mvn clean
# Exécution des test sur le projet original maven
mvn test
# Le code source ici est celui des mutants
# Récupérer xml (surfire report), le déplacer