package diff_1D.base_functions;

import diff_1D.interfaces.Base1DFunction;

public class SquarePolynome1D implements Base1DFunction {

    double a,b,c;


    public SquarePolynome1D(double a, double b, double c) {
        this.a = a;
        this.b = b;
        this.c = c;
    }

    @Override
    public double run(double x) {
        return a*x*x+b*x+c;
    }
}
