package auto_tester.test_functions;

import auto_tester.interfaces.ITestFunction;

import java.util.ArrayList;
import java.util.List;

public class Sum_Test implements ITestFunction {
    @Override
    public List<Double> runTest(List<Double> outputs) {
        if(outputs==null){
            return null;
        }
        else{

            ArrayList<Double> result=new ArrayList<>();
            result.add(outputs.get(0)+outputs.get(1));
            return  result;
        }
    }
}
