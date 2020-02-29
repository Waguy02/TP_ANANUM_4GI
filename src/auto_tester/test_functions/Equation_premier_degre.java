package auto_tester.test_functions;

import auto_tester.interfaces.ITestFunction;

/**
 * Created by UTIL04 on 29/02/2020.
 */
public class Equation_premier_degre implements ITestFunction {

    @java.lang.Override
    public List<Number> runTest(List<Number> outputs) {
        return null;
    }

    private double a,b, x;
    public double equation(double a, double b){

        Scanner sc = new Scanner(System.in);
        System.out.println("Entrez a:");
        a = sc.nextFloat();

        System.out.println("Entrez b:");
        b = sc.nextFloat();

        x=-b/a;

        if(a==0&b==0){
            System.out.println("équation a une infinité de solution");
        }
        else{
            System.out.println("l'équattion n'a pas de solutions");
        }
        if(a!=0){
            System.out.println("la solution est :" +x);
        }

        return 0;
    }

}
