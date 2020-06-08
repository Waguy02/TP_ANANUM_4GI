package diff_1D.interpolation;

import diff_1D.interfaces.Base1DFunction;
import diff_1D.interfaces.IMatrice;
import diff_1D.interfaces.IVector;
import diff_1D.interfaces.Interpolation1D;

public class PIL implements Interpolation1D ,Base1DFunction{


        private IVector coefs;


    /***
     *
     * @param points les couples(x_i,yi): Une matrice (2*n)
     * @return
     */
    @Override
    public Base1DFunction interpolate(IMatrice points) {

        /**
         *
         *
         *  points contients les x_i,yi;
         *  Dans cette partie, tu calcules les coefficients alpha_i du PIL et tu les stockes dans coefs;
         *
         */


        return this;


    }





    @Override
    public double run(double x) {
        double result=0;

        for(int i=0;i<coefs.getLength();i++){

            result+=coefs.get(i)*Math.pow(x,i);

        }
    return result;
    }
}
