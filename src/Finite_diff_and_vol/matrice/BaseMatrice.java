package Finite_diff_and_vol.matrice;

import cern.colt.matrix.impl.DenseDoubleMatrix2D;
import Finite_diff_and_vol.interfaces.IMatrice;
import Finite_diff_and_vol.interfaces.IVector;

public class BaseMatrice implements IMatrice {

    private DenseDoubleMatrix2D values;




    @Override
    public double get(int i, int j) {
        return this.values.get(i,j);
    }

    @Override
    public void set(int i, int j,double value) {

        this.values.set(i,j,value);

    }

    @Override
    public int getNCols() {
        return values.columns();
    }

    @Override
    public int getNRows() {
        return values.rows();
    }

    public BaseMatrice(int n,int m){
        this.values=new DenseDoubleMatrix2D(n,m);
    }




    public String toString(){
        return values.viewDice().toString();
    }

    @Override
    public double[] getCol(int index) {
        double[] res=new double[this.getNCols()];
        for (int i=0;i<this.getNCols();i++){
            res[i]=this.get(i,index);
        }
        return res;
    }

    @Override
    public IMatrice prod( IMatrice B) {
        return null;
    }

    @Override
    public IVector prod( IVector X) {
        IVector result=new BaseVector(X.getLength());

        for(int i=0;i<this.getNRows();i++){

            double current=0;

            for(int j=0;j<X.getLength();j++){
                current+=this.get(i,j)*X.get(j);
            }
            result.set(i,current);

        }





        return  result;

    }


}
