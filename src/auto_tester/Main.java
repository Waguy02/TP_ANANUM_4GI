package auto_tester;

import auto_tester.data_generation.GenerateData;
import auto_tester.data_generation.Generator;
import auto_tester.data_parser.Reader;
import auto_tester.data_parser.Saver;
import auto_tester.models.GlobalTest;

public class Main {


public static String filename="QUADRATIC.xlsx";





public static void main (String args[]){



        generateData();

   GlobalTest globalTest= Reader.read(filename);
    globalTest.execute_all();


    Saver.save(globalTest);


}




public static void generateData(){

    //Appeler l'une des fonctions de générations de données;
    try {
        GenerateData.generateQuadraticData();
    }catch (Exception e){

        e.printStackTrace();
    }
    ;

}




}


