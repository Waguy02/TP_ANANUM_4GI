/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package auto_tester.base_functions;

import auto_tester.interfaces.IBaseFunction;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Tedonze
 */
public class Linear_solver implements IBaseFunction {

    @Override
    public List<Number> runBase(List<Number> params) {
                 ArrayList<Number> result = new ArrayList<>();
        if(params.get(0).doubleValue()==0){
        
           if(params.get(1).doubleValue()==0){
               return null;
                        }
           else{
               return result;
           }
           
        
        }
        else{
        
        double res= params.get(1).doubleValue()/params.get(0).doubleValue();
        result.add(res);
        }

        
        return result;
    }
    
}
