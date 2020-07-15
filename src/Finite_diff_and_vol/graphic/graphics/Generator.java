package Finite_diff_and_vol.graphic.graphics;



import Finite_diff_and_vol.graphic.interfaces.Point;

import java.util.ArrayList;

public class Generator {

    public static ArrayList<Point> generateSquares(double start, double end, int count){
        ArrayList<Point> points = new ArrayList<>();
        double step = (end-start)/count;

        for(double val=start; val<=end; val+=step){
            Point point = new SamplePoint();
            point.setX(val);
            point.setY(val*val);

            points.add(point);
        }

        return points;
    }

    public static ArrayList<Point> generateInverseSquares(double start, double end, int count){
        ArrayList<Point> points = new ArrayList<>();
        double step = (end-start)/count;

        for(double val=start; val<=end; val+=step){
            Point point = new SamplePoint();
            point.setY(val);
            point.setX(val*val);

            points.add(point);
        }

        return points;
    }
}
