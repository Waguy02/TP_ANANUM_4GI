package auto_tester.interfaces;

import java.util.List;

/***
 *
 * Cette interface matérialise une fonction de test
 * La fonction runTest permet d'effectuer ce test
 *
 */
public interface ITestFunction {


    /***
     *
     * @param outputs : Un vecteur de nombre correspondant aux résultats de la fonction de test
     *                  Output est un vecteur pour prendre en compte les fonctions à  tester pouvant retourner plusieurs valeurs  (Exemple , une équation de second dégré)
     * @return Le résultat de la fonction de test comme vecteur
     *         Ce résultat est multidimensionnel lorsqu'elle la fonction  à tester retourne elle aussi un résultat multidimensionnel
     */
    public List<Number> runTest(List<Number> outputs);





}
