package finite_diff.interfaces;


/**
 *
 * Interface de réprésentation des matrices
 */
public interface IMatrice {

public double get(int row_ind, int col_ind);
public void set(int row_ind, int col_ind,double value);

    /**
     *
     * @return Le nombre de colonnes
     */
    public int getNCols();

    /***
     *
     * @return Le nombre de lignes
     */
    public int getNRows();


public String toString();





public IMatrice prod(IMatrice B);

public IVector prod(IVector X);

}
