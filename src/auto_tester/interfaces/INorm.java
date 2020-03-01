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
    public Number run(List<Number> number_1, List<Number> number_2);

}
