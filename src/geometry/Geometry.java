package geometry;

public abstract class Geometry implements Swingable {
    private final Point3D[] vertices;
    private final Point3D rotation;

    public Geometry(int nvert) {
        this(new Point3D[nvert]);
    }

    public Geometry(Point3D... verts) {
        this.vertices = verts;
        this.rotation = new Point3D(0, 0, 0);
    }

    public Point3D[] getVertices() {
        return this.vertices;
    }

    public Point3D getRotation() {
        return this.rotation;
    }

    public Point3D getVertex(int index) {
        return this.vertices[index];
    }

    public void move(double x, double y, double z) {
        for (Point3D vertex : this.vertices) {
            vertex.setX(vertex.getX() + x);
            vertex.setY(vertex.getY() + y);
            vertex.setZ(vertex.getZ() + z);
        }
    }

    public void move(double x, double y) {
        this.move(x, y, 0);
    }

    public void rotate(double x, double y) {
        this.rotation.setX(this.rotation.getX() + x);
        this.rotation.setY(this.rotation.getY() + y);
    }

    public void rotate(double x) {
        this.rotate(x, 0);
    }

    public double getDistance() {
        return this.getDistance(0, 0, 0);
    }

    public double getDistance(Point3D point) {
        return this.getDistance(point.getX(), point.getY(), point.getZ());
    }

    public double getDistance(Geometry geometry) {
        return this.getDistance(geometry.getX(), geometry.getY(), geometry.getZ());
    }

    public double getDistance(double offX, double offY, double offZ) {
        return this.vertices[0].getDistance(offX, offY, offZ);
    }

    public double getX() {
        return this.vertices[0].getX();
    }

    public double getY() {
        return this.vertices[0].getY();
    }

    public double getZ() {
        return this.vertices[0].getZ();
    }

    public Point3D getPosition() {
        return this.vertices[0];
    }

    public void setX(double x) {
        this.move(x - this.getX(), 0, 0);
    }

    public void setY(double y) {
        this.move(0, y - this.getY(), 0);
    }

    public void setZ(double z) {
        this.move(0, 0, z - this.getZ());
    }

    public void setPosition(double x, double y, double z) {
        this.move(x - this.getX(),
                    y - this.getY(),
                    z - this.getZ());
    }

    public void setPosition(Point3D position) {
        this.setPosition(position.getX(), position.getY(), position.getZ());
    }

    public void setPosition(double x, double y) {
        this.setPosition(x, y, this.getZ());
    }

    public void setRotation(double x, double y) {
        this.rotation.setX(x);
        this.rotation.setY(y);
    }

    public void setRotation(Point3D rotation) {
        this.setRotation(rotation.getX(), rotation.getY());
    }

    public final void introduceYourself() {
        System.out.println(this);
    }

    @Override
    public String toString() {
        return "I am a figure.";
    }
}
