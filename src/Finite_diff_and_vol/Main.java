package Finite_diff_and_vol;

import Finite_diff_and_vol.base_functions.SquarePolynome1D;
import Finite_diff_and_vol.graphic.Visualiser1D;
import Finite_diff_and_vol.interfaces.IFiniteDiff;
import Finite_diff_and_vol.interpolation.PIL1D;
import Finite_diff_and_vol.solver.Jacobi;
import javafx.application.Application;
import javafx.stage.Stage;

public class Main extends Application{


public static Stage stage0;

    @Override
    public void start(Stage primaryStage) throws Exception {

        stage0=primaryStage;


            IFiniteDiff test_schema=new Diff1D_schema(10,new SquarePolynome1D(1,5,6),2,3,new Jacobi(),new Visualiser1D(),new PIL1D());

            Double[] solve_parameters=null;
            test_schema.solve(solve_parameters);
            test_schema.visualize(0,1);
            test_schema.print_schema();






    }
}
