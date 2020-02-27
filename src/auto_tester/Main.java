package auto_tester;

import auto_tester.data_parser.Reader;
import auto_tester.data_parser.Saver;
import auto_tester.models.GlobalTest;

public class Main {


public static String filename="TEST_SOLVEUR_1.xlsx";





public static void main (String args[]){


    GlobalTest globalTest= Reader.read(filename);
    globalTest.execute_all();


    Saver.save(globalTest);


}







}


