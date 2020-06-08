package finite_diff;

import finite_diff.base_functions.SquarePolynome;
import finite_diff.graphic.ZeroGraphic;
import finite_diff.interpolation.PIL1D;
import finite_diff.solver.Gauss_seidel;

public class Main {



    public static void main(String args[]){


        Diff1D_schema test_schema=new Diff1D_schema(10,new SquarePolynome(1,5,6),2,3,new Gauss_seidel(),new ZeroGraphic(),new PIL1D());

        Double[] solve_parameters=null;
        test_schema.solve(solve_parameters);



        test_schema.visualize(0,1);
    }
}
