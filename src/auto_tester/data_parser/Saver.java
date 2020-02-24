package auto_tester.data_parser;

import auto_tester.GlobalConfig;
import auto_tester.models.GlobalTest;
import auto_tester.models.SingleTest;
import org.apache.poi.ss.SpreadsheetVersion;
import org.apache.poi.ss.formula.udf.UDFFinder;
import org.apache.poi.ss.usermodel.*;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Iterator;
import java.util.List;

public class Saver {

    public static void save(GlobalTest globalTest){

        String path=GlobalConfig.TEST_OUTPUT_FOLDER+"\\"+"RESULTATS-"+globalTest.getTest_dataset_name();

        Workbook workbook=null;
        try {
            workbook = WorkbookFactory.create(true);


        }
        catch(Exception e){
            e.printStackTrace();
            System.out.println(e.getMessage());

        }


        Sheet sheet=workbook.createSheet();

        System.out.println("ETAT DE LA FEUILLE");
        System.out.println(sheet);
        Row first_row=sheet.createRow(0);
        first_row.createCell(0);
        first_row.createCell(1);
        first_row.createCell(2);
        first_row.getCell(0).setCellValue("Scénario");
        first_row.getCell(1).setCellValue("Donnée d'éntrée");
        first_row.getCell(2).setCellValue("Résultat du test");


        Integer counter=1;


        for(SingleTest singleTest:globalTest.getTests()){
                sheet.createRow(counter);
            fill_row(sheet.getRow(counter),singleTest);
            counter++;

        }



try{

    FileOutputStream fos=new FileOutputStream(path);
    workbook.write(fos);
}
catch(Exception e){
e.printStackTrace();

}





    }


    public static void fill_row(Row row, SingleTest singleTest){

        row.createCell(0);
        row.createCell(1);
        row.createCell(2);
        row.getCell(0).setCellValue(singleTest.getTest_data().getScenario());
        row.getCell(1).setCellValue(Tools.stringifyOutputData(singleTest.getTest_data().getInput_data()));
        row.getCell(2).setCellValue(singleTest.getResult());
    }






}
