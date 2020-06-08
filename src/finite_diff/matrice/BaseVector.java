package finite_diff.matrice;

import cern.colt.matrix.impl.DenseDoubleMatrix1D;
import finite_diff.interfaces.IVector;

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

    @Override
    public IVector diff( IVector X_2) {

        BaseVector result=new BaseVector(this.getLength());
        for(int i=0;i<this.getLength();i++){
            result.set(i,this.get(i)-X_2.get(i));
        }

    return result;
    }
}
