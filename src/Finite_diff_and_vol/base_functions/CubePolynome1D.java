package Finite_diff_and_vol.base_functions;

import Finite_diff_and_vol.interfaces.IBaseFunction1D;

public class CubePolynome1D implements IBaseFunction1D {

    double a,b,c,d;


    public CubePolynome1D(double a, double b, double c,double d) {
        this.a = a;
        this.b = b;
        this.c = c;
        this.d=d;
    }

    @Override
    public double run(double x) {
        return a*x*x*x+b*x*x+c*x+d;
    }
}
