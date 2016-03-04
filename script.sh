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
OPT_MVN=''





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

# On remet le pom sans processeurs
cat $REPO/poms/pom_basique.xml > $REPO/testsMutations/pom.xml   

echo '\n   TEST DU PROGRAMME ORIGINAL'
# Exécution des test sur le projet original maven
mvn $OPT_MVN test


# Rendre propre le pom.xml de base (enlever le processeur de base)
# bon pour l'instant faisons ça 
cat $REPO/poms/pom_processor.xml > $REPO/testsMutations/pom.xml

# Tests sur les mutants & génération des rapports dans /rapports

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
        if [ $(find $fichier -name "*.xml" | wc -l) -gt 0 ]; then
            mv $REPO_RAPPORTS_GENERES/$FICHIER_TEST $REPO_RAPPORTS_GENERES/$PROCESSEUR-$FICHIER_TEST
            mv $REPO_RAPPORTS_GENERES/$PROCESSEUR-$FICHIER_TEST $REPO_RAPPORTS
        fi  
    done
done

# On remet le pom sans processeurs
cat $REPO/poms/pom_basique.xml > $REPO/testsMutations/pom.xml

echo 'Fin des tests par mutation'
