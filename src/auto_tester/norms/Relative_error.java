package auto_tester.norms;

import auto_tester.interfaces.INorm;

import java.util.List;

public class Relative_error implements INorm {
    @Override
    /*Double_1 est la valeur obtenue après par la fonction de test et number_2 le RA*/
    public Double run(List<Double> number_1, List<Double> number_2) {

        //Fonction de calcul de l'érreur relative entre deux vecteurs

        double result=0 ;
        double divisor=0 ;


        for (int i=0; i<number_1.size();i++) {

            if(number_2.get(i)!= 0) {

                result =  result +Math.pow((number_1.get(i)-number_2.get(i)),2);
                divisor  += Math.pow(number_2.get(i),2);

            }

        }
    Double norm=Math.sqrt(result/divisor);
            //System.out.println("Calcul de la norme: "+norm);
        return(norm);

    }
}
