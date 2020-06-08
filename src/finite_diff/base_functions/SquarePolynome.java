package finite_diff.base_functions;

import finite_diff.interfaces.IBaseFunction1D;

public class SquarePolynome implements IBaseFunction1D {

    double a,b,c;


    public SquarePolynome(double a, double b, double c) {
        this.a = a;
        this.b = b;
        this.c = c;
    }

    @Override
    public double run(double x) {
        return a*x*x+b*x+c;
    }
}
