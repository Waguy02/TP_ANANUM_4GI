package auto_tester.models;

import auto_tester.interfaces.ITestFunction;

/**
 * Created by UTIL04 on 28/02/2020.
 */
public class equation_second_degre implements ITestFunction {


    @java.lang.Override

    public List<Number> runTest(List<Number> outputs) {
        return null;
    }

    double a,b,c,delta=0,x1,x2;

    public double equation(double a, double b, double c)
    {

        System.out.println("Entrez les valeurs de a,b,c tel que ax\u00FD+bx+c=0\n\n");

        System.out.println("a = ");
        a = Double.valueOf(lecture()).doubleValue();

        System.out.println("\nb = ");
        b = Double.valueOf(lecture()).doubleValue();

        System.out.println("\nc = ");
        c = Double.valueOf(lecture()).doubleValue();

        if (a==0){
            System.out.println("c'est une equation de premier degré");
        }

        if (delta==0){
            x1=-b/2*a;

            System.out.println("la solution est x1 =" + x1);

        }

        delta = (b*b) - 4*a*c;
        if (delta<0)
        {
            System.out.println("\n\nIl n'y a pas de racines reelle a l'equation.");
        }
        else
        {
            x1 = (-b-Math.sqrt(delta))/(2*a);
            x2 = (-b+Math.sqrt(delta))/(2*a);
            System.out.println("\n\nLes racines sont x1 = " + x1 + " et x2 = " +x2);
        }
        return 0;
    }
}
