package geometry.shapes;

import geometry.Point3D;
import geometry.Poly;

public class Line extends Poly {
    public Line(double x1, double y1, double z1,
                double x2, double y2, double z2) {
        super(new Point3D(x1, y1, z1),
                new Point3D(x2, y2, z2));
    }

    public Line(double x1, double y1,
                double x2, double y2) {
        super(new Point3D(x1, y1, 0),
                new Point3D(x2, y2, 0));
    }

    @Override
    public String toString() {
        return "I am a line";
    }
}
