package finite_diff.interfaces;

import finite_diff.matrice.BaseMatrice;
import finite_diff.matrice.BaseVector;

public interface IFiniteDifference {
    /**
     *
     *
     * @param parameters Les paramètres du solveur ; Par exemple , le nombre d'itérations
     */
    default void solve(Double parameters[]){

        this.X=this.solve_method.solve(this.A,this.B,parameters);





    }

    /**
     *
     * @return Les points De la fonction U sous la forme (x_i, U(xi)
     */

    default IMatrice makePoints(){
        IMatrice points=new BaseMatrice(2,this.n+1);

        points.set(0,0,0);points.set(0,1,this.u_0);
        points.set(n,0,1);points.set(0,1,this.u_1);


        for (int i=1;i<n;i++){
            points.set(i,0,this.mesh.get(i));
            points.set(i,1,this.X.get(i-1));
        }
        return  points;

    }

    default void init_mesh(){

        this.h=1.0/n;
        this.mesh=new BaseVector(n+1);

        this.mesh.set(0,this.u_0);
        this.mesh.set(n,this.u_1);
        for(int i=1;i<n;i++){
            this.mesh.set(i,this.mesh.get(i-1)+this.h);
        }





    }

    default void build_A(){
        this.A=new BaseMatrice(n-1,n-1);

        int col_cursor=0;


        for(int i=1;i<n-2;i++){
            A.set(i,col_cursor,-1);
            A.set(i,col_cursor+1,2);
            A.set(i,col_cursor+2,-1);
            col_cursor++;
        }


        A.set(0,0,2);
        A.set(0,1,-1);

        A.set(n-2,n-3,-1);
       A.set(n-2,n-2,2);


   }

    default void build_B(){

       B=new BaseVector(n-1);
        B.set(0,f.run(mesh.get(1))-mesh.get(1)/(h*h));
        B.set(n-2,f.run(mesh.get(n-1))-mesh.get(n)/(h*h));


        for(int i=1;i<n-2;i++){

            B.set(i,f.run(mesh.get(i+1)));
        }
   }

    default void print_schema(){
       System.out.println("DIFF1_SCHEMA");
       System.out.println("MESH_LENGTH : "+this.n+" ; MESH :" +this.mesh.toString());

       System.out.println("\n A ="+this.A.toString()+" \n\n  X = "+this.X.toString()+"\n\n B = "+this.B.toString());



   }

    default void visualize(double inf, double max){

       double bounds[]= {inf,max};
       this.visualizer.show(this.interpoler.interpolate(this.getPoints()),bounds);
   }
}
