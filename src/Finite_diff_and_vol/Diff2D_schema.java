package Finite_diff_and_vol;

import Finite_diff_and_vol.interfaces.*;
import Finite_diff_and_vol.matrice.BaseMatrice;


/**
 *
 * Résolution de l'équation "Laplacien(U) =-f dans [0,1]*[0,1}"
 */
public class Diff2D_schema implements IFiniteDiff {

    private Integer n,m;
    private double h,k;

    private IBaseFunction2D f; // La fonction
    private IMatrice bound_values;

    private BaseMatrice mesh;
    private ISolveMethod solve_method;
    private IGraphic visualizer;
    private Interpolation2D interpoler;

    private IMatrice A;

    private IVector X;

    private IVector B;


    public Diff2D_schema(Integer n,Integer m, IBaseFunction2D f, IMatrice bound_values, ISolveMethod solve_method, IGraphic visualizer, Interpolation2D interpoler) {
        this.n = n;
        this.m=m;

        this.f = f;

        this.bound_values=bound_values;
        this.visualizer = visualizer;
        this.interpoler = interpoler;
        this.solve_method = solve_method;


        this.init_mesh();
        this.build_A();
        this.build_B();


    }


    @Override
    public void solve(Double[] parameters) {

    }

    @Override
    public IMatrice makePoints() {
        return null;
    }

    @Override
    public void init_mesh() {
        this.h=1.0/n;
        this.k=1.0/m;

        this.mesh=new BaseMatrice(n+1,m+1);



        for (int j = 1; j < m; j++) {
            this.mesh.set(0,j,this.bound_values.get(0,0));
            this.mesh.set(n,j,this.bound_values.get(0,1));
        }

        for (int i = 1; i < n; i++) {
            this.mesh.set(i,0,this.bound_values.get(1,0));
            this.mesh.set(i,m,this.bound_values.get(1,1));
        }




        for (int i = 1; i < n; i++) {
            for(int j=1;i<m;i++){
            this.mesh.set(i,j,this.h*i+this.k*j);
        }
        }


    }

    @Override
    public void build_A() {
        this.A=new BaseMatrice(n-1,m-1);








    }

    @Override
    public void build_B() {

    }

    @Override
    public void print_schema() {
        System.out.println("DIFF2_SCHEMA");
        System.out.println( " MESH :" + this.mesh.toString());

        System.out.println("\n A =" + this.A.toString() + " \n\n  X = " + this.X.toString() + "\n\n B = " + this.B.toString());


    }

    @Override
    public void visualize(double inf, double max) {

        double bounds[] = {inf, max};
        this.visualizer.show(this.interpoler.interpolate(this.makePoints()), bounds);
    }
}
