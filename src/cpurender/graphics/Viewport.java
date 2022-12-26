package cpurender.graphics;

import geometry.Point3D;

public class Viewport {
    private final Point3D position;
    private final Point3D rotation;


    public Viewport() {
        this.position = new Point3D(0, 0, 0);
        this.rotation = new Point3D(0, 0, 0);
    }

    public Point3D getPosition() {
        return this.position;
    }

    public Point3D getRotation() {
        return this.rotation;
    }
}
