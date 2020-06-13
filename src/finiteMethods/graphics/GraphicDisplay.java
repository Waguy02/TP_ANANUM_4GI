package finiteMethods.graphics;

import diff_1D.interfaces.Base1DFunction;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class GraphicDisplay extends Application {
    private final  double graphSize = 500.0;
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        Graph graph = new Graph(this.graphSize);
        graph.show((new Base1DFunction() {
            @Override
            public double run(double x) {
                return Math.ceil(x);
            }
        }), new double[]{-1.0, 1.0});

        StackPane pane = new StackPane();
        pane.getChildren().add(graph);

        Scene scene = new Scene(pane, this.graphSize+100, this.graphSize+100);

        primaryStage.setScene(scene);
        primaryStage.setTitle("GRAPH");
        primaryStage.show();
    }
}
