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
public class Square_two_solver implements IBaseFunction{

    @Override
    @SuppressWarnings("empty-statement")
    public List<Double> runBase(List<Double> params) {

        ArrayList<Double> result = new ArrayList<>();
           double a=params.get(0);
            double b=params.get(1);
             double c=params.get(2);

             System.out.println("Paramètres:  (a,b,c) = "+params);
           
           if(Math.abs(a)<GlobalConfig.DEFAULT_TOLERANCE){
           
                      Linear_solver linear=new Linear_solver();
                      ArrayList<Double> newparams = new ArrayList<>();
                      newparams.add(params.get(1));
                      newparams.add(params.get(2));
                      result=(ArrayList<Double>) solveDeg1(newparams);
           
           
           }
           
           else{
               double dis;
               dis=b*b-4*a*c;
               System.out.println("DISCRIMINANT : "+dis );


                 if(dis<0){}

                 else {
                     Double racine = Math.sqrt(dis);
                     if (racine == 0) {

                         result.add(-b / (2 * a));

                     } else

                     {
                         double racinevalue = racine;
                         result.add((-b - racinevalue) / (2 * a));
                         result.add((-b + racinevalue) / (2 * a));

                     }


                 }}

           System.out.println("RESULTAT DE LA FONCTION BASE :" + result);
       return result;
    }


    private List<Double> solveDeg1(List<Double> params) {
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


