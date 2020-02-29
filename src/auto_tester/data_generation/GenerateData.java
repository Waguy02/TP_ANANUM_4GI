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

    private static void generateQuadraticData() throws  Exception{
        Generator generator = new Generator(EquationType.QUADRATIC,"Square_two_test","Square_two_solver");
        List<Integer> vars = new ArrayList<>();
        vars.add(7);
        vars.add(7);
        vars.add(7);
        generator.generateScenarios(vars);
        generator.createScenarios();
        generator.saveScenarios();
    }

    private static void generateLinearData() throws  Exception {
        Generator generator = new Generator(EquationType.LINEAR,"linear_test","linear_solver");
        List<Integer> vars = new ArrayList<>();
        vars.add(7);
        vars.add(7);
        generator.generateScenarios(vars);
        generator.createScenarios();
        generator.saveScenarios();
    }

    private static void generateSquareRootData() throws Exception {
        Generator generator = new Generator(EquationType.SQUARE_ROOT,"Square_root_test","Square_root_solver");
        List<Integer> vars = new ArrayList<>();
        vars.add(7);
        generator.generateScenarios(vars);
        generator.createScenarios();
        generator.saveScenarios();
    }

    private static void generateSumData() throws  Exception{
        Generator generator = new Generator(EquationType.SUM,"Sum_test","Sum_solver");
        List<Integer> vars = new ArrayList<>();
        vars.add(7);
        generator.generateScenarios(vars);
        generator.createScenarios();
        generator.saveScenarios();
    }

    private static void generateInequalityData() throws  Exception{
        Generator generator = new Generator(EquationType.INEQUALITY,"Inequality_test","Inequality_solver");
        List<Integer> vars = new ArrayList<>();
        vars.add(7);
        generator.generateScenarios(vars);
        generator.createScenarios();
        generator.saveScenarios();
    }
}
