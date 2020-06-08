package diff_1D.matrice;

import cern.colt.matrix.impl.DenseDoubleMatrix1D;
import diff_1D.interfaces.IVector;

public class BaseVector implements IVector {
    private DenseDoubleMatrix1D values;

    @Override
    public double get(int ind) {
        return  this.values.get(ind);
    }

    @Override
    public void set(int ind, double value) {
        this.values.set(ind,value);
    }

    @Override
    public int getLength() {
        return this.values.size();
    }


    public BaseVector(int size){
        this.values=new DenseDoubleMatrix1D(size);
    }

    public String toString(){
        return this.values.toString();
    }
}
