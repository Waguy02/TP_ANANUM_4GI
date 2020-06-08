package finite_diff.interfaces;


/**
 *
 *
 * La classe des fonctions d'interpolation en dimension 1
 */
public interface Interpolation1D {


    /**
     *
     * Fonction d'interpolation
     * @param points les couples(x_i,yi): Une matrice (2*n)
     * @return Une fonction 1D correpondant à la fcontion d'interpolation
     */
    public BaseFunction1D interpolate(IMatrice points);
}
