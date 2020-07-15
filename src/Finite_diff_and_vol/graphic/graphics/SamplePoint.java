package Finite_diff_and_vol.graphic.graphics;

import Finite_diff_and_vol.graphic.interfaces.Point;

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
}
