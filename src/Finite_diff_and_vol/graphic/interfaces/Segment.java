package Finite_diff_and_vol.graphic.interfaces;

import javafx.scene.paint.Color;

/**
 * This class represents the line linking two points on
 * on the graph. That is (x1,y1)-(x2,y2)
 */
public interface Segment {
    public static final Color LINE_COLOR= Color.TOMATO;

    public void setStart(Point start);
    public Point getStart();
    public void setEnd(Point end);
    public Point getEnd();
}
