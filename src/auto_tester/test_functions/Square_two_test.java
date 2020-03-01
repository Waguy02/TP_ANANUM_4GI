package auto_tester.test_functions;

import auto_tester.interfaces.ITestFunction;

import java.util.ArrayList;
import java.util.List;

public class Square_two_test implements ITestFunction {



    @Override
    public List<Double> runTest(List<Double> outputs) {

        Double a=params.get(0),
                b=params.get(1),
                c=params.get(2);


        System.out.println("paramètres de la fonction de test , (a,b,c) = "+params);

        ArrayList<Double> result=new ArrayList<>();



        if(outputs==null)
        {
            result=null;
        }
        else {
        switch (outputs.size()){

            case 0 :break;
            case 1:{
                Double x=outputs.get(0);

                result.add(this.squareTwoCalculation(a,b,x));
            }break;

            case 2: {
                    Double x1=outputs.get(0);
                    Double val1=this.squareTwoCalculation(a,b,x1);

                    Double x2=outputs.get(1);
                    Double val2=this.squareTwoCalculation(a,b,x2);



                    result.add((1/2)*val2+val1);


                    } break;




        }
    }
System.out.println("Resulat de la fonction de test : "+result);
return result;
    }



    public double squareTwoCalculation(double a, double b,double x){

    return (a*x*x)+(b*x);

    }
}
