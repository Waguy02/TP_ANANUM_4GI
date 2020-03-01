package auto_tester.data_generation;

import auto_tester.GlobalConfig;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/**
 * This class effectively generates the test data with the following procedure:
 * 1. It calls the command line tool Jenny and collects the output as a function of the equation type
 *    with which it was instantiated.
 * 2. This output is parsed and used to create the various cases.
 * 3. Each numeric identifier given by Jenny is considered to identify a variable while
 *    the character identifiers identify an associated scenario.
 * 4. Each of these scenarios is computed and objects created to identify them. These objects
 *    are associated with a particular test function and tested function with which the generator
 *    was instantiated.
 * 5. The values of the scenarios is then written to an excel sheet which is named with the type of equation.
 *
 * @author suuynyuy
 * @version 1.0
 */
public class Generator {
    private final String testFunction;
    private final String testedFunction;
    private double tol = 1E-10; //Tolerance value to be used for each of the scenarios
    private String norm = "Relative_error";
    private List<String> rawCases;
    private List<Scenario> scens;
    private final EquationType equationType;

    public Generator(EquationType equationType,String testFunction, String testedFunction){
        this.equationType = equationType;
        this.testFunction = testFunction;
        this.testedFunction = testedFunction;
    }

    public Generator(EquationType equationType,String testFunction, String testedFunction, double tol){
        this(equationType, testFunction, testedFunction);
        this.tol = tol;
    }

    public Generator(EquationType equationType, String testFunction, String testedFunction, double tol, String norm){
        this(equationType, testFunction, testedFunction, tol);
        this.norm = norm;
    }

    /**
     * Generate scenario objects from the computed scenarios
     * @return List
     */
    public List<Scenario> createScenarios(){
        scens = new ArrayList<>();

        int i =1;
        for (String scene: rawCases) {
            Scenario item = new Scenario(i++);
            item.setF(this.testedFunction);
            item.setG(this.testFunction);
            item.setN(this.norm);
            item.setTol(this.tol);

            String[] vars = scene.split(" ");
            int j=1;
            for(String value: vars){
                item.addValue(j++, ValueBag.getValue(value.substring(1),equationType));
            }
            scens.add(item);
        }
        return scens;
    }

    /**
     * Compute scenarios as a function of the dimensions given in the list object
     *
     * @param dims
     * @throws Exception
     */
    public void generateScenarios(List<Integer> dims) throws  Exception{
        rawCases = new ArrayList<>();

        /**
         * Equations made up of only one variable
         */
        if(dims.size()<2){
            rawCases.add("0a");
            rawCases.add("0b");
            rawCases.add("0c");
            rawCases.add("0d");
            rawCases.add("0e");
            rawCases.add("0f");
            rawCases.add("0g");
            return;
        }

        /**
         * Create string with which to make system call.
         */
        StringBuilder command = new StringBuilder("./jenny  ");

        for (Integer dim : dims) {
            command.append(dim).append(" ");
        }

        command.append("|sort");

        Runtime runtime = Runtime.getRuntime();
        Process process = runtime.exec(command.toString());
        BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()));

        //Process output
        String line;
        while((line=reader.readLine())!=null){
            line = line.trim();
            rawCases.add(line);
        }
    }

    /**
     * Write the generated data to an excel sheet.
     *
     * @throws IOException
     */
    public void saveScenarios() throws IOException {
        Workbook book = WorkbookFactory.create(true);
        Sheet sheet = book.createSheet();

        Row headerRow = sheet.createRow(0);
        headerRow.createCell(0).setCellValue("SC");
        headerRow.createCell(1).setCellValue("DE");
        headerRow.createCell(2).setCellValue("F");
        headerRow.createCell(3).setCellValue("G");
        headerRow.createCell(4).setCellValue("N");
        headerRow.createCell(5).setCellValue("TOL");
        headerRow.createCell(6).setCellValue("RA");

        int i=1;
        for(Scenario scene: scens){
            Row valueRow = sheet.createRow(i++);
            valueRow.createCell(0).setCellValue(scene.getSc());
            valueRow.createCell(1).setCellValue(scene.getValueString());
            valueRow.createCell(2).setCellValue(scene.getF());
            valueRow.createCell(3).setCellValue(scene.getG());
            valueRow.createCell(4).setCellValue(scene.getN());
            valueRow.createCell(5).setCellValue(scene.getTol());
            valueRow.createCell(6).setCellValue(scene.getRa());
        }

        String filename = GlobalConfig.TEST_DATASET_FOLDER+"\\"+equationType.toString()+".xlsx";
        FileOutputStream os = new FileOutputStream(new File(filename));
        book.write(os);
        os.close();

        System.out.println(filename+" saved!");
    }
}
