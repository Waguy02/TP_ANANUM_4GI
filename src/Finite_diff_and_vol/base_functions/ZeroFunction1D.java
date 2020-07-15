package Finite_diff_and_vol.base_functions;

import Finite_diff_and_vol.interfaces.IBaseFunction1D;

public class ZeroFunction1D implements IBaseFunction1D {




    @Override
    public double run(double x) {
        return 0;
    }
}
