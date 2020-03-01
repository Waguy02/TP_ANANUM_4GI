package auto_tester.data_generation;

import java.util.ArrayList;
import java.util.List;

/**
 * Create generator instances for various equations and create the test data required.
 *
 * @author suuynyuy
 * @version 1.0
 */
public class GenerateData {


    public static void main(String[] args) throws Exception{
        generateQuadraticData();
        generateLinearData();
        generateInequalityData();
        generateSquareRootData();
        generateSumData();
    }

    public static void generateQuadraticData() throws  Exception{
        Generator generator = new Generator(EquationType.QUADRATIC,"Square_two_test","Square_two_solver");
        List<Integer> vars = new ArrayList<>();
        vars.add(7);
        vars.add(7);
        vars.add(7);
        generator.generateScenarios(vars);
        generator.createScenarios();

        Double a,b,c;
        for(Scenario scen:generator.getScens()){

            a=scen.getDe().get(1);
            b=scen.getDe().get(2);
            c=scen.getDe().get(3);

            if(Math.abs(a)<scen.getTol()&&Math.abs(b)<scen.getTol()&&Math.abs(c)<scen.getTol()){

                scen.setRa(null);
                scen.setN("Null_error");
            }
            else if(Math.abs(a)<scen.getTol()&&Math.abs(b)<scen.getTol()&&Math.abs(c)>scen.getTol()){scen.setN("Empty_error"); }

            else if(Math.abs(b*b-4*a*c)<scen.getTol()){scen.setN("Empty_error");}

            else {scen.getRa().add(-scen.getDe().get(3));



                if(Math.abs(c)<scen.getTol()){
                    scen.setN("Absolute_error");

                }
                else{

                    scen.setN("Relative_error");
                }



            }

        }



        generator.saveScenarios();
    }

    public static void generateLinearData() throws  Exception {
        Generator generator = new Generator(EquationType.LINEAR,"linear_test","linear_solver");
        List<Integer> vars = new ArrayList<>();
        vars.add(7);
        vars.add(7);
        generator.generateScenarios(vars);
        generator.createScenarios();
        generator.saveScenarios();
    }

    public static void generateSquareRootData() throws Exception {
        Generator generator = new Generator(EquationType.SQUARE_ROOT,"Square_root_test","Square_root_solver");
        List<Integer> vars = new ArrayList<>();
        vars.add(7);
        generator.generateScenarios(vars);
        generator.createScenarios();
        generator.saveScenarios();
    }

    public static void generateSumData() throws  Exception{
        Generator generator = new Generator(EquationType.SUM,"Sum_test","Sum_solver");
        List<Integer> vars = new ArrayList<>();
        vars.add(7);
        generator.generateScenarios(vars);
        generator.createScenarios();
        generator.saveScenarios();
    }

    public static void generateInequalityData() throws  Exception{
        Generator generator = new Generator(EquationType.INEQUALITY,"Inequality_test","Inequality_solver");
        List<Integer> vars = new ArrayList<>();
        vars.add(7);
        generator.generateScenarios(vars);
        generator.createScenarios();
        generator.saveScenarios();
    }
}
