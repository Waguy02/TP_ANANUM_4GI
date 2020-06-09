package finiteMethods.interfaces;

import javafx.scene.paint.Color;

/**
 * This class represents an (x,y) point on the grid.
 */
public interface Point {
    public static final Color RECTANGLE_COLOR = Color.GREEN;

    public void setX(Double x);
    public void setY(Double y);
    public Double getX();
    public Double getY();
}
