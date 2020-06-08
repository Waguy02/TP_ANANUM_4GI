package auto_tester.norms;

import auto_tester.interfaces.INorm;

import java.util.List;

public class Empty_error implements INorm {
    @Override
    public Double run(List<Double> number_1, List<Double> number_2) {
        return (number_1.isEmpty()&&number_2.isEmpty())?0.0:1.0;
    }
}
