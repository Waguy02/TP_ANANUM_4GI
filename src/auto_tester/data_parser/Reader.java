package auto_tester.data_parser;

import auto_tester.GlobalConfig;
import auto_tester.models.GlobalTest;
import auto_tester.models.SingleTest;
import auto_tester.models.TestData;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

import java.io.File;
import java.io.FileInputStream;

public class Reader {





    public static GlobalTest read(String file_name){

        String path=GlobalConfig.TEST_DATASET_FOLDER+"\\"+file_name;
        final File file = new File(path);
        Workbook workbook = null;
        GlobalTest result=new GlobalTest();
        result.setTest_dataset_name(file_name);
        try{
            workbook=WorkbookFactory.create(new FileInputStream(path));


        }
        catch(Exception e){
            e.printStackTrace();;
            System.out.println(e.getMessage());



        }


        Sheet sheet=workbook.getSheetAt(0);

        int nbRow =sheet.getLastRowNum();



        Integer start=1;
        for(int i=start;i<nbRow;i++) {
            result.getTests().add(new SingleTest(parseRow(sheet.getRow(i))));

        }




return result;
    }


    public static TestData parseRow(Row row){
        TestData result=new TestData();
        result.setScenario(row.getCell(0).getStringCellValue());
        result.setInput_data(Tools.parseInputData(row.getCell(  1).getStringCellValue()));
        result.setBase_function_id(row.getCell(2).getStringCellValue());
        result.setTest_function_id(row.getCell(3).getStringCellValue());
        result.setNorm_function_id(row.getCell(4).getStringCellValue());
        result.setTolerance(row.getCell(5).getNumericCellValue());

        if(row.getCell(6).getStringCellValue().trim().equals("null")){

        }
        else {
            result.setExpect_result(Double.valueOf(row.getCell(6).getStringCellValue()));
        }
        try {
            result.parse();
        }
        catch (Exception e){
            e.printStackTrace();
            System.out.println(e.getMessage());
        }
        return result;

    }








}
