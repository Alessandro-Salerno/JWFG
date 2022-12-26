package cpurender.graphics.shading.shaders.custom;

import cpurender.graphics.shading.vertex.VertexShader;
import geometry.Point3D;

public class WavyVertexShader extends VertexShader {
    @Override
    public void main() {
        double x = this.getInput().getVertex().getX();
        double y = this.getInput().getVertex().getY();
        double z = this.getInput().getVertex().getZ();

        double x1 = x + Math.cos(y);
        double y1 = y + Math.sin(x);
        double z1 = z;

        this.getOutput().setVertex(new Point3D(x1, y1, z1));
    }
}
