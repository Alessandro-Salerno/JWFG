package cpurender.graphics.shading.vertex;

import geometry.Point3D;

public class VertexShaderData {
    private Point3D vertex;
    private Point3D viewportPosition;
    private Point3D viewportRotation;

    public VertexShaderData() {
        this.vertex = new Point3D(0, 0, 0);
        this.viewportPosition = new Point3D(0, 0, 0);
        this.viewportRotation = new Point3D(0, 0, 0);
    }

    public VertexShaderData(VertexShaderData src) {
        this.vertex = new Point3D(src.getVertex());
        this.viewportPosition = new Point3D(src.getViewportPosition());
        this.viewportRotation = new Point3D(src.getViewportRotation());
    }

    public Point3D getVertex() {
        return this.vertex;
    }

    public Point3D getViewportPosition() {
        return this.viewportPosition;
    }

    public Point3D getViewportRotation() {
        return this.viewportRotation;
    }

    public void setVertex(Point3D vertex) {
        this.vertex = vertex;
    }

    public void setViewportPosition(Point3D viewportPosition) {
        this.viewportPosition = viewportPosition;
    }

    public void setViewportRotation(Point3D viewportRotation) {
        this.viewportRotation = viewportRotation;
    }
}
