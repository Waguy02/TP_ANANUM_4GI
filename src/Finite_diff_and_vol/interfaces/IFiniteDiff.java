package Finite_diff_and_vol.interfaces;

/**
 *
 * Interface pour les schémas aux différences finis 1D et 2D
 */
public interface IFiniteDiff {
    void solve(Double parameters[]);

    IMatrice makePoints();


    /***
     *
     * Initialisation de la maille
     */
    void init_mesh();

    void build_A();

    void build_B();

    void print_schema();

    void visualize(double inf, double max);
}
