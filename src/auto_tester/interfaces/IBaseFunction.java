package auto_tester.interfaces;

import java.util.List;

/***
 * IBaseFunction matérialise une function à tester
 * la méthode runBase permet d'exécuter cette fonction
 */
public interface IBaseFunction  {



    /***
     *
     *
     *
     * @param params : la liste de nombres sur laquelle s'effectue le test
     * @return une autre liste de nombre( certaines fonctions peuvent renvoyer plusieurs valeurs
     */
    public List<Number> runBase(List<Number> params);

}
