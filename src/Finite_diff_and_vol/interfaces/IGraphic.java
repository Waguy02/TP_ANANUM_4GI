package Finite_diff_and_vol.interfaces;


/***
 * Interface de représenation graphique des fonctions
 */
public interface IGraphic {

    public void show1D(IBaseFunction1D function, double[] bounds);
            //Function is the function to visualize : For example ; f(x)=x²+2x+7 ;
            // Bounds is an array of [min,max] which determines the min and the max  values of x on the figure

    public void show2D(IBaseFunction2D function, double[] bounds);
    //Function is the function to visualize : For example ; f(x)=x²+2x+7 ;
    // Bounds is an array of [min,max] which determines the min and the max  values of x on the figure
}
