package auto_tester.test_functions;

import auto_tester.interfaces.ITestFunction;

import java.util.ArrayList;
import java.util.List;

public class Linear_test implements ITestFunction {
    @Override
    public List<Double> runTest(List<Double> outputs) {

        Double a=params.get(0),
                b=params.get(1);

        System.out.println("Paramètres de la fonction de test: (a,b) ="+params);

        ArrayList<Double> result=new ArrayList<>();

            if(outputs==null){

                return null;
            }

            else {
                switch (outputs.size()){


                    case 0:return result;

                    case 1 :{
                        Double x=outputs.get(0);

                                    result.add(a*x);



                    }






                }

            }


        return result;
    }
}
