package diff_1D.interfaces;

public interface IGraphic {

    public void show(Base1DFunction function,double[] bounds);
            //Function is the function to visualize : For example ; f(x)=x²+2x+7 ;
            // Bounds is an array of [min,max] which determines the min and the max  values of x on the figure
}
