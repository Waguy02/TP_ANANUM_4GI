package finiteMethods.graphics;

import finiteMethods.interfaces.Point;
import finiteMethods.interfaces.Segment;
import javafx.scene.paint.Color;
import javafx.scene.shape.Line;

public class SampleSegment implements Segment {
    private Point start;
    private Point end;

    @Override
    public void setStart(Point start) {
        this.start = start;
    }

    @Override
    public Point getStart() {
        return this.start;
    }

    @Override
    public void setEnd(Point end) {
        this.end = end;
    }

    @Override
    public Point getEnd() {
        return this.end;
    }

    @Override
    public Line getPlot(Double scale) {
        return this.getPlot(scale, Segment.LINE_COLOR);
    }

    @Override
    public Line getPlot(Double scale, Color lineColor) {
        Line line = new Line();
        line.setStartX(start.getX()/scale);
        line.setStartY((1/scale)-(start.getY()/scale));
        line.setEndX(end.getX()/scale);
        line.setEndY((1/scale)-(end.getY()/scale));
        line.setStroke(lineColor);
        line.setStrokeWidth(2.5);
        System.out.println(this.start.getX()/scale);

        return line;
    }
}
