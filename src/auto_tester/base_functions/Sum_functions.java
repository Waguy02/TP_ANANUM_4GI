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
public class Sum_functions implements IBaseFunction{

    @Override
    public List<Double> runBase(List<Double> params) {
        ArrayList<Double> result = new ArrayList<>();
        result.add(params.get(0)+params.get(1));// j'ai du caster en double
        return result;

    }
    
}
