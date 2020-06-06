package finiteMethods.interfaces;

import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

public interface Point {
    public static final Color RECTANGLE_COLOR = Color.GREEN;

    public void setX(Double x);
    public void setY(Double y);
    public Double getX();
    public Double getY();
    public Rectangle getPlot(Double scale);
    public Rectangle getPlot(Double scale, Color lineColor);
}
