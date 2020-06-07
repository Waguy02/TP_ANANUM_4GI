package diff_1D.test_functions;

import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;

import javax.print.attribute.standard.MediaSize.Other;

import diff_1D.base_functions.ITestFunction;

public class squarepolynome_test implements ITestFunction {
    double a=params.get(0);
    double b=params.get(1);
    double c=params.get(2);
    double u_0=params.get(3);
    double u_1=params.get(4);
    public double primitive(double x){
       double d=u_1-u_0-(1/12)*a-(1/6)*b-(1/2)*c;
       double e=u_0;
        return((1/12)*a*Math.pow(x,4)+(1/6)*b*Math.pow(x,3)+(1/2)*a*Math.pow(x,2)+d*x+e);// double prmitive avec les conditions initiales

    }

    @Override
    public List<Double> runTest(List<Double> outputs) {
        ArrayList<Double> result=new ArrayList<>();
        ListIterator ilterator =outputs.listIterator();
        while(ilterator.hasNext())
        {
            result.add(primitive(outputs.get(ilterator.nextIndex())));// resultat de la fonction test
        }
        
              
      
        
        
        return result;
    }

}