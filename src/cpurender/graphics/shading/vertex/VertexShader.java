package cpurender.graphics.shading.vertex;

import cpurender.graphics.shading.Shader;
import geometry.Point3D;

public abstract class VertexShader implements Shader {
    private VertexShaderData input;
    private VertexShaderData output;

    public VertexShader() {
        this.input = new VertexShaderData();
        this.output = new VertexShaderData();
    }

    public final VertexShaderData getInput() {
        return this.input;
    }

    public final VertexShaderData getOutput() {
        return this.output;
    }

    public final void setInput(VertexShaderData input) {
        this.input = input;
    }

    public final void setOutput(VertexShaderData output) {
        this.output = output;
    }

    public final void run(Point3D vertex) {
        this.getInput().setVertex(vertex);
        this.setOutput(new VertexShaderData(this.getInput()));
        this.main();
    }
}
