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
public class Sum_solver implements IBaseFunction{

    @Override
    public List<Double> runBase(List<Double> params) {
        ArrayList<Double> result = new ArrayList<>();
        Double x=params.get(0),y=params.get(1);

        if((x<=GlobalConfig.MIN_VALUE &&y<0)||(y<=GlobalConfig.MIN_VALUE&&x<0)||(x>=GlobalConfig.MAX_VALUE&&y>0)||(y>=GlobalConfig.MAX_VALUE&&x>0)){

            return null;
        }


        result.add(x+y);
        return result;

    }
    
}
