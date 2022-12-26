package cpurender.graphics.shading.color;

import cpurender.graphics.shading.Shader;

public abstract class ColorShader implements Shader {
    private ColorShaderData input;
    private ColorShaderData output;

    public ColorShader() {
        this.input = new ColorShaderData();
        this.output = new ColorShaderData();
    }

    public final ColorShaderData getInput() {
        return this.input;
    }

    public final ColorShaderData getOutput() {
        return this.output;
    }

    public final void setInput(ColorShaderData input) {
        this.input = input;
    }

    public final void setOutput(ColorShaderData output) {
        this.output = output;
    }

    public final void run() {
        this.setOutput(new ColorShaderData(this.getInput()));
        this.main();
    }
}
