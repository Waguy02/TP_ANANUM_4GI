package diff_1D.interfaces;


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
    public Base1DFunction interpolate(IMatrice points);
}
