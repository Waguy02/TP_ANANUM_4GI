package finiteMethods.graphics;

import finiteMethods.interfaces.Point;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;
import javafx.scene.shape.Rectangle;

public class SamplePoint implements Point {
    private Double x;
    private Double y;
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

    @Override
    public Rectangle getPlot(Double scale) {
        return this.getPlot(scale, Point.RECTANGLE_COLOR);
    }

    @Override
    public Rectangle getPlot(Double scale, Color lineColor) {
        Rectangle rect = new Rectangle();
        rect.setX((this.x/scale)-2.5);
        rect.setY((1/scale)-(this.y/scale)-2.5);
        rect.setWidth(5);
        rect.setHeight(5);
        rect.setFill(lineColor);

        return rect;
    }
}
