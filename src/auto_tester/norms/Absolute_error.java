package auto_tester.norms;

import auto_tester.interfaces.INorm;

import java.util.List;

public class Absolute_error implements INorm {
    @Override
    /*Number_1 est la valeur obtenue après par la fonction de test et number_2 le RA*/
    public Number run(List<Number> number_1, List<Number> number_2) {
        double result=0 ;
        for (int i=0; i<number_1.size();i++) {

            if(number_2.get(i).doubleValue()!= 0) {

                result =  result +Math.pow((number_1.get(i).doubleValue()-number_2.get(i).doubleValue()),2);

            }

        }
        return Math.sqrt(result);

    }

}
