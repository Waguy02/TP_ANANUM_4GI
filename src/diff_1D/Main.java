package diff_1D;

import diff_1D.base_functions.SquarePolynome;
import diff_1D.graphic.ZeroGraphic;
import diff_1D.interpolation.PIL;
import diff_1D.solver.Gauss_seidel;
import diff_1D.solver.Jacobi;
import diff_1D.solver.LU_decomposition;

public class Main {



    public static void main(String args[]){


        Diff1D_schema test_schema=new Diff1D_schema(10,new SquarePolynome(1,5,6),2,3,new Gauss_seidel(),new ZeroGraphic(),new PIL());

        test_schema.solve();
        System.out.println("Difference");
        System.out.println(test_schema.schema_diff().toString());
    }
}
