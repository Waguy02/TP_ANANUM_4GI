package finite_diff.interfaces;


/***
 * Interface de représenation graphique des fonctions
 */
public interface IGraphic {

    public void show(BaseFunction1D function, double[] bounds);
            //Function is the function to visualize : For example ; f(x)=x²+2x+7 ;
            // Bounds is an array of [min,max] which determines the min and the max  values of x on the figure
}
