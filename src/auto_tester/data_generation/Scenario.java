package auto_tester.data_generation;

import java.util.HashMap;

/**
 * This class represents a single test case. It contains all the data needed for each test
 *
 * @author suuynyuy
 * @version 1.0
 */
public class Scenario {
    private final String sc;//Name of scenario
    private final HashMap<Integer, Double> de;//Test data
    private String f;//Tested function
    private String g;//Test Function
    private String n;//Error function
    private Double tol;//Tolerance value
    private Double ra=1d;//Expected value

    public Scenario(Integer id){
        sc = "scenario"+id.toString();
        de = new HashMap<>();
    }
    public String getSc() {
        return sc;
    }

    public HashMap<Integer, Double> getDe() {
        return de;
    }

    public void addValue(int key, double value){
        de.put(key, value);
    }

    /**
     * Create and return a string of test data in the specified format.
     *
     * @return
     */
    public String getValueString(){
        String value = "";
        for(Double item: de.values()){
            if(!value.isEmpty()){
                value += ";"+item.toString();
            }else{
                value = item.toString();
            }
        }

        return value;
    }

    public String getF() {
        return f;
    }

    public void setF(String f) {
        this.f = f;
    }

    public String getG() {
        return g;
    }

    public void setG(String g) {
        this.g = g;
    }

    public String getN() {
        return n;
    }

    public void setN(String n) {
        this.n = n;
    }

    public Double getTol() {
        return tol;
    }

    public void setTol(Double tol) {
        this.tol = tol;
    }

    public Double getRa() {
        return ra;
    }

    public void setRa(Double ra) {
        this.ra = ra;
    }

    @Override
    public String toString() {
        return "Scenario{" +
                "sc='" + sc + '\'' +
                ", f='" + f + '\'' +
                ", g='" + g + '\'' +
                ", de=" + this.getValueString() +
                ", n='" + n + '\'' +
                ", tol=" + tol +
                ", ra=" + ra +
                '}';
    }
}
