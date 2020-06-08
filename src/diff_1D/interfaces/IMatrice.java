package diff_1D.interfaces;


/**
 *
 * Interface de réprésentation des matrices
 */
public interface IMatrice {

public double get(int row_ind, int col_ind);
public void set(int row_ind, int col_ind,double value);

public String toString();
}
