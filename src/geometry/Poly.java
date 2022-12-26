package geometry;

import cpurender.graphics.shading.vertex.VertexShader;

import java.awt.*;

public abstract class Poly extends Geometry {
    public Poly(int nvert) {
        super(nvert);
    }

    public Poly(Point3D... verts) {
        super(verts);
    }

    @Override
    public Shape toSwingShape(VertexShader vertexShader) {
        final int[] xPoly = new int[this.getVertices().length];
        final int[] yPoly = new int[this.getVertices().length];

        for (int i = 0; i < this.getVertices().length; i++) {
            vertexShader.run(this.getVertex(i));
            double x = vertexShader.getOutput().getVertex().getX();
            double y = vertexShader.getOutput().getVertex().getY();

            xPoly[i] = (int) Math.round(x);
            yPoly[i] = (int) Math.round(y);
//
//            /// Apply rotation to screen coordinates
//            double theta = this.getRotation().getX();
//            double transX = xPoly[i] - this.getCenter().getX();
//            double transY = yPoly[i] - this.getCenter().getY();
//
//            int x = (int) Math.round((transX * Math.cos(theta) + (transY * Math.sin(theta))));
//            int y = (int) Math.round((transY * Math.cos(theta) + (transX * Math.sin(theta))));
//
//            xPoly[i] = x;
//            yPoly[i] = y;
        }

        return new Polygon(xPoly, yPoly, xPoly.length);
    }
}
