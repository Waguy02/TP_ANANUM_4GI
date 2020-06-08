package diff_1D;

import diff_1D.interfaces.*;
import diff_1D.matrice.BaseMatrice;
import diff_1D.matrice.BaseVector;

public class Diff1D_schema {

    private Integer n;


    private Base1DFunction f; // La fonction

    private double u_0,u_1;


    private double h;


    private BaseVector mesh;

    private ISolveMethod solve_method;

    private IGraphic visualizer ;


    private Interpolation1D interpoler;




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

    public Base1DFunction getF() {
        return f;
    }

    public void setF(Base1DFunction f) {
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

    public Base1DFunction getf() {
        return f;
    }

    public void setf(Base1DFunction f) {
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




    public Diff1D_schema(Integer n, Base1DFunction f, double u_0, double u_1,ISolveMethod solve_method,IGraphic visualizer,Interpolation1D interpoler) {
        this.n = n;
        this.f = f;
        this.u_0 = u_0;
        this.u_1 = u_1;
        this.visualizer=visualizer;
        this.interpoler=interpoler;
        this.solve_method=solve_method;


        this.init_mesh();
        this.build_A();
        this.build_B();


    }



    public void solve(){

        this.X=this.solve_method.solve(this.A,this.B,null);
    }


    public void init_mesh(){

        this.h=1.0/n;
        this.mesh=new BaseVector(n+1);

        this.mesh.set(0,this.u_0);
        this.mesh.set(n,this.u_1);
        for(int i=1;i<n;i++){
            this.mesh.set(i,this.mesh.get(i-1)+this.h);
        }





    }




   public void build_A(){
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
    

   private void init_X(){
        this.X=new BaseVector(this.n-1);

   }

   
   private void build_B(){
        
       B=new BaseVector(n-1);
        B.set(0,f.run(mesh.get(1))-mesh.get(1)/(h*h));
        B.set(n-2,f.run(mesh.get(n-1))-mesh.get(n)/(h*h));


        for(int i=1;i<n-2;i++){

            B.set(i,f.run(mesh.get(i+1)));
        }
   }

   private IMatrice A;
    
    private IVector X;
    
    private IVector B;





    public void print_schema(){
        System.out.println("DIFF1_SCHEMA");
        System.out.println("MESH_LENGTH : "+this.n+" ; MESH :" +this.mesh.toString());

        System.out.println("\n A ="+this.A.toString()+" \n\n  X = "+this.X.toString()+"\n\n B = "+this.B.toString());



    }


    /**
     *
     * @return AX-B
     */
    public IVector schema_diff(){

        this.A=new BaseMatrice(this.A.getNRows(),this.A.getNCols());



        IVector diff=this.getA().prod(this.X).diff(this.getB());
        return diff;
    }













}



