package auto_tester.base_functions;

import auto_tester.interfaces.IBaseFunction;

import java.util.ArrayList;
import java.util.List;

public class Square_root_solver implements IBaseFunction {
    @Override
    public List<Double> runBase(List<Double> params) {
            //Calcul de la racine carrée

        ArrayList<Double> result = new ArrayList<>();


        try {


            result.add(Math.sqrt(result.get(0)));
        }
        catch(Exception e){

            System.out.println(e.getMessage());
        }



        return result;
    }
}
