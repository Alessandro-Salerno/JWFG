package geometry;

import cpurender.graphics.shading.vertex.VertexShader;

import java.awt.*;

public interface Swingable {
    Shape toSwingShape(VertexShader vertexShader);
}
