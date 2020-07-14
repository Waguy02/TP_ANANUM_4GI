package Finite_diff_and_vol.base_functions;

import Finite_diff_and_vol.interfaces.IBaseFunction1D;

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
