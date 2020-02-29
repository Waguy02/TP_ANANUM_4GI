package auto_tester.base_functions;

import auto_tester.interfaces.IBaseFunction;

import java.util.ArrayList;
import java.util.List;

public class Square_two_solver implements IBaseFunction {
    @Override
    public List<Number> runBase(List<Number> params) {


        ArrayList<Number> result = new ArrayList<>();
        if(result.get(0).doubleValue()>=0){
        result.add(Math.sqrt((double) result.get(0)));
        }
      
        return result;
    }
}
