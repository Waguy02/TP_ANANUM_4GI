package auto_tester.test_functions;

import auto_tester.interfaces.ITestFunction;

/**
 * Created by UTIL04 on 29/02/2020.
 */
public class EquationXsuperieurouegalazero implements ITestFunction {
    @java.lang.Override
    public List<Number> runTest(List<Number> outputs) {
        return null;
    }

    private double a,x;

    public double equation(double a){

        Scanner sc = new Scanner(System.in);
        System.out.println("Entrez a:");
        a = sc.nextFloat();

        if(a==0){
            System.out.println("l'équation n'a pas de solutions");
        }
        else{
            x = 0/b;
        }
        System.out.println("la solution de l'équation est:" + x);

        return 0;
    }
}
