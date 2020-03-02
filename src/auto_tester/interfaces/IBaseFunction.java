package auto_tester.interfaces;

import java.util.List;

/***
 * IBaseFunction matérialise une function à tester
 * la méthode runBase permet d'exécuter cette fonction
 */



public interface  IBaseFunction  {



    /***
     *
     *
     *
     * @param params : la liste de nombres sur laquelle s'effectue le test
     * @return une autre liste de nombre( certaines fonctions peuvent renvoyer plusieurs valeurs
     */
    public List<Double> runBase(List<Double> params);

}

/***
 *
 * Spécification des fonctions à tester :
 *
 *
 * 1. Solveur d'équation de degré 2 :
 *
 *       paramètres  :
 *       Une liste contenant dans l'ordre  les valeurs des paramètres a , b et c
 *
 *
 *       Résultats :
 *          1. Si l'équation admet deux solutions : une liste contenant ces deux solutions
 *          2. Si l'équation admet une unique solution : une liste ne contenant que cette solution
 *          3. Si l'équation n'admet pas de solution :Une liste vide
 *          4. Si l'équation admet une infinité de solution  : null
 *
 *
 *
 *
 *  2. Solveur d'équation de degré 1 :
 *
 *          paramètres  :
 *          Une liste contenant les deux valeurs a et b
 *
 *
 *          Résultats :
 *          1. Si l'équation admet une solution : une liste ne contenant que cette équation
 *          2. Si l'équation n'admet pas de solution :une liste vide
 *          3. Sl l'équation admet une infinité de solutions : null
 *
 *
 *  3. Calucl de racine carrée :
 *
 *          Paramètres :
 *          Une liste ne contenant que le paramètre dont on veut calculer la racine carrée
 *
 *          Résultats :
 *          1. S'il n y a pas de résultat : null  (par exemple , un nombre négatif
 *          2. Si la racine est calculable : une liste ne contenant que cette racine carrée
 *
 *
 *  4. Calcul de la somme des deux nombres :
 *
 *           Paramètres :
 *           Une liste contenant les deux nombres à additionner
 *
 *           Résultats :
 *
 *           1. Si la somme est réalisable : (une liste contenant le résultat de cette somme )
 *           2. Si la somme n'est pas faisable : null
 *
 *
 *
 * 5 . Résolution de l'équatoin x>0
 *
 *          Paramètres :
 *          Une liste comtenant le nombre x à évaluer
 *
 *          Résultat :
 *          UNe liste contenant une valuer : 1 si le nombre est supérieur à 0 ,
 *          0 sinon
 *
 */

