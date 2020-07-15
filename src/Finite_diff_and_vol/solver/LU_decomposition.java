package Finite_diff_and_vol.solver;


import Finite_diff_and_vol.interfaces.IMatrice;
import Finite_diff_and_vol.interfaces.ISolveMethod;
import Finite_diff_and_vol.interfaces.IVector;
import Finite_diff_and_vol.matrice.BaseMatrice;
import Finite_diff_and_vol.matrice.BaseVector;

public class LU_decomposition implements ISolveMethod {




    public IVector solver_LU(IMatrice A, int n, IVector b){
        IVector X_res= new BaseVector(n);
        IVector Z = new BaseVector(n); // avec LZ= b


        //la décomposition de A en LU

            IMatrice L= new BaseMatrice(n,n);
            IMatrice U = new BaseMatrice(n,n);

            // Decomposition de A en Upper U and Lower L

            for (int i = 0; i < n; i++) {

                // IMatrice Upper U
                for (int k = i; k < n; k++) {

                    // Somme de L(i, j) * U(j, k)
                    int sum = 0;
                    for (int j = 0; j < i; j++)
                        sum += (L.get(i,j) * U.get(j,k));

                    //  U(i, k)
                    U.set(i,k, A.get(i,k) - sum);
                }

                // IMatrice Lower L
                for (int k = i; k < n; k++) {
                    if (i == k)
                    L.set(i,i , 1); // Diagonal as 1
                    else {

                        // Somme de  L(k, j) * U(j, i)
                        int sum = 0;
                        for (int j = 0; j < i; j++)
                            sum += (L.get(k,j) * U.get(j,i));

                        // L(k, i)
                        L.set(k,i,(A.get(k,i) - sum) / U.get(i,i));
                    }
                }

            }


        //calcul de Z avec LZ=b

        for (int i=0; i<n; i++){
            double sum =0.0;
            for(int j = 0; j<i; j++){
                sum+=L.get(i,j) *Z.get(j);
            }

            Z.set(i,b.get(i)-sum);        }

        // calcul de X_res avex UX_res=Z

        for(int i=n-1; i>=0; i--){
            double sum =0.0;
            for(int j=i+1;j<n;j++){
                sum+=U.get(i,j)*X_res.get(j);
            }
            X_res.set(i,(Z.get(i)-sum)/U.get(i,i));

        }


        return X_res;


    }

    @Override
    public IVector solve(IMatrice A, IVector B, Double[] solve_parameters) {
        return solver_LU(A,B.getLength(),B);
    }
}