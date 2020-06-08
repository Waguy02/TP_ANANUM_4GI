package diff_1D.solver;


import diff_1D.interfaces.IMatrice;
import diff_1D.interfaces.ISolveMethod;
import diff_1D.interfaces.IVector;
import diff_1D.matrice.BaseVector;

public class Gauss_seidel implements ISolveMethod {

    double DEFAULT_TOL=10E-6;
    int DEFAULT_N_ITERATIONS=100;
    // resolution de  AX=B par la méthode de Gauss_Seidel
    public IVector solver_GaussSeidel(IMatrice A, int taille, int N, IVector b, double tol, IVector X_0 ){
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
                double sum2= 0.0;
                double sum1= 0.0;

                for(int j=i+1; j<taille; j++){

                        sum2+= A.get(i,j)*X_0.get(j);
                }
                for (int j=0; j<i; j++){

                    sum1+= A.get(i,j)*X_res.get(j);
                }

                X_res.set(i,(b.get(i)-sum1 - sum2)/ A.get(i,i));
            }

            if (norme(X_0, X_res)<= tol){
                return X_res;
            }

            k++;

            for(int i= 0; i<taille; i++){
                X_0.set(i, X_res.get(i));
            }

        }

        return X_res;
    }


    public double norme(IVector X1, IVector X2) {
        double result=0 ;

        for (int i=0; i<X1.getLength();i++) {


            result =  result +Math.pow((X1.get(i)-X2.get(i)),2);

        }
        return Math.sqrt(result);

    }

    @Override
    public IVector solve(IMatrice A, IVector B,Double[] parameters) {

        double tol=DEFAULT_TOL;
        int N=DEFAULT_N_ITERATIONS;
        if(parameters!=null){
             if(parameters.length>0)tol=parameters[0];
             if(parameters.length>1)tol=parameters[1].intValue();

        }
        int taille=B.getLength()+2;



        return  solver_GaussSeidel(A,taille,N,B,tol,null);

    }
}


