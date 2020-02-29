package auto_tester.test_functions;

import auto_tester.interfaces.ITestFunction;

/**
 * Created by UTIL04 on 28/02/2020.
 */
public class Sommereel implements ITestFunction {
    @java.lang.Override
    private double x,y,s;
    public List<Number> runTest(List<Number> outputs) {

        System.out.println("entrez la premiere valeur");

        System.out.println("x = ");
        x = Double.valueOf(lecture()).doubleValue();

        System.out.println("entrez la deuxieme valeur");

        System.out.println("\ny = ");
        y = Double.valueOf(lecture()).doubleValue();

        s = x + y ;

        System.out.println(" la sommme des deux nombres est : " +  s);

        return null;
    }


}
