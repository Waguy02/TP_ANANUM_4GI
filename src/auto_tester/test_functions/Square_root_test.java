package auto_tester.test_functions;

import auto_tester.interfaces.ITestFunction;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

public class Square_root_test implements ITestFunction {
    @Override
    public List<Double> runTest(List<Double> outputs) {
        ArrayList<Double> result = new ArrayList<>();
        if (outputs.size() == 0) {
        } else {
            Double x = outputs.get(0);
            result.add(x * x);
        }
        return result;
    }
}