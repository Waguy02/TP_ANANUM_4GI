package auto_tester;


import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

public class Tools {

    public static String VALUE_SEPARATOR = ";";


    public static ArrayList<Double> parseInputData(String data) {


         if(data.trim().equals(NULL_STR))return null;
        ArrayList<Double> result = new ArrayList<>();



        for (String value : data.split(VALUE_SEPARATOR)) {

            if (value.trim() == "") continue;
            result.add(Double.valueOf(value.trim()));

        }

        return result;
    }


    public static String NULL_STR="null";
    public static String stringifyOutputData(List<Double> list) {

        String result = "";

        if(list==null) return  NULL_STR;
        for (Double number : list) {

            result = result + number.toString() + ";";
        }

        return result;


    }


    public static final String XLSX_EXTENSION = "xlsx";

    public static String parseFilename(String filename) {
        String[] splitted=filename.split("\\.");
        if (splitted.length == 1) return filename.concat(".").concat(XLSX_EXTENSION);
        else {

            if (!splitted[splitted.length - 1].equals(XLSX_EXTENSION)) { System.out.println(XLSX_EXTENSION);
                System.out.println(splitted[splitted.length-1]);
                return filename.concat(".").concat(XLSX_EXTENSION);
            }

            return filename;

        }
    }

}
