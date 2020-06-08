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
public class Check_positive implements IBaseFunction{

    @Override
    public List<Double> runBase(List<Double> params) {
                ArrayList<Double> result = new ArrayList<>();
                if(params.get(0)>=0)
                { result.add(1.0);
                }
                else{
                result.add(0.0);
                }
                return result;
                
                
    }
    
}
