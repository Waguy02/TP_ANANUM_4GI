package diff_1D.interfaces;

public interface IVector {
    public double get(int ind);
    public void set(int ind, double value);

    public int getLength();
    public String toString();
}
