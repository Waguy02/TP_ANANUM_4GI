package diff_1D.interfaces;

/**
 *
 * Interface pour les vecteurs
 */
public interface IVector {
    public double get(int ind);
    public void set(int ind, double value);

    public int getLength();
    public String toString();




    public IVector diff(IVector X_2);


}
