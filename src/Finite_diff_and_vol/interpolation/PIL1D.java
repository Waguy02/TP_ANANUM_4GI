package Finite_diff_and_vol.interpolation;

import Finite_diff_and_vol.interfaces.IBaseFunction1D;
import Finite_diff_and_vol.interfaces.IMatrice;
import Finite_diff_and_vol.interfaces.IVector;
import Finite_diff_and_vol.interfaces.Interpolation1D;
import Finite_diff_and_vol.matrice.BaseVector;
import java.math.*;
import org.apache.commons.math3.analysis.polynomials.PolynomialFunctionLagrangeForm;

public class PIL1D implements Interpolation1D  {


        private IVector coefs;


    @Override
    public IVector getCoefs() {
        return coefs;
    }

    public void setCoefs(IVector coefs) {
        this.coefs = coefs;
    }

    /***

     *
     * @param points les couples(x_i,yi): Une matrice (2*n)
     * @return
     */
    @Override
    public IBaseFunction1D interpolate(IMatrice points) {

        this.coefs=new BaseVector(points.getNRows());
        /**
         *
         *
         *  points contients les x_i,yi;
         *  Dans cette partie, tu calcules les coefficients alpha_i du PIL1D et tu les stockes dans coefs;
         *
         */


        double[] X=points.getCol(0),Y=points.getCol(1);

;
        PolynomialFunctionLagrangeForm pol = new PolynomialFunctionLagrangeForm( X , Y );

        double [] P = pol.getCoefficients();

        for(int i=0;i<P.length;i++){
            coefs.set(i,P[i]);
        }


        return new IBaseFunction1D() {
            @Override
            public double run(double x) {
                double result=0;

                for(int i=0;i<coefs.getLength();i++){

                    result+=coefs.get(i)*Math.pow(x,i);

                }
                return  result;
            }
        };

    }





/*
    @Override
    public double run(double x) {
        double result=0;

        for(int i=0;i<coefs.getLength();i++){

            result+=coefs.get(i)*Math.pow(x,i);

        }
    return result;
    }*/
}
