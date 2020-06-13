package finiteMethods.graphics;

import diff_1D.interfaces.Base1DFunction;
import diff_1D.interfaces.IGraphic;
import finiteMethods.interfaces.Point;
import finiteMethods.interfaces.Segment;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Line;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;

import java.text.DecimalFormat;
import java.util.ArrayList;

public class Graph extends BorderPane implements IGraphic {
    private static final double STEPS=10;
    private static  final double INNERSTEPS =10;
    private final DecimalFormat dformat = new DecimalFormat("###.#####");
    /**
     * Size of Grid
     */
    private final Double side;
    /**
     * Even step between two major divisions
     */
    private final Double stepLength;
    /**
     * Even step between two minor divisions
     */
    private final Double innerStepLength;
    /**
     * Scale value on X-axis
     */
    private Double scaleX;
    /**
     * Minimum value that X can take
     * This value is used to determine the construction of the grid
     * and the representation of the function
     */
    private Double minX;
    /**
     * Maximum value that X can take.
     * Used for the same purpose as minimum value.
     */
    private Double maxX;
    /**
     * Scale value on Y axis
     */
    private Double scaleY;
    /**
     * Minimum value that Y can take
     * This value is used to determine the construction of the grid
     * and the representation of the function
     */
    private Double minY;
    /**
     * Maximum value that Y can take.
     * Used for the same purpose as minimum value.
     */
    private Double maxY;
    /**
     * Graph container
     */
    private final Pane graphPane;
    /**
     * Pane representing current position of mouse.
     */
    private final HBox mouseTrace;
    /**
     * labels containing various values of x and y at current mouse position.
     */
    private final Label xLabel, yLabel;

    public Graph(){
        this(500.0);
    }

    public Graph(Double side){
        this.side  = side;
        this.stepLength = this.side/Graph.STEPS;
        this.innerStepLength = this.stepLength/Graph.INNERSTEPS;

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
    }

    private void constructGrid(){

        //Display current position of mouse on grid
        graphPane.setOnMouseMoved((event)->{
            xLabel.setText(dformat.format((event.getX()*this.scaleX)+this.minX));
            yLabel.setText(dformat.format(
                    (graphPane.getHeight()-event.getY())*this.scaleY + this.minY));
        });
        this.setBottom(mouseTrace);

        //Plot major divisions on both axis
        for(double col=this.side; col>=0; col-=this.stepLength){
            Line liney = new Line();
            liney.setStartX(0);
            liney.setStartY(col);
            liney.setEndX(this.side);
            liney.setEndY(col);
            liney.setStroke(Color.BLACK);
            liney.setStrokeWidth(1);
            graphPane.getChildren().add(liney);

            Rectangle rect = new Rectangle();
            rect.setWidth(15);
            rect.setHeight(15);
            rect.setFill(Color.WHITE);

            StackPane labelPane = new StackPane();
            labelPane.setMaxHeight(rect.getHeight());
            labelPane.setMaxWidth(rect.getWidth());
            labelPane.setLayoutX(-50);
            labelPane.setLayoutY(col-7.5);
            labelPane.getChildren().add(rect);
            labelPane.getChildren().add(new Text(dformat.format(
                    (graphPane.getHeight()-col)*this.scaleY+this.maxY)));

            graphPane.getChildren().add(labelPane);
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

            Rectangle rect = new Rectangle();
            rect.setWidth(15);
            rect.setHeight(15);
            rect.setFill(Color.WHITE);

            StackPane labelPane = new StackPane();
            labelPane.setMaxHeight(rect.getHeight());
            labelPane.setMaxWidth(rect.getWidth());
            labelPane.setLayoutY(this.side+8);
            labelPane.setLayoutX(col-7.5);
            labelPane.getChildren().add(rect);
            labelPane.getChildren().add(new Text(dformat.format((col*this.scaleX)+this.minX)));

            graphPane.getChildren().add(labelPane);
        }

        //Construct minor divisions on both axis
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

    private void plotPointSegments(ArrayList<Point> points){
        ArrayList<Segment> segments = new ArrayList<>();

        for(int i=0; i<points.size()-1; i++){
            SampleSegment segment = new SampleSegment();
            segment.setStart(points.get(i));
            segment.setEnd(points.get(i+1));
            segments.add(segment);
        }

        this.plotSegments(segments);
    }

    private Rectangle getPointPlot(Point point) {
        Rectangle rect = new Rectangle();
        rect.setX((point.getX()/this.scaleX)-2.5);
        rect.setY((1/this.scaleY)-(point.getY()/this.scaleY)-2.5);
        rect.setWidth(5);
        rect.setHeight(5);
        rect.setFill(Point.RECTANGLE_COLOR);

        return rect;
    }

    private void plotSegments(ArrayList<Segment> points){
        for(Segment point: points){
            graphPane.getChildren().add(this.getSegmentPlot(point));
        }
    }

    private Line getSegmentPlot(Segment segment) {
        Line line = new Line();
        line.setStartX((1/this.scaleX)+segment.getStart().getX()/this.scaleX);
        line.setStartY((1/this.scaleY)-(segment.getStart().getY()/this.scaleY));

        line.setEndX((1/this.scaleX)+segment.getEnd().getX()/this.scaleX);
        line.setEndY((1/this.scaleY)-(segment.getEnd().getY()/this.scaleY));

        line.setStroke(Segment.LINE_COLOR);
        line.setStrokeWidth(2);

        return line;
    }

    @Override
    public void show(Base1DFunction function, double[] bounds) {
        /**
         * Cross check the values of the bounds array to ensure they are valid.
         * This could be done otherwise by modifying the function in the interface so
         * that i throws an exception when this is the case.
         */
        try {
            if(bounds.length<2){
                throw new Exception("Bounds array does not have the required number of values");
            }
            if (bounds[0]>=bounds[1]){
                throw new Exception("Invalid bound values in bounds array. Lower value must be strictly less than upper value");
            }
        }catch (Exception e){
            e.printStackTrace();
            return;
        }

        /**
         * Calculate values and plot graph.
         *
         */
        this.minX = bounds[0];
        this.maxX = bounds[1];
        this.scaleX = (1.0/this.side)*(this.maxX-this.minX);
        this.minY = Double.MAX_VALUE;
        this.maxY = Double.MIN_VALUE;

        double xStep = (this.maxX-this.minX)/1000;

        ArrayList<Point> points = new ArrayList<>();

        for(double x=this.minX; x<=this.maxX; x+=xStep){
            Point p = new Point() {
                private double x;
                private double y;
                @Override
                public void setX(Double x) {
                    this.x = x;
                }

                @Override
                public void setY(Double y) {
                    this.y = y;
                }

                @Override
                public Double getX() {
                    return this.x;
                }

                @Override
                public Double getY() {
                    return this.y;
                }
            };
            p.setX(x);
            double y = function.run(x);
            p.setY(y);
            if(y<this.minY) this.minY = y;
            if(y>this.maxY) this.maxY = y;

            points.add(p);
        }

        this.scaleY = (1.0/this.side)*(this.maxY-this.minY);
        this.constructGrid();
        this.plotPointSegments(points);
    }
}

