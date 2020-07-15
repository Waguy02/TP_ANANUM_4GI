package Finite_diff_and_vol.graphic.graphics;





import Finite_diff_and_vol.graphic.Visualiser1D;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class GraphicDisplay extends Application {
    private final  double graphSize = 500.0;
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        Visualiser1D visualiser1D = new Visualiser1D();
        /*visualiser1D.show((new Base1DFunction() {
            @Override
            public double run(double x) {
                return Math.ceil(x);
            }
        }), new double[]{-1.0, 1.0});
*/
        StackPane pane = new StackPane();
        //pane.getChildren().add(visualiser1D);

        Scene scene = new Scene(pane, this.graphSize+100, this.graphSize+100);

        primaryStage.setScene(scene);
        primaryStage.setTitle("GRAPH");
        primaryStage.show();
    }
}
