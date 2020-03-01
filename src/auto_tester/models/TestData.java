

package auto_tester.models;

import auto_tester.interfaces.IBaseFunction;
import auto_tester.interfaces.INorm;
import auto_tester.interfaces.ITestFunction;
import javafx.scene.control.Separator;

import java.lang.reflect.Method;
import java.util.List;

public class TestData {

        public static String SEPARATOR_POINT=".";


    private String scenario;
    private List<Number> input_data;
    private String base_function_id;
    private IBaseFunction base_function;
    private List<Number> expect_result;
    private String test_function_id;
    private ITestFunction test_function;
    private Number tolerance;
    private String norm_function_id;
    private INorm norm_function;

    public String getScenario() {
        return scenario;
    }

    public void setScenario(String scenario) {
        this.scenario = scenario;
    }

    public List<Number> getInput_data() {
        return input_data;
    }

    public void setInput_data(List<Number> input_data) {
        this.input_data = input_data;
    }

    public String getBase_function_id() {
        return base_function_id;
    }

    public void setBase_function_id(String base_function_id) {
        this.base_function_id = base_function_id;
    }

    public IBaseFunction getBase_function() {
        return base_function;
    }

    public void setBase_function(IBaseFunction base_function) {
        this.base_function = base_function;
    }

    public List<Number> getExpect_result() {
        return expect_result;
    }

    public void setExpect_result(List<Number> expect_result) {
        this.expect_result = expect_result;
    }

    public String getTest_function_id() {
        return test_function_id;
    }

    public void setTest_function_id(String test_function_id) {
        this.test_function_id = test_function_id;
    }

    public ITestFunction getTest_function() {
        return test_function;
    }

    public void setTest_function(ITestFunction test_function) {
        this.test_function = test_function;
    }

    public Number getTolerance() {
        return tolerance;
    }

    public void setTolerance(Number tolerance) {
        this.tolerance = tolerance;
    }

    public String getNorm_function_id() {
        return norm_function_id;
    }

    public void setNorm_function_id(String norm_function_id) {
        this.norm_function_id = norm_function_id;
    }

    public INorm getNorm_function() {
        return norm_function;
    }

    public void setNorm_function(INorm norm_function) {
        this.norm_function = norm_function;
    }

    public TestData(){


    }
    public TestData(String scenario, List<Number> input_data, String base_function_id, String test_function_id,List<Number> expect_result) {
        this.scenario = scenario;
        this.input_data = input_data;
        this.base_function_id = base_function_id;
        this.test_function_id = test_function_id;
        this.expect_result = expect_result;
    }


        public void parseBaseFunction() throws Exception{

        String base_functions_path="auto_tester.base_functions"+SEPARATOR_POINT+this.base_function_id;

        Class arg[]={Number.class};
        Class baseFunctionClass=Class.forName(base_functions_path);
        this.base_function=(IBaseFunction)baseFunctionClass.newInstance();

        }

        public void parseTestFunction()throws Exception {

            String test_functions_path="auto_tester.test_functions"+SEPARATOR_POINT+this.test_function_id;
            Class arg[]={Number.class};
            Class testFunctionClass=Class.forName(test_functions_path);
            this.test_function=(ITestFunction)testFunctionClass.newInstance() ;

    }


        public void parseNorm() throws Exception {


            String norm_functions_path="auto_tester.norms"+SEPARATOR_POINT+this.norm_function_id;
            Class arg[]={Number.class};
            Class normFunctionClass=Class.forName(norm_functions_path);
            this.norm_function=(INorm)normFunctionClass.newInstance();

        }







        public boolean runTest() throws Exception {
                List<Number> base_value=this.base_function.runBase(this.input_data);

                List<Number> test_value=this.test_function.runTest(base_value);


                Number norm_value=this.norm_function.run(test_value,expect_result);



                return (norm_value.longValue()<this.tolerance.longValue());


        }


        public void parse() throws Exception{


        this.parseBaseFunction();
        this.parseNorm();
        this.parseTestFunction();
    }











}









