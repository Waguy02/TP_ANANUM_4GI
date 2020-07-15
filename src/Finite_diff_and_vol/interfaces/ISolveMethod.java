package Finite_diff_and_vol.interfaces;


/***
 *
 *
 * Interface pour les méthodes de résolution des équations AX=B
 *
 *
 */
public interface ISolveMethod  {


    /**
     *
     * @param A  La matrice carrée A du système
     * @param B  Le vecteur de la partie droite de l'équation
     * @param solve_parameters Les paramètres de la méthode (Exemple : Le nombre d'itérations pour la méthode de gauss_seidel ou la tolérance ,... )
     * @return
     */
    public IVector solve(IMatrice A,IVector B,Double[] solve_parameters);



}
