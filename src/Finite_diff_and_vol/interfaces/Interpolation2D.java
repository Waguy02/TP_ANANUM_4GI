package Finite_diff_and_vol.interfaces;

public interface Interpolation2D {


    /**
     *
     * Fonction d'interpolation
     * @param points les couples(x1_i,X2i,yi): Une matrice (3*n)
     * @return Une fonction 1D correpondant à la fonction d'interpolation
     */
    public IBaseFunction2D interpolate(IMatrice points);
}
