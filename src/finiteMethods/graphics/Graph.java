package finiteMethods.graphics;

import finiteMethods.interfaces.Point;
import finiteMethods.interfaces.Segment;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Line;

import java.util.ArrayList;

public class Graph extends BorderPane {
    private static final double STEPS=10;
    private static  final double INNERSTEPS =10;
    private final Double side;
    private final Double stepLength;
    private final Double innerStepLength;
    private final Double scale;
    private final Pane graphPane;
    private final HBox mouseTrace;
    private final Label xLabel, yLabel;

    public Graph(Double side){
        this.side  = side;
        this.stepLength = this.side/Graph.STEPS;
        this.innerStepLength = this.stepLength/Graph.INNERSTEPS;
        this.scale = 1.0/side;

        this.setHeight(this.side+30);
        this.setWidth(this.side+30);
        this.setPadding(new Insets(10,10,10,10));

        graphPane = new Pane();
        graphPane.setMinHeight(this.side);
        graphPane.setMinWidth(this.side);
        graphPane.setMaxHeight(this.side);
        graphPane.setMaxWidth(this.side);
        this.setCenter(graphPane);

        mouseTrace = new HBox();
        mouseTrace.getChildren().add(new Label("X:"));
        xLabel = new Label("0.0");
        xLabel.setMinWidth(50);
        mouseTrace.getChildren().add(xLabel);
        mouseTrace.getChildren().add(new Label("Y:"));
        yLabel = new Label("0.0");
        yLabel.setMinWidth(50);
        mouseTrace.getChildren().add(yLabel);
        mouseTrace.setAlignment(Pos.CENTER);
        mouseTrace.setSpacing(10);

        graphPane.setOnMouseMoved((event)->{
            xLabel.setText(event.getX()+"");
            yLabel.setText((graphPane.getHeight()-event.getY())+"");
        });

        this.setBottom(mouseTrace);
        this.constructGrid();
    }

    private void constructGrid(){
        for(double col=this.side; col>=0; col-=this.stepLength){
            Line liney = new Line();
            liney.setStartX(0);
            liney.setStartY(col);
            liney.setEndX(this.side);
            liney.setEndY(col);
            liney.setStroke(Color.BLACK);
            liney.setStrokeWidth(1);
            graphPane.getChildren().add(liney);

            Label label = new Label(String.valueOf(col));
        }

        for(double col=0; col<=this.side; col+=this.stepLength){
            Line linex = new Line();
            linex.setStartX(col);
            linex.setStartY(0);
            linex.setEndY(this.side);
            linex.setEndX(col);
            linex.setStroke(Color.BLACK);
            linex.setStrokeWidth(1);
            graphPane.getChildren().add(linex);
        }

        for(double col=this.side; col>=0; col-=this.innerStepLength){
            Line liney = new Line();
            liney.setStartX(0);
            liney.setStartY(col);
            liney.setEndX(this.side);
            liney.setEndY(col);
            liney.setStroke(Color.BLACK);
            liney.setStrokeWidth(0.3);
            graphPane.getChildren().add(liney);
        }

        for(double col=0; col<=this.side; col+=this.innerStepLength){
            Line linex = new Line();
            linex.setStartX(col);
            linex.setStartY(0);
            linex.setEndY(this.side);
            linex.setEndX(col);
            linex.setStroke(Color.BLACK);
            linex.setStrokeWidth(0.3);
            graphPane.getChildren().add(linex);
        }
    }

    public void plotPoints(ArrayList<Point> points){
        for(Point point: points){
            graphPane.getChildren().add(point.getPlot(this.scale));
        }
    }

    public void plotPoints(ArrayList<Point> points, Color color){
        for(Point point: points){
            graphPane.getChildren().add(point.getPlot(this.scale,color));
        }
    }

    public void plotPointSegments(ArrayList<Point> points, Color color){
        ArrayList<Segment> segments = new ArrayList<>();

        for(int i=0; i<points.size()-1; i++){
            SampleSegment segment = new SampleSegment();
            segment.setStart(points.get(i));
            segment.setEnd(points.get(i+1));
            segments.add(segment);
        }

        this.plotSegments(segments, color);
    }

    public void plotSegments(ArrayList<Segment> points){
        for(Segment point: points){
            graphPane.getChildren().add(point.getPlot(this.scale));
        }
    }

    public void plotSegments(ArrayList<Segment> points, Color color){
        for(Segment point: points){
            graphPane.getChildren().add(point.getPlot(this.scale, color));
        }
    }
}
