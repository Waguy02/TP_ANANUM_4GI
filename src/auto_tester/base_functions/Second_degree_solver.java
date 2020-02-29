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
public class Second_degree_solver implements IBaseFunction{

    @Override
    @SuppressWarnings("empty-statement")
    public List<Number> runBase(List<Number> params) {
           ArrayList<Number> result = new ArrayList<>();
           double a=params.get(0).doubleValue();
            double b=params.get(0).doubleValue();
             double c=params.get(0).doubleValue();
           
           if(params.get(0).doubleValue()==0){
           
                      Linear_solver linear=new Linear_solver();
                      ArrayList<Number> newparams = new ArrayList<>();
                      newparams.add(params.get(1));
                      newparams.add(params.get(2));
                      result=(ArrayList<Number>) linear.runBase(newparams);
           
           
           }
           
           else{
               double dis;
                dis=b*b-4*a*c;
                Square_two_solver square=new Square_two_solver();
                 ArrayList<Number> newparams = new ArrayList<>();
                 newparams.add(dis);
                 List<Number> racine=square.runBase(newparams);
                 if(racine.isEmpty()){
                 
                 return null;
                 }
                 else if(racine.get(0).doubleValue()==0){
                 
                 result.add(b/(2*a));
                 
                 }
                 else
                 
                 { double racinevalue=racine.get(0).doubleValue();
                       result.add((b-racinevalue)/(2*a));
                       result.add((b+racinevalue)/(2*a));
                       
                 }
                     
           
           
        
           
           }
       return result;
    }
    
}
