package auto_tester;

import auto_tester.data_generation.EquationType;
import auto_tester.data_generation.GenerateData;
import auto_tester.data_generation.Generator;
import auto_tester.data_parser.Reader;
import auto_tester.data_parser.Saver;
import auto_tester.models.GlobalTest;

public class Main {

public static String EXCEL_EXTENSION=".xlsx";
public static String QUADRATIC=EquationType.QUADRATIC+EXCEL_EXTENSION,
                    SQUARE_ROOT=EquationType.SQUARE_ROOT+EXCEL_EXTENSION,
                    LINEAR=EquationType.LINEAR+EXCEL_EXTENSION,
                    SUM=EquationType.SUM+EXCEL_EXTENSION;


    /***
     * 1. Configuration :
     *     1.1. Importer les librairies Apache POI
     *
     *      1.2. Spécifier l'emplacement des données de test(TEST_DATASET_FOLDER)  et des résultats de tests (TEST_OUTPUT_FOLDER) Dans le fichier GLOBAL_CONFIG.java
     *
     *
     * 2. Comment exécuter ?
     *
     *      2.1. Décommenter l'une des instructions "GlobalTest globalTest =...." pour éxécuter le test sur l'une des fonctions  suivantes :
     *          QUADRATIC => EQUATION DE DEGRE 2
     *          SQUARE_ROOT => CALCUL DE RACINE CARREE
     *          SUM => SOMME DE DEUX NOMBRES
     *          LINEAR => EQUATION DE DEGRE1
                 *
     *      2.2. Exécuter la fonction main  :
     *          - Les données de test(respectivement les résultats)  sont générées dans le repertoiré TEST_DATASET_FOLDER(respectivemeent TEST_OUTPUT_FOLDER) sous forme de fichiers Excel.
     *
     *
     *
     *
     * @param args
     */







public static void main (String args[]){



try{
System.out.println("Début de la génération des données de test");


GenerateData.main(args);
}catch (Exception e){

    e.printStackTrace();;
    System.out.println(e.getMessage());
}



    //GlobalTest globalTest= Reader.read(SUM);
    //GlobalTest globalTest= Reader.read(SQUARE_ROOT);
    //GlobalTest globalTest= Reader.read(LINEAR);
    GlobalTest globalTest= Reader.read(QUADRATIC);



globalTest.execute_all();
   Saver.save(globalTest);


}








}


