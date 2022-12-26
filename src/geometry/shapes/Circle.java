package geometry.shapes;

import cpurender.graphics.shading.vertex.VertexShader;
import geometry.Geometry;
import geometry.Point3D;

import java.awt.*;
import java.awt.geom.Ellipse2D;

public class Circle extends Geometry {
    private double radius;

    public Circle(double x, double y, double radius) {
        this(new Point3D(x, y, 0), radius);
    }

    public Circle(Point3D position, double radius) {
        super(position);
        this.radius = radius;
    }

    public Circle() {
        this(new Point3D(0, 0, 0), 0);
    }

    public double getRadius() {
        return this.radius;
    }

    public void setRadius(double radius) {
        this.radius = radius;
    }

    @Override
    public Shape toSwingShape(VertexShader vertexShader) {
        vertexShader.run(this.getPosition());
        double x = vertexShader.getOutput().getVertex().getX();
        double y = vertexShader.getOutput().getVertex().getY();

        return new Ellipse2D.Double(x, y, this.radius * 2, this.radius * 2);
    }
}
