package geometry.shapes;

import geometry.Point3D;
import geometry.Poly;

public class Square extends Poly {
    public Square(double x, double y, double side) {
        super(new Point3D(x, y, 0),
                new Point3D(x, y + side, 0),
                new Point3D(x + side, y + side, 0),
                new Point3D(x + side, y, 0));
    }
}
