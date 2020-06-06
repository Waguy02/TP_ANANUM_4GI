package finiteMethods.interfaces;

import javafx.scene.paint.Color;
import javafx.scene.shape.Line;

public interface Segment {
    public static final Color LINE_COLOR= Color.AQUA;

    public void setStart(Point start);
    public Point getStart();
    public void setEnd(Point end);
    public Point getEnd();
    public Line getPlot(Double scale);
    public Line getPlot(Double scale, Color lineColor);
}
