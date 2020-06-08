package auto_tester.norms;

import auto_tester.interfaces.INorm;

import java.util.List;

public class Null_error  implements INorm {
    @Override
    public Double run(List<Double> number_1, List<Double> number_2) {
        if(number_1==null && number_2==null )return 0.0;
        else  return 1.0;

    }
}
