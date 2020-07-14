package Finite_diff_and_vol;

import Finite_diff_and_vol.base_functions.SquarePolynome;
import Finite_diff_and_vol.graphic.ZeroGraphic;
import Finite_diff_and_vol.interfaces.IFiniteDiff;
import Finite_diff_and_vol.interpolation.PIL1D;
import Finite_diff_and_vol.solver.Gauss_seidel;

public class Main {



    public static void main(String args[]){


        IFiniteDiff test_schema=new Diff1D_schema(10,new SquarePolynome(1,5,6),2,3,new Gauss_seidel(),new ZeroGraphic(),new PIL1D());

        Double[] solve_parameters=null;
        test_schema.solve(solve_parameters);



        test_schema.visualize(0,1);
    }
}
