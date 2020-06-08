package finite_diff.interpolation;

import finite_diff.interfaces.BaseFunction1D;
import finite_diff.interfaces.IMatrice;
import finite_diff.interfaces.IVector;
import finite_diff.interfaces.Interpolation1D;
import finite_diff.matrice.BaseVector;

public class PIL1D implements Interpolation1D ,BaseFunction1D {


        private IVector coefs;


    /***
     *
     * @param points les couples(x_i,yi): Une matrice (2*n)
     * @return
     */
    @Override
    public BaseFunction1D interpolate(IMatrice points) {

        this.coefs=new BaseVector(points.getNCols());
        /**
         *
         *
         *  points contients les x_i,yi;
         *  Dans cette partie, tu calcules les coefficients alpha_i du PIL1D et tu les stockes dans coefs;
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
