package auto_tester.test_functions;

import auto_tester.interfaces.ITestFunction;

import java.util.Scanner;

/**
 * Created by UTIL04 on 28/02/2020.
 */
public class Racinecarre implements ITestFunction {

    @java.lang.Override
    public List<Number> runTest(List<Number> outputs) {
        return null;
    }

    private double n, r;

    public double racinecarre(double n){

        Scanner sc = new Scanner(System.in);
        System.out.println("Entrez n:");
        n = sc.nextFloat();

        if (n<0){
            System.out.println("la racine carré de ce nombre n'existe pas");
        }
        else{
            System.out.println("la racine carré de n est:" + Math.sqrt(n));
        }

        return 0;
    }


}
