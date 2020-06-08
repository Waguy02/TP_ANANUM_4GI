package diff_1D.matrice;

import cern.colt.matrix.impl.DenseDoubleMatrix2D;
import diff_1D.interfaces.IMatrice;

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




}
