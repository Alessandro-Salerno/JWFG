package cpurender.graphics.shading.color;

import geometry.Point3D;

import java.awt.*;

public class ColorShaderData {
    private Color color;
    private Point3D viewportPosition;
    private Point3D viewportRotation;

    public ColorShaderData() {
        this.color = new Color(0, 0, 0);
        this.viewportPosition = new Point3D(0, 0, 0);
        this.viewportRotation = new Point3D(0, 0, 0);
    }

    public ColorShaderData(ColorShaderData src) {
        this.color = src.getColor();
        this.viewportPosition = new Point3D(src.getViewportPosition());
        this.viewportRotation = new Point3D(src.getViewportRotation());
    }

    public Color getColor() {
        return this.color;
    }

    public Point3D getViewportPosition() {
        return this.viewportPosition;
    }

    public Point3D getViewportRotation() {
        return this.viewportRotation;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public void setViewportPosition(Point3D viewportPosition) {
        this.viewportPosition = viewportPosition;
    }

    public void setViewportRotation(Point3D viewportRotation) {
        this.viewportRotation = viewportRotation;
    }
}
