package diff_1D;

import diff_1D.base_functions.SquarePolynome;
import diff_1D.solver.Gauss_seidel;
import diff_1D.solver.LU_decomposition;

public class Main {



    public static void main(String args[]){


        Diff1D_schema test_schema=new Diff1D_schema(10,new SquarePolynome(1,5,6),2,3,new LU_decomposition());

        test_schema.solve();
        test_schema.print_schema();
    }
}
