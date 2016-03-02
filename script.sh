#! /bin/sh

# Dossier courant
REPO=$(pwd) 
# Dossier où sont stockées les classes générant des mutants
REPO_MUTATIONS=$REPO/processor/src/main/java/devops4/processor
# Dossier où placer les mutants, pour faire mvn test
REPO_SOURCES_DES_TESTS=$REPO/testsMutations/src/main/java 
# pom.xml où placer les processeurs au fur et à mesure
POM=$REPO/testsMutations/pom.xml
# Dossier où sont contenus les rapports générés
REPO_RAPPORTS_GENERES=$REPO/testsMutations/target/surefire-reports
# Dossier où sont placés les raports des tests
REPO_RAPPORTS=$REPO/rapports

# Options à donner à Maven. -q : quiet (que les erreurs et les tests)
OPT_MVN='-q'





# On commence par tout nettoyer !
./clean.sh
echo "Début de la chaîne de build..." 



echo '\n   PACKAGE DE PROCESSOR' 
cd processor/ 
# Compilation de processor 
mvn $OPT_MVN package 

cd ../testsMutations

# Copie du répertoire source en dehors du projet
mkdir -p ../programme_original/ # -p : pas de warning si le fichier existe déjà
cp -R src/main/java/devops4/testsMutations/* ../programme_original/

echo '\n   TEST DU PROGRAMME ORIGINAL'
# Exécution des test sur le projet original maven
mvn $OPT_MVN test
# Le code source ici est celui des mutants
# Récupérer xml (surfire report), le déplacer



# Boucle 
#   Récupérer les mutants testsMutations/target/java/devops4/testsMutations
#   les déplacer dans le src/main/java de testsMutations
#   ced dans le pom pour ajouter le bon processor (boucle dans le fichier qui contient ../processor/src/main/java/devops4/processor)

# stocker les xml et blabla

echo '\n   TESTS SUR LES MUTANTS'
cd $REPO
rm -rf rapports
mkdir -p rapports

find $REPO_MUTATIONS -type f | while read processeur
do
    # Retrouver le nom simple du processeur
    PROCESSEUR=$(basename $processeur '.java')
    echo "\n\n           Processeur courant : $PROCESSEUR \n"
    
    # Remplacement dans le pom.xml par le bon processeur, dans la balise <processors>
    SED="s/<processor>.*/\<processor\>devops4.processor.$PROCESSEUR\<\/processor\>/"
    sed -i $SED $POM
    
    # Lancement de mvn tests, génération des rapports
    cd $REPO/testsMutations
    mvn $OPT_MVN test
    
    # Récupération du rapport en .xml
    FICHIER_TEST=''
    find $REPO_RAPPORTS_GENERES -type f | while read fichier
    do 
        FICHIER_TEST=$(basename $fichier)        
        if [ $(grep -cx *.xml $REPO_RAPPORTS_GENERES/$FICHIER_TEST) -eq 0 ]; then
            mv $REPO_RAPPORTS_GENERES/$FICHIER_TEST $REPO_RAPPORTS_GENERES/$PROCESSEUR-$FICHIER_TEST
            mv $REPO_RAPPORTS_GENERES/$PROCESSEUR-$FICHIER_TEST $REPO_RAPPORTS
        fi  
    done
done


