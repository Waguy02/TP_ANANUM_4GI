package Finite_diff_and_vol;

import Finite_diff_and_vol.interfaces.*;
import Finite_diff_and_vol.matrice.BaseMatrice;
import Finite_diff_and_vol.matrice.BaseVector;


/***
 *
 *
 * Schéma de résolution de u''=-f dans [0,1]
 */


public class Diff1D_schema implements IFiniteDiff {

    private Integer n;
    private IBaseFunction1D f; // La fonction
    private double u_0, u_1;
    private double h;
    private BaseVector mesh;
    private ISolveMethod solve_method;
    private IGraphic visualizer;
    private Interpolation1D interpoler;

    private IMatrice A;

    private IVector X;

    private IVector B;

    public IGraphic getVisualizer() {
        return visualizer;
    }

    public void setVisualizer(IGraphic visualizer) {
        this.visualizer = visualizer;
    }

    public Integer getN() {
        return n;
    }

    public void setN(Integer n) {
        this.n = n;
    }

    public IBaseFunction1D getF() {
        return f;
    }


    public Diff1D_schema(Integer n, IBaseFunction1D f, double u_0, double u_1, ISolveMethod solve_method, IGraphic visualizer, Interpolation1D interpoler) {
        this.n = n;
        this.f = f;
        this.u_0 = u_0;
        this.u_1 = u_1;
        this.visualizer = visualizer;
        this.interpoler = interpoler;
        this.solve_method = solve_method;


        this.init_mesh();
        this.build_A();
        this.build_B();


    }


    private void init_X() {
        this.X = new BaseVector(this.n - 1);

    }

    @Override
    public void solve(Double parameters[]) {

        this.X = this.solve_method.solve(this.A, this.B, parameters);


    }

    /**
     * @return Les points De la fonction U sous la forme (x_i, U(xi)
     */

    @Override
    public IMatrice makePoints() {
        IMatrice points = new BaseMatrice (this.n + 1,2);

        points.set(0, 0, 0);
        points.set(0, 1, this.u_0);
        points.set(n, 0, 1);
        points.set(0, 1, this.u_1);


        for (int i = 1; i < n; i++) {
            points.set(i, 0, this.mesh.get(i));
            points.set(i, 1, this.X.get(i - 1));
        }
        System.out.println(points.toString());
        return points;

    }

    @Override
    public void init_mesh() {

        this.h = 1.0 / n;
        this.mesh = new BaseVector(n + 1);

        this.mesh.set(0, 0);
        this.mesh.set(n, 1);
        for (int i = 1; i < n; i++) {
            this.mesh.set(i, this.mesh.get(i - 1) + this.h);
        }


    }

    @Override
    public void build_A() {
        this.A = new BaseMatrice(n - 1, n - 1);

        int col_cursor = 0;


        for (int i = 1; i < n - 2; i++) {
            A.set(i, col_cursor, -1);
            A.set(i, col_cursor + 1, 2);
            A.set(i, col_cursor + 2, -1);
            col_cursor++;
        }


        A.set(0, 0, 2);
        A.set(0, 1, -1);

        A.set(n - 2, n - 3, -1);
        A.set(n - 2, n - 2, 2);


    }

    @Override
    public void build_B() {

        B = new BaseVector(n - 1);
        B.set(0, f.run(mesh.get(1)) - mesh.get(1) / (h * h));
        B.set(n - 2, f.run(mesh.get(n - 1)) - mesh.get(n) / (h * h));


        for (int i = 1; i < n - 2; i++) {

            B.set(i, f.run(mesh.get(i + 1)));
        }
    }

    @Override
    public void print_schema() {
        System.out.println("DIFF1_SCHEMA");
        System.out.println("MESH_LENGTH : " + this.n + " ; MESH :" + this.mesh.toString());

        System.out.println("\n A =" + this.A.toString() + " \n\n  X = " + this.X.toString() + "\n\n B = " + this.B.toString());

        System.out.println("\n AX=" + this.A.prod(this.X).toString() );


    }

    @Override
    public void visualize(double inf, double max) {

        double bounds[] = {inf, max};
        //System.out.println(this.makePoints().toString());
        IBaseFunction1D interpolated=this.interpoler.interpolate(this.makePoints());
        System.out.print(interpolated.run(10));
        this.visualizer.show1D(interpolated, bounds);

    }




    public void setF(IBaseFunction1D f) {
        this.f = f;
    }

    public BaseVector getMesh() {
        return mesh;
    }

    public void setMesh(BaseVector mesh) {
        this.mesh = mesh;
    }

    public ISolveMethod getSolve_method() {
        return solve_method;
    }

    public void setSolve_method(ISolveMethod solve_method) {
        this.solve_method = solve_method;
    }

    public IMatrice getA() {
        return A;
    }

    public void setA(IMatrice a) {
        A = a;
    }

    public IVector getX() {
        return X;
    }

    public void setX(IVector x) {
        X = x;
    }

    public IVector getB() {
        return B;
    }

    public void setB(IVector b) {
        B = b;
    }

    public Integer getn() {
        return n;
    }

    public void setn(Integer n) {
        this.n = n;
    }

    public IBaseFunction1D getf() {
        return f;
    }

    public void setf(IBaseFunction1D f) {
        this.f = f;
    }

    public double getU_0() {
        return u_0;
    }

    public void setU_0(double u_0) {
        this.u_0 = u_0;
    }

    public double getU_1() {
        return u_1;
    }

    public void setU_1(double u_1) {
        this.u_1 = u_1;
    }

    public double getH() {
        return h;
    }

    public void setH(double h) {
        this.h = h;
    }


}