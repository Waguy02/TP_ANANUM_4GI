package auto_tester.interfaces;

import java.util.List;

/*****
 * Interfaces des normes :
 * Les normes prennent en paramètres deux vecteur et retourne un nombre
 */

public interface INorm {


    /***
     *
     *
     * @param number_1
     * @param number_2
     * @return
     */
    public Double run(List<Double> number_1, List<Double> number_2);

}
