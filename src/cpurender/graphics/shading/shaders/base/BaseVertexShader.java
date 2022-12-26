package cpurender.graphics.shading.shaders.base;

import cpurender.graphics.shading.vertex.VertexShader;
import geometry.Point3D;

public class BaseVertexShader extends VertexShader {
    @Override
    public void main() {
        this.setOutput(this.getInput());
    }
}
