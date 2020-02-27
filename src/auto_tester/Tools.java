package auto_tester.data_parser;


import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

public class Tools {

    public static String VALUE_SEPARATOR=";";


    public static ArrayList<Number> parseInputData(String data){


        ArrayList<Number> result=new ArrayList<>();

        for(String value :data.split(VALUE_SEPARATOR)){

            if (value.trim()=="") continue;
            result.add(Double.valueOf(value.trim()));

        }

        return  result;
    }


    public static String stringifyOutputData(List<Number > list){

        String result="";


        for(Number number:list){


            result=result+number.toString()+";";
        }

        return  result;



    }






}
