package diff_1D.base_functions;

import diff_1D.interfaces.Base1DFunction;

public class exponential1D implements Base1DFunction {

    double a,b;


    public exponential1D(double a, double b) {
        this.a = a;
        this.b = b;
        
    }

    @Override
    public double run(double x) {
        return a*Math.exp(b*x) ;// ae^(bx)
    }
}
