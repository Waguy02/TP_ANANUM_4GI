package diff_1D.interpolation.lagrange;

import java.util.Scanner;

public class Lagrange {
  /* données
      ---le degré n du polynôme
      ---n+1 points  : x0, x1, … , xn
      ---les n+1 valeurs de ces points par la fonction f : f(x0), f(x1), …., f(xn)
      ---le point a en lequel on souhaite évaluer la fonction f

    Résultat cherché
      ***la valeur f(a) en utilisant une interpolation de lagrange.
*/
  public static void main(String[] args) {

    int n;// degré du polynôme
    int i, j;
    double a; 
    double x[]; //tableau des xi
    double f[]; //tableau des des f(xi)
    double sum = 0.0;
    double mult;
    Scanner input = new Scanner(System.in);
    System.out.println("Veuillez entrer le nombre de points : ");
    n = input.nextInt();
    x = new double[n];
    f = new double[n];
    System.out.println("Veuiller entrer la valeur de x a evaluer : ");
    a = input.nextDouble();

    for (i = 0; i < n; i++) {

        System.out.println("veuillez saisir la valeur du point x" +i+ " :" );
        x[i] = input.nextDouble();
        System.out.println("veuillez saisir la valeur f(x"+i+") de la fonction en ce point : ");
        f[i] = input.nextDouble();
    }

    for (i = 0; i <= n - 1; i++) {
        mult = 1;
        for (j = 0; j <= n - 1; j++) {

            if (j != i) {
                mult *= (a - x[j]) / (x[i] - x[j]);

            }
            sum += mult * f[i];
        }

    }
    System.out.println("La valeur estimee de fmen ce point est : " + sum);

}
}