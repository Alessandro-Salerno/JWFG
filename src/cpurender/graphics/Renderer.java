package cpurender.graphics;

import cpurender.graphics.shading.shaders.base.BaseColorShader;
import cpurender.graphics.shading.shaders.base.BaseSkyShader;
import cpurender.graphics.shading.shaders.base.BaseVertexShader;
import geometry.Geometry;
import cpurender.graphics.shading.color.ColorShader;
import cpurender.graphics.shading.vertex.VertexShader;

import java.awt.*;

public class Renderer {
    private Scene scene;
    private FrameBuffer buffer;
    private VertexShader vertexShader;
    private ColorShader colorShader;
    private ColorShader skyShader;

    public Renderer() {
        this.vertexShader = new BaseVertexShader();
        this.colorShader = new BaseColorShader();
        this.skyShader = new BaseSkyShader();
    }

    public Scene getScene() {
        return this.scene;
    }

    public FrameBuffer getBuffer() {
        return this.buffer;
    }

    public VertexShader getVertexShader() {
        return this.vertexShader;
    }

    public ColorShader getColorShader() {
        return this.colorShader;
    }

    public ColorShader getSkyShader() {
        return this.skyShader;
    }

    public void setScene(Scene scene) {
        this.scene = scene;
    }

    public void setBuffer(FrameBuffer buffer) {
        this.buffer = buffer;
    }

    public void setVertexShader(VertexShader vertexShader) {
        this.vertexShader = vertexShader;
    }

    public void setColorShader(ColorShader colorShader) {
        this.colorShader = colorShader;
    }

    public void setSkyShader(ColorShader skyShader) {
        this.skyShader = skyShader;
    }

    public void render() {
        this.skyShader.run();
        this.buffer.clear(this.skyShader.getOutput().getColor());

        for (Geometry item : this.scene.getElements()) {
            this.vertexShader.getInput().setViewportPosition(this.scene.getViewport().getPosition());
            this.vertexShader.getInput().setViewportRotation(this.scene.getViewport().getRotation());

            this.colorShader.getInput().setViewportPosition(this.scene.getViewport().getPosition());
            this.colorShader.getInput().setViewportRotation(this.scene.getViewport().getRotation());
            this.colorShader.run();

            ((Graphics2D) this.buffer.getSwingBuffer()).setColor(this.colorShader.getOutput().getColor());
            ((Graphics2D) this.buffer.getSwingBuffer()).draw(item.toSwingShape(this.vertexShader));
        }
    }
}
