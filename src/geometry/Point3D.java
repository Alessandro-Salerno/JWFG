package geometry;

public class Point3D {
    private double x;
    private double y;
    private double z;

    public Point3D(double x, double y, double z) {
        this.x = x;
        this.y = y;
        this.z = z;
    }

    public Point3D(Point3D src) {
        this.x = src.getX();
        this.y = src.getY();
        this.z = src.getZ();
    }

    public Point3D() { }

    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }

    public double getZ() {
        return z;
    }

    public void setX(double x) {
        this.x = x;
    }

    public void setY(double y) {
        this.y = y;
    }

    public void setZ(double z) {
        this.z = z;
    }

    public double getDistance() {
        return this.getDistance(0, 0, 0);
    }

    public double getDistance(Point3D other) {
        return this.getDistance(other.getX(), other.getY(), other.getZ());
    }

    public double getDistance(double offX, double offY, double offZ) {
        double cat = Math.sqrt(Math.pow(this.getX() - offX  , 2)
                + Math.pow(this.getY() - offY, 2));

        return Math.sqrt(Math.pow(cat, 2)
                + Math.pow(this.getZ() - offZ, 2));
    }

    public boolean equals(Point3D p) {
        return this.x == p.getX()
                && this.y == p.getY()
                && this.z == p.getZ();
    }

    @Override
    public String toString() {
        return "geometry.Point3D{" +
                "x=" + x +
                ", y=" + y +
                ", z=" + z +
                '}';
    }
}
