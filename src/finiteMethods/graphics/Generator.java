package finiteMethods.graphics;

import finiteMethods.interfaces.Point;

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
}