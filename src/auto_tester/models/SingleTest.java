package auto_tester.models;

public class SingleTest {
        public TestData getTest_data() {
                return test_data;
        }

        public void setTest_data(TestData test_data) {
                this.test_data = test_data;
        }

        public boolean getResult() {
                return result;
        }

        public void setResult(boolean result) {
                this.result = result;
        }

        private TestData test_data;
        private boolean result;

        public SingleTest(TestData test_data) {
                this.test_data = test_data;
        }


        public void run(){

                try {
                        this.result = this.test_data.runTest();
                }
                catch(Exception e){

                        System.out.println(e.getMessage());
                        e.printStackTrace();
                }
        }
}


