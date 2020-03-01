/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package auto_tester.base_functions;

import auto_tester.GlobalConfig;
import auto_tester.interfaces.IBaseFunction;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Tedonze
 */
public class Linear_solver implements IBaseFunction {

    @Override
    public List<Double> runBase(List<Double> params) {
        ArrayList<Double> result = new ArrayList<>();
        if(Math.abs(params.get(0))<GlobalConfig.DEFAULT_TOLERANCE){
        
           if(Math.abs(params.get(1))<GlobalConfig.DEFAULT_TOLERANCE){
               return null;
                        }
           else{
               return result;
           }
           
        
        }
        else{
        
        double res= params.get(1)/params.get(0);
        result.add(res);
        }

        
        return result;
    }
    
}
