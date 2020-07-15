package Finite_diff_and_vol.interfaces;


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
    public IBaseFunction1D interpolate(IMatrice points);

    public IVector getCoefs();
}
