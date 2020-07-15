package Finite_diff_and_vol.graphic.graphics;


import Finite_diff_and_vol.graphic.interfaces.Point;
import Finite_diff_and_vol.graphic.interfaces.Segment;
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
}
