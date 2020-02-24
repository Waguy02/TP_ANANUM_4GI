package auto_tester.base_functions;

import auto_tester.interfaces.IBaseFunction;

import java.util.ArrayList;
import java.util.List;

public class Square_two_solver implements IBaseFunction {
    @Override
    public List<Number> runBase(List<Number> params) {


        ArrayList<Number> result = new ArrayList<>();
        result.add(1);
        result.add(2);
        return result;
    }
}
