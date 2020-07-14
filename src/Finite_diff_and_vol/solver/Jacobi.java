package Finite_diff_and_vol.solver;


import Finite_diff_and_vol.interfaces.IMatrice;
import Finite_diff_and_vol.interfaces.ISolveMethod;
import Finite_diff_and_vol.interfaces.IVector;
import Finite_diff_and_vol.matrice.BaseVector;

public class Jacobi implements ISolveMethod {

    double DEFAULT_TOL=10E-6;
    int DEFAULT_N_ITERATIONS=100000;

    // resolution de  AX=B par la méthode de Jacobi
    public IVector solver_Jacobi(IMatrice A, int taille, int N, IVector b, double tol, IVector X_0 ){
        //N est le nombre max d'itérations et X_0 l'état initiale


        IVector X_res = new BaseVector(taille);

        if(X_0==null){
            X_0=new BaseVector(taille);
            for(int i=0; i<taille; i++){
                X_0.set(i,0.0);
            }}

        int k=1;
        while (k<N){
            for(int i=0 ; i<taille; i++){
                double sum= 0.0;
                for(int j=0; j<taille; j++){
                    if(i!=j){
                        sum+= A.get(i,j)*X_0.get(j);
                    }
                }
                X_res.set(i,(b.get(i) - sum)/ A.get(i,i));

            }

            if (norme(X_0, X_res)<= tol){
                return X_res;
            }

            k++;

            for(int i= 0; i<taille; i++){
                X_0.set(i,X_res.get(i));

            }

        }

        return X_res;
    }


    public double norme(IVector X1, IVector X2) {
        double result=0 ;

        for (int i=0; i<X1.getLength() ;i++) {


                result =  result +Math.pow((X1.get(i)-X2.get(i)),2);

        }
        return Math.sqrt(result);

    }

    @Override
    public IVector solve(IMatrice A, IVector B, Double[] parameters) {
        double tol=DEFAULT_TOL;
        int N=DEFAULT_N_ITERATIONS;
        if(parameters!=null){
            if(parameters.length>0)tol=parameters[0];
            if(parameters.length>1)tol=parameters[1].intValue();

        }
        int taille=B.getLength();

        return this.solver_Jacobi(A,taille,N,B,tol,null);
    }
}
