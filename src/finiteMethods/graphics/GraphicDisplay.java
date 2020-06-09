package finiteMethods.graphics;

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
        Graph graph = new Graph(this.graphSize,-1.0,1.0);
        //graph.plotPointSegments(Generator.generateSquares(0,1,1000));
        graph.plotPointSegments(Generator.generateInverseSquares(-1,1,1000));

        StackPane pane = new StackPane();
        pane.getChildren().add(graph);

        Scene scene = new Scene(pane, this.graphSize+100, this.graphSize+100);

        primaryStage.setScene(scene);
        primaryStage.setTitle("GRAPH");
        primaryStage.show();
    }
}
