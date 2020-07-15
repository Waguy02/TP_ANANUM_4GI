package Finite_diff_and_vol.interfaces;

public interface IFiniteVol {

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
