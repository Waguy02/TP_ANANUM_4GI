package auto_tester.models;

import java.util.ArrayList;

public class GlobalTest {


    private ArrayList<SingleTest> tests=new ArrayList<>();
    private String test_dataset_name;


    public void execute_all(){

        int counter=0;
        for (SingleTest singleTest:this.getTests()){
            counter++;
            System.out.println("\n Test :=N°" +counter);
            singleTest.run();
            System.out.println("Résultat du test: "+ singleTest.getResult());

        }
    }



    public GlobalTest(){


    }

    public ArrayList<SingleTest> getTests() {
        return tests;
    }

    public void setTests(ArrayList<SingleTest> tests) {
        this.tests = tests;
    }

    public String getTest_dataset_name() {
        return test_dataset_name;
    }

    public void setTest_dataset_name(String test_dataset_name) {
        this.test_dataset_name = test_dataset_name;
    }

    public GlobalTest(String test_dataset_name) {
        this.test_dataset_name = test_dataset_name;
    }
}
